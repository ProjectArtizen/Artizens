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

import artizens.domain.Collaboration;
import artizens.domain.UserProfile;
import artizens.mapper.dto.collaboration.CollaborationDto;
import artizens.service.CollaborationService;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/artizen/collaboration")
public class CollaborationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController.class);
	
	@Autowired CollaborationService collaborationService;
	
	@GetMapping("/planning")
	public String insertCollaboration(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user, Model model) {
		List<CollaborationDto> result = collaborationService.findAllByCollaboration();
		model.addAttribute("result", result);
		for (CollaborationDto collaboration : result) {
			System.out.println(collaboration.toString());
		}
		return "col/col_Planning";
	}
	
	@PostMapping("/planning")
	public String viewCollaborationResult(@ModelAttribute CollaborationDto collaborationDto) {
		CollaborationDto dto = collaborationService.insertCollaboration(collaborationDto);
		LOGGER.info("msg2={}", dto.toString());
		return "col/col_Planning";
	}
}
