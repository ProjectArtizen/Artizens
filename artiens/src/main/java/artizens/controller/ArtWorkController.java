package artizens.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import artizens.controller.dto.UploadImageDTO;
import artizens.controller.dto.artwork.CreatorDTO;
import artizens.controller.dto.artwork.InsertDto;
import artizens.domain.ArtWork;
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
@RequestMapping("/artizen")
public class ArtWorkController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkController.class);

	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	UserMapper userMapper;
	@Autowired
	ArtWorkMapper artWorkMapper;
	@Autowired
	ArtWorkService artWorkService;
	@Autowired
	ArtService artService;

	/*
	 * @GetMapping("/artWorkMain") public String artworkMain() {
	 * List<ArtWorkMainDto> result = artWorkMapper.findArtWorkMainAll(); for
	 * (ArtWorkMainDto artWorkMainDto : result) {
	 * System.out.println("artWorkMainDto = "+ artWorkMainDto.getTitle()); } return
	 * "artWork/artWorkMain"; }
	 */

	// 작품 메인 페이지
	@GetMapping("/artwork/main")
	public String artworkMain(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			Model model) {
		
		
		if (user == null) { // 비회원일 경우
			List<ArtWorkMainDto> result = artWorkService.selectAll();
			model.addAttribute("result", result);
			return "artWork/artWorkMain";
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

		
		
		return "artWork/artWorkMain";
	}

	// 수묵화 상세 페이지
	@GetMapping("/artWorkInkPainting")
	public String inkpainting(Model model) {

		return "artWork/artWorkInkPainting";
	}

	// 채색화 상세 페이지
	@GetMapping("/artWorkColoring")
	public String coloring(Model model) {

		return "artWork/artWorkColoring";
	}

	// 풍경화 상세 페이지
	@GetMapping("/artWorkLandscape")
	public String landscape(Model model) {

		return "artWork/artWorkLandscape";
	}

	// 인물화 상세 페이지
	@GetMapping("/artWorkFigure")
	public String figure(Model model) {

		return "artWork/artWorkFigure";
	}

	// 추상화 상세 페이지
	@GetMapping("/artWorkAbstract")
	public String artworkAbsract(Model model) {

		return "artWork/artWorkAbstract";
	}

	// 정물화 상세 페이지
	@GetMapping("/artWorkStill")
	public String still(Model model) {

		return "artWork/artWorkStill";
	}

	// 팝아트 상세 페이지
	@GetMapping("/artWorkPop")
	public String popart(Model model) {

		return "artWork/artWorkPop";
	}

}
