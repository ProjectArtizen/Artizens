package artizens.controller;

import java.lang.ProcessBuilder.Redirect;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import artizens.domain.UserProfile;
import artizens.mapper.dto.collaboration.CollaborationArtWorkInsertDto;
import artizens.mapper.dto.collaboration.CollaborationArtworkDetailDto;
import artizens.mapper.dto.collaboration.CollaborationDetailDto;
import artizens.service.CollaborationService2;
import artizens.web.session.SessionConst;

@Controller
@RequestMapping("/collaboration")
public class CollaborationController2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaborationController2.class);

	@Autowired CollaborationService2 collaborationService;
	
	/**
	 * 공모전 상세 화면
	 * @param collaborationId
	 * @param model
	 * @return
	 */
	@GetMapping("/{collaborationId}")
	public String collaborationDetail(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user, 
			@PathVariable Long collaborationId, 
			Model model) {
		CollaborationDetailDto result = collaborationService.collaborationDetailForm(collaborationId);
		if (result == null) {
			model.addAttribute("condition", "invalidRequest");
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		LOGGER.info("result = {}", result.toString());
		return "col/col_Detail";
	}
	
	/**
	 * 참여 작품 상세 화면
	 * @param colArtId
	 * @return
	 */
	@GetMapping("/art/{collaborationArtWorkId}")
	public String colArt(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@PathVariable(name="collaborationArtWorkId") Long colArtId,
			Model model){
		CollaborationArtworkDetailDto result = collaborationService.collaborationArtWotkDetailForm(colArtId);
		if (result == null) {
			model.addAttribute("condition", "invalidRequest");
			return "col/col_Redirect";
		}
		model.addAttribute("result", result);
		LOGGER.info("result = {}", result.toString());
		return "col/col_ArtWorkDetail";
	}
	
	/**
	 * 참여 작품 목록
	 * @return
	 */
	@GetMapping("/art")
	public String colArtList(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			Model model) {
		return "col/col_ArtList";
	}
	
	/**
	 * 당선 작품 목록
	 * @return
	 */
	@GetMapping("/art/winner")
	public String colWInnerArtList(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			Model model) {
		return "col/col_ArtWinnerList";
	}
	
	/**
	 * 참여 작품을 접수하는  controller
	 * @return
	 */
	@PostMapping("/art/register")
	public String colartReceipt(
			@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserProfile user,
			@ModelAttribute CollaborationArtWorkInsertDto dto, 
			RedirectAttributes redirectAttributes,
			Model model) {
		System.out.println(dto.toString());
		String insertCondition = collaborationService.insertCollaborationArtWotk(user, dto);
		if (insertCondition.equals("noUser") || insertCondition.equals("noCreator") || insertCondition.equals("organizer")) {
			model.addAttribute("condition", insertCondition);
			return "col/col_Redirect";
		}
		System.out.println(dto.toString());
		System.out.println(insertCondition);
		redirectAttributes.addAttribute("condition", "insert");
		return "redirect:/collaboration/art/"+insertCondition;
	}
	
	/**
	 * 참여 작품을 수정하는 화면
	 * @return
	 */
	@GetMapping("/art/modify")
	public String colartReceiptModify(Model model) {
		return "col/col_artReceiptModify";
	}
}
