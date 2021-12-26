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

import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.CommentDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
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
		if ( user == null ) return "redirect:/artizen/artwork/main";
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
			}
			model.addAttribute("profile",bloginfoDTO);
			model.addAttribute("creator",creator);
			return "artWork/blog";
			
		}else {
			model.addAttribute("message","잘못된 접근입니다.");
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
	
	
	@GetMapping("/artwork/detail/{imageId}")
	public String ArtWorkDatail(@PathVariable Long imageId,
								@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user, Model model) {
		
		ArtDetailDTO detail = artService.clickImageAction(imageId);
		model.addAttribute("artwork",detail);
		if ( user != null ) {
			Long userid = artWorkService.findByUserId(user);
			model.addAttribute("userid",userid);
			Long creator = artWorkService.findByCreator(userid);
			model.addAttribute("creator",creator);
			Long artworkId = imageId;
			model.addAttribute("artworkId",artworkId);
		}else {
			model.addAttribute("userid",null);
		}
		return "artWork/ArtWorkDetail";
	}
	
	@ResponseBody
	@PostMapping("/artwork/detail/comment/save")
	public void commentSave( @ModelAttribute CommentDTO commentDto ) {
		String message = artService.InsertComment(commentDto);
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
			return "artWork/main";
		}else if( user != null ) { // 로그인 상태일 경우,
			// 현재 로그인 된 유저의 유저 아이디값
			Long id = artWorkService.findByUserId(user);
			model.addAttribute("userid",id);
			// 현재 로그인 된 유저의 크리에이터 아이디값
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
		return "artWork/main";
	}
	@GetMapping("/login/check/creator")
	public String loginCheckForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
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

	// 수묵화 상세 페이지
	@GetMapping("/artwork/ink")
	public String inkpainting(Model model) {

		return "artWork/artWorkInkPainting";
	}

	// 채색화 상세 페이지
	@GetMapping("/artwork/color")
	public String coloring(Model model) {

		return "artWork/artWorkColoring";
	}

	// 풍경화 상세 페이지
	@GetMapping("/artwork/landscape")
	public String landscape(Model model) {

		return "artWork/artWorkLandscape";
	}

	// 인물화 상세 페이지
	@GetMapping("/artwork/figure")
	public String figure(Model model) {

		return "artWork/artWorkFigure";
	}

	// 추상화 상세 페이지
	@GetMapping("/artwork/abstract")
	public String artworkAbsract(Model model) {

		return "artWork/artWorkAbstract";
	}

	// 정물화 상세 페이지
	@GetMapping("/artwork/still")
	public String still(Model model) {

		return "artWork/artWorkStill";
	}

	// 팝아트 상세 페이지
	@GetMapping("/artwork/pop")
	public String popart(Model model) {

		return "artWork/artWorkPop";
	}

}
	