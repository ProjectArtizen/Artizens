package artizens.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import artizens.mapper.dto.collaboration.CollaborationDetailDto;
import artizens.service.CollaborationService2;

@Controller
@RequestMapping("/artizen/collaboration")
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
			@PathVariable Long collaborationId, 
			Model model) {
		CollaborationDetailDto result = collaborationService.collaborationDetailForm(collaborationId);
		if (result == null) {
			System.out.println("없음");
			return "col/col_Detail";
		}
		LOGGER.info("result = {}", result.toString());
		return "col/col_Detail";
	}
	
	/**
	 * 참여 작품 상세 화면
	 * @param colArtId
	 * @return
	 */
	@GetMapping("/art/{collaborationArtWorkId}")
	public String colArt(@PathVariable(name="collaborationArtWorkId") Long colArtId){
		return "";
	}
	
	/**
	 * 참여 작품 목록
	 * @return
	 */
	@GetMapping("/artlist")
	public String colArtList() {
		return "col/col_ArtList";
	}
	
	/**
	 * 참여 작품을 접수하는 화면
	 * @return
	 */
	@GetMapping("/art/register")
	public String colartReceipt() {
		return "col/col_artReceipt";
	}
	
	/**
	 * 참여 작품을 수정하는 화면
	 * @return
	 */
	@GetMapping("/art/modify")
	public String colartReceiptModify() {
		return "col/col_artReceiptModify";
	}
}
