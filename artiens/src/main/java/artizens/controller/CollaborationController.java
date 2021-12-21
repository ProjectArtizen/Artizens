package artizens.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import artizens.domain.UserProfile;
import artizens.mapper.dto.collaboration.CollaborationInsertDto;
import artizens.service.CollaborationService;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/artizen/collaboration")
public class CollaborationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController.class);
	
	@Autowired CollaborationService collaborationService;
	
	@GetMapping("/planning")
	public String insertCollaboration(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false ) UserProfile user) {
		return "col/col_Planning";
	}
	
	@PostMapping("/planning")
	public String viewCollaborationResult(@ModelAttribute CollaborationInsertDto collaborationInsertDto) {
		LOGGER.info("msg1={}", collaborationInsertDto.toString());
		collaborationService.insertCollaboration(collaborationInsertDto);
		LOGGER.info("msg2={}", collaborationInsertDto.toString());
		
		return "col/col_Planning";
	}
}
