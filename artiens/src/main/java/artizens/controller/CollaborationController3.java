package artizens.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import artizens.service.CollaborationService;

@Controller
@RequestMapping("/artizen/collaboration")
public class CollaborationController3 {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController3.class);

	@Autowired CollaborationService collaborationService;
	
	/**
	 * 당선작을 선택하는 화면
	 * @return
	 */
	@GetMapping("/winner")
	public String winnerSelect() {
		return "col/col_Winner";
	}
	
	/**
	 * 당선작을 처리하는 화면
	 * @return
	 */
	@PostMapping("/choice")
	public String winnerUpdate() {
		return "";
	}
}
