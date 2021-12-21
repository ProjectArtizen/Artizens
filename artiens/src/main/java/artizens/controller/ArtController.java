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

import artizens.controller.dto.artwork.BlogInfoDTO;
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
	
	@GetMapping("/blog/my/{userid}")
	public String userBlog( @PathVariable Long userid, RedirectAttributes redirectAttribute,
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
			Long creator = artWorkService.findByCreator(userid);
			
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
				model.addAttribute("creator",creator);
				return "artWork/blog";
			}else if ( create_id != creator ) {
				model.addAttribute("message","크리에이터 아이디가 다름");
				return "include/Alert";
			}
		}
		
		return "artWork/blog";
	}
	
	@GetMapping("/blog/{creatorid}")
	public String otherBlog(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
							@PathVariable Long creatorid,Model model ) throws Exception {
		
		if ( user == null ) {
			model.addAttribute("userid",0);
		}else {
			Long id = artWorkService.findByUserId(user);
			model.addAttribute("userid",id);
		}
		
		String nickname = artService.findByCreatorName(creatorid);
		String profileImage = artService.findByCreatorImage(creatorid);
		model.addAttribute("nickname",nickname);
		model.addAttribute("profileImage",profileImage);
		
		List<BlogInfoDTO> creatorinfo = artService.findByCreatorForBlogAll( creatorid );
		model.addAttribute("creatorinfo",creatorinfo);
		return "/artWork/otherBlog";
	}
	
	@GetMapping("/upload")
	public String FileUpload(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							 Model model) {
		
		Long id = artWorkService.findByUserId(user);
		Long create_id = artWorkService.findByCreator(id);
		
		model.addAttribute("userid", id);
	
		if ( create_id == 0 || create_id == null ) {
			model.addAttribute("creatorNickname",null);
		}else {
			String nickname = "";
			List<StoreFileDTO> profile = artService.findByProfile( create_id );
			for( StoreFileDTO a : profile ) nickname = a.getNickname();
			
			model.addAttribute("Nickname",nickname);
			model.addAttribute("creator",create_id);
		}
		
		return "FileUpload/Upload";
	}
	
	@PostMapping("/upload")
	public String FileSave( @ModelAttribute UploadFileDTO uploadfiledto, Model model ) throws Exception {
		
		String message = "";
		Long creatorId = artService.findByCreator( uploadfiledto.getNickname() );
		if ( creatorId == null ) creatorId = 0L;
		// 새로운 크리에이터 등록 및 작품 등록
		if ( creatorId == 0 ) {
			String upload = artService.noneCreatorUpload(uploadfiledto);
			if ( upload.equals("success") ) {
				message = "Success insert creator";
				model.addAttribute("message",message);
				return "include/Alert";
			}else { 
				message = "fail";
				model.addAttribute("message",message);
				return "include/Alert";
			}
		// 기존 크리에이터 값은 존재하며 작품 등록	
		}else if( creatorId != 0 ) {
			String upload = artService.insertImageUpload(uploadfiledto);
			
			if (upload.equals("success")) {
				message = "Success image upload";
				model.addAttribute("message",message);
				return "include/Alert";
			}else {
				model.addAttribute("message","fail");
				return "include/Alert";
			}
		}
		return "FileUpload/Upload";
	}
}
	