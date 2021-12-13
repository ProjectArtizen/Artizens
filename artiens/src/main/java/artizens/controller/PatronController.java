package artizens.controller;


import java.util.List;

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

import artizens.controller.dto.patron.PatronRegisterDto;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.UserProfile;
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
    public String patronMain(Model model){
        model.addAttribute("menuBar_active", "main");
        return "thymeleaf/patron/patronMain/patronForm";
    }

    @GetMapping("/creator")
    public String patronCreator(Model model){
        model.addAttribute("menuBar_active", "creator");
        return "thymeleaf/patron/creator/creator";
    }

    @GetMapping("/reward")
    public String patronReward(Model model){
        model.addAttribute("menuBar_active", "reward");
        return "thymeleaf/patron/reward/reward";
    }

    @GetMapping("/register")
    public String patronRegisterForm(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, Model model){
    	if (user == null) {
    		//이거 로그인 화면으로 바꿔야됨.
    		model.addAttribute("alertActive","noUser");
    		model.addAttribute("redirectURL", "?redirectURL=/patron/register");
    		return "thymeleaf/patron/patronAlert";
    	}
    	String patronAuthority = patronService.patronRegisterCondition(user.getId());
    	if (patronAuthority.equals("noCreator") || patronAuthority.equals("alreadyPatorn")) {
    		model.addAttribute("alertActive",patronAuthority);
    		return "thymeleaf/patron/patronAlert";
    	}
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
