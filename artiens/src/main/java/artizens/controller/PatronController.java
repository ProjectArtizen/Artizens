package artizens.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.controller.dto.patron.PatronRegisterDto;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.UserProfile;
import artizens.repository.querydsl.patron.PatronCreatorDto;
import artizens.service.CreatorService;
import artizens.service.PatronService;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/artizen/patron")
public class PatronController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatronController.class);
	
	@Autowired PatronService patronService;
	@Autowired CreatorService creatorService;
	
	@GetMapping
    public String patronMain(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
    		Model model){
		LOGGER.info("user={}",user);
        model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
        return "thymeleaf/patron/patronMain/patronForm";
    }

    @GetMapping("/creator")
    public String patronCreator(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
    		Model model, 
    		@PageableDefault(size = 15) Pageable pageable){
    	
        model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
        
        // 페이징 쿼리 -> Dto
        Page<PatronCreatorDto> pageResult = patronService.totalPatronView(pageable);
        model.addAttribute("results",pageResult);
        LOGGER.info("getTotalPages={}",pageResult.getTotalPages());
        LOGGER.info("getTotalElements={}",pageResult.getTotalElements());
        LOGGER.info("getSize={}",pageResult.getSize());
        LOGGER.info("hasNext={}",pageResult.hasNext());
        LOGGER.info("getNumber={}", pageResult.getNumber());
        return "thymeleaf/patron/creator/creator";
    }

    @GetMapping("/reward")
    public String patronReward(
    		@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
    		Model model){
        model.addAttribute("menuBar_active", "reward");
        model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
        return "thymeleaf/patron/reward/reward";
    }

    @GetMapping("/register")
    public String patronRegisterForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
    	// 세션 없을때 
    	if (user == null) {
    		//이거 로그인 화면으로 바꿔야됨.
    		model.addAttribute("alertActive","noUser");
    		model.addAttribute("redirectURL", "?redirectURL=/patron/register");
    		return "thymeleaf/patron/patronAlert";
    	}
    	// 유저가 patron에 등록할 조건을 체크
    	model.addAttribute("member",user); // 세션 유무에 따른 헤더 세팅
    	String patronAuthority = patronService.patronRegisterCondition(user.getId());
    	if (patronAuthority.equals("noCreator") || patronAuthority.equals("alreadyPatorn")) {
    		model.addAttribute("alertActive",patronAuthority);
    		return "thymeleaf/patron/patronAlert";
    	}
    	// creator에 등록이 된 유저인지 체크
    	List<Creator> creator = creatorService.findCreatorByuserProfileId(user.getId());
    	model.addAttribute("creatorId", creator.get(0).getId());
    	model.addAttribute("creatorName", creator.get(0).getNickName());
        return "thymeleaf/patron/patronRegister/rewardRegisterForm";
    }
    
    @PostMapping("/register")
    public String patronRegister(@ModelAttribute PatronRegisterDto patronRegisterDto, Model model) {
    	String saved = patronService.registerPatronAndReward(patronRegisterDto);
    	model.addAttribute("alertActive", saved);
    	return "thymeleaf/patron/patronAlert";
    }
    
    @GetMapping("/register/reward")
    public String patronRewardRegister(Model model){
        return "thymeleaf/patron/patronRegister/rewardRegisterForm";
    }
    
    
}
