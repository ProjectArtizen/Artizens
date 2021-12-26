package artizens.controller;

import java.util.ArrayList;
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

import artizens.controller.dto.artwork.ArtCommentDTO;
import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.CommentDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.mapper.ArtMapper;
import artizens.mapper.ArtWorkMapper;
import artizens.mapper.UserMapper;
import artizens.mapper.dto.ArtWorkMainDto;
import artizens.service.ArtService;
import artizens.service.ArtWorkService;
import artizens.web.aws.FileUploadService;
import artizens.web.session.SessionConst;

@Controller
public class ArtController {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtController.class);
	
	@Autowired FileUploadService fileUploadService;
	@Autowired UserMapper userMapper;
	@Autowired ArtService artService;
	@Autowired ArtWorkService artWorkService;
	@Autowired ArtWorkMapper artWorkMapper;
	
	@GetMapping("/blog/my/{creator}")
	public String userBlog( @PathVariable Long creator, RedirectAttributes redirectAttribute,
							@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user,
							String createId,
							Model model) throws Exception {
		
		if ( user == null ) return "redirect:/";
		Long userid = artWorkService.findByUserId(user);
		Long creator_id = artWorkService.findByCreator(userid);
		if ( creator_id == creator ) {
			List<StoreFileDTO> store = artService.findByAll( creator );
			model.addAttribute("store",store);
			List<StoreFileDTO> profile = artService.findByProfile( creator );
			BlogInfoDTO bloginfoDTO = new BlogInfoDTO();
			for( StoreFileDTO a : profile ) {
				bloginfoDTO.setNickname(a.getNickname());
				bloginfoDTO.setImages(a.getProfileImage());
				bloginfoDTO.setContent(a.getContent());
			}
			LOGGER.info("블로그프로필정보={}",bloginfoDTO);
			LOGGER.info("content={}",bloginfoDTO.getContent());
			model.addAttribute("profile",bloginfoDTO);
			model.addAttribute("creator",creator);
			return "artWork/ArtWorkMyBlog";
			
		}else {
			model.addAttribute("message","잘못된 접근입니다.");
		}
		return "artWork/ArtWorkMyBlog";
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
		List<StoreFileDTO> profile = artService.findByProfile( creatorid );
		BlogInfoDTO bloginfo = new BlogInfoDTO();
		for( StoreFileDTO a : profile ) {
			bloginfo.setNickname(a.getNickname());
			bloginfo.setContent(a.getContent());
			bloginfo.setProfile(a.getProfileImage());
		}		
		model.addAttribute("profile",bloginfo);
		
		List<BlogInfoDTO> creatorinfo = artService.findByCreatorForBlogAll( creatorid );
		model.addAttribute("creatorinfo",creatorinfo);
		return "/artWork/ArtWorkOtherBlog";
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
	
	@GetMapping
	public String artworkMain(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			Model model) {
		
		if (user == null) { // 비회원일 경우
			List<ArtWorkMainDto> result = artWorkService.selectAll();
			model.addAttribute("result", result);
			return "artWork/ArtWorkMain";
		}else if( user != null ) { // 로그인 상태일 경우,
			Long id = artWorkService.findByUserId(user);
			model.addAttribute("userid",id);
			Long creator = artWorkService.findByCreator(id);
			
			List<ArtWorkMainDto> result2 = artWorkService.selectAll();
			model.addAttribute("result", result2);
			
			if ( creator == 0 || creator == null ) { // 크리에이터 아이디가 없는 경우,
				model.addAttribute("creator", null);
			}else if( creator > 0 || creator != null ){ // 크리에이터 아이디가 있는 경우,
				
				// 크리에이터
				String info = artWorkService.findByAll( creator );
				String nick = info.split("/")[0];
				String cid = info.split("/")[1];
				
				// 아이디 값
				model.addAttribute("creatorId",cid);
				model.addAttribute("creator",creator);
				// 닉네임 값
				model.addAttribute("nickname",nick);
				
				// 모든 작품들 
				List<ArtWorkMainDto> result = artWorkService.selectAll();
				model.addAttribute("result", result);
			}
		}
		return "artWork/ArtWorkMain";
	}
	
	@GetMapping("/artwork/detail/{imageId}")
	public String ArtWorkDatail(@PathVariable Long imageId,
								@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user, Model model) {
		
		ArtDetailDTO detail = artService.clickImageAction(imageId);
		List<ArtCommentDTO> commentList = artService.findByCommentAll(detail.getArtworkId());
		model.addAttribute("artwork",detail);
		model.addAttribute("comment",commentList);
		if ( user != null ) {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("userid",userid);
			Long creator = artWorkService.findByCreator(userid);
			model.addAttribute("creator",creator);
			model.addAttribute("imageId",imageId);
		}else {
			model.addAttribute("userid",null);
		}
		return "artWork/ArtWorkDetail";
	}
	
	
	@PostMapping("/artwork/detail/comment/save/{imageId}")
	public String commentSave( @PathVariable Long imageId,
							   @ModelAttribute CommentDTO commentDto, Model model ) {
		String message = artService.InsertComment(commentDto);
		LOGGER.info("message={}",message);
		if ( message == "success" ) {
			model.addAttribute("message","댓글등록성공");
			model.addAttribute("imageURL",imageId);
			return "include/Alert";
		}else {
			model.addAttribute("message","댓글등록실패");
			return "include/Alert";
		}
	}
	
	@GetMapping("/login/check/creator")
	public String loginCheckForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
		if ( user == null ) {
			model.addAttribute("message","잘못된 접근입니다");
			return "include/Alert";
		}else {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("userid",userid);
			Long creator = artWorkService.findByCreator(userid);
			if ( creator == null || creator == 0 ) {
				model.addAttribute("creator_id",null);
				model.addAttribute("message","크리에이터로 등록되지 않은 아이디 입니다");
				return "include/Alert";
			}else {
				model.addAttribute("creator_id",creator);
				model.addAttribute("message","크리에이터로 등록된 아이디입니다");
				return "include/Alert";
			}
		}
	}

	// 작품 카테고리별  상세 페이지
	@GetMapping("/artwork/{page}")
	public String inkpainting(@PathVariable String page, Model model,
							  @SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user) {
		if ( user == null ) {
			model.addAttribute("user",0);
		}else {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("user",userid);
		}
		String category = "";
		List<BlogInfoDTO> store = new ArrayList<BlogInfoDTO>();
		if (page.equals("ink")) {
			category = "수묵화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("color")) {
			category = "채색화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("landscape")) {
			category = "풍경화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("figure")) {
			category = "인물화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("abstract")) {
			category = "추상화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("still")) {
			category = "정물화";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else if (page.equals("pop")) {
			category = "팝아트";
			store = artService.findByCategory(page);
			model.addAttribute("page",category);
			model.addAttribute("store",store);
			return "artWork/ArtCategoryDetailPage";
		}else {
			model.addAttribute("message","잘못된 접근입니다");
			return "include/Alert";
		}
	}
	
	@GetMapping("/mypage/{userid}")
	public String mypage(@PathVariable Long userid, Model model, 
						 @SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user) {
		
		return "";
	}

}
	