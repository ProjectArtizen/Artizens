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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/blog/my/{creatorname}")
	public String userBlog( @PathVariable String creatorname, RedirectAttributes redirectAttribute,
							@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							String createId,
							Model model) throws Exception {
			
		if ( user == null ) {
			return "redirect:/artizen/artwork/main";
		}else {
			
			// 로그인 유저의 아이디값,
			Long id = artWorkService.findByUserId(user);
			// 해당 아이디값을 가진 사람의 크리에이터 아이디값
			Long create_id = artWorkService.findByCreator(id);
			// 현재 페이지의 크리에이터 아이디
			Long creator = artWorkService.findByCreatorId( creatorname );
			
			if ( create_id == creator ) {
				
				List<StoreFileDTO> store = artService.findByAll( creator );
				LOGGER.info("스토어이미지={}",store);
				model.addAttribute("store",store);
				
				List<StoreFileDTO> profile = artService.findByProfile( creator );
				String nickname = "";
				String profileImage = "";
				for( StoreFileDTO a : profile ) {
					nickname = a.getNickname();
					profileImage = a.getProfileImage();
				}
				if ( profileImage == null || profileImage.equals("") ) {
					profileImage = "https://sunminki.s3.ap-northeast-2.amazonaws.com/b07b91a8-3a31-4ceb-a505-06a68d3ecf47.png";
				}
				model.addAttribute("profileimage",profileImage);
				model.addAttribute("nickname",nickname);
				return "artWork/blog";
			}else if ( create_id != creator ) {
				return "redirect:/artizen/artwork/main";
			}
		}
		
		return "artWork/blog";
	}
	
	@GetMapping("/blog/{id}")
	public String otherBlog(@PathVariable Long id ) throws Exception {
		
		Long Creator = artWorkService.findByCreator(id);
		
		return "/artWork/blog";
	}
	
	@GetMapping("/upload")
	public String FileUpload(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							 Model model) {
		
		Long id = artWorkService.findByUserId(user);
		Long create_id = artWorkService.findByCreator(id);
		
		model.addAttribute("userid", id);
	
		if ( create_id == 0 ) {
			model.addAttribute("creatorNickname",null);
		}else {
			List<StoreFileDTO> profile = artService.findByProfile( create_id );
			String nickname = "";
			
			for( StoreFileDTO a : profile ) {
				nickname = a.getNickname();
			}
			model.addAttribute("Nickname",nickname);
		}
		
		return "FileUpload/Upload";
	}
	
	@PostMapping("/upload")
	public String FileSave( @ModelAttribute UploadFileDTO uploadfiledto, Model model ) throws Exception {
		
		LOGGER.info("UserProfileId={}",uploadfiledto.getUserProfileId());
		String result = artService.noneCreatorUpload(uploadfiledto);
		String message = "";
		if ( result.equals("success") ) {
			message = "ok";
			model.addAttribute("message",message);
			return "include/Alert";
		}
		
		return "FileUpload/Upload";
	}
}
	