package artizens.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.mapper.UserMapper;
import artizens.service.ArtService;
import artizens.service.ArtWorkService;
import artizens.web.aws.FileUploadService;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/artizen")
public class ArtController {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtController.class);
	
	@Autowired FileUploadService fileUploadService;
	@Autowired UserMapper userMapper;
	@Autowired ArtService artService;
	@Autowired ArtWorkService artWorkService;
	
	@GetMapping("/blog/{blogURL}")
	public String userBlog( @PathVariable String blogURL, RedirectAttributes redirectAttribute,
							@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							Model model) throws Exception {
			
			Long id = artWorkService.findByUserId(user);
			Long cid = artWorkService.findByCreatorId(id);
			
			// 현재 로그인한 사람이 크리에이터라면 자신의 블로그로 이동.
			if ( cid > 0 ) {
				String email = user.getEmail();
				String[] username = email.split("@");
				blogURL = username[0];
				model.addAttribute("blogURL", blogURL );
				
				// 해당 크리에이터의 이미지 뿌림
				List<StoreFileDTO> store = artService.findByAll( cid );
				model.addAttribute("store",store);
				
				// 해당 크리에이터의 프로필 정보
				List<StoreFileDTO> profile = artService.findByProfile( cid );
				
				String nickname = "";
				String profileImage = "";
				
				for( StoreFileDTO creator : profile ) {
					nickname = creator.getNickname();
					profileImage = creator.getProfileImage();
				}
				
				if ( profileImage == null || profileImage.isEmpty() ) model.addAttribute("profileimage", "");
				
				model.addAttribute("profileimage",profileImage);
				model.addAttribute("nickname",nickname);
			}
		
		return "artWork/blog";
	}
	
	
	@GetMapping("/upload")
	public String FileUpload(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							 Model model) {
		
			model.addAttribute("userid",user.getId());
		
			if ( user.getCreator() == null ) {
				model.addAttribute("Creator",null);
			}else {
				model.addAttribute("Creator",user.getCreator().getNickName());
			}
		
		return "FileUpload/Upload";
	}
	
	@PostMapping("/upload")
	public String FileSave( @ModelAttribute UploadFileDTO uploadfiledto, Model model ) throws Exception {
		
		String result = artService.insertImageUpload( uploadfiledto );
		if ( result.equals("success") ) {
			model.addAttribute("redirectURL","upload");
			return "redirect:include/Alert";
		}
		return "FileUpload/Upload";
		
	}
}
	