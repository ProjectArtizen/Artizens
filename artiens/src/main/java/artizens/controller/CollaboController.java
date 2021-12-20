package artizens.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import artizens.mapper.dto.CollaborationDetailDto;
import artizens.mapper.dto.CollaborationMainDto;
import artizens.service.CollaborateService;

@Controller
@RequestMapping("/artizen")
public class CollaboController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollaboController.class);

	@Autowired CollaborateService collaborationservice;
	
	@GetMapping("/colMain")
	public String collaborationMain(Model model) {
		List<CollaborationMainDto> result = collaborationservice.selectAll();
		model.addAttribute("result", result);
		return "col/col_Main";
	}
	
	@GetMapping("/colDetail/{collaborationId}")
	public String collaborationDetail(@PathVariable Long collaborationId, Model model) {
		List<CollaborationDetailDto> result = collaborationservice.selectDetail(collaborationId);
		model.addAttribute("result",result);
		return "col/col_Detail";
	}
	
	@RequestMapping("/colDetail")
	public String colDetail(){
		return "col/col_Detail";
	}
	
	@RequestMapping("/colWorkList")
	public String colWorkList() {
		return "col/col_WorkList";
	}
	@RequestMapping("/colWorkDetail")
	public String colWorkDetail(){
		return "col/col_WorkDetail";
	}
	
	@RequestMapping("/colArtList")
	public String colArtList() {
		return "col/col_ArtList";
	}
	
	@RequestMapping("/colPlanning")
	public String colPlanning() {
		return "col/col_Planning";
	}
	
	@RequestMapping("/colartReceipt")
	public String colartReceipt() {
		return "col/col_artReceipt";
	}
	
	@RequestMapping("/colartReceiptModify")
	public String colartReceiptModify() {
		return "col/col_artReceiptModify";
	}
	
	@RequestMapping("/colplanningModify")
	public String colplanningModify() {
		return "col/col_planningModify";
	}
	
	@RequestMapping("/colDetailEnd")
	public String colDetailEnd() {
		return "col/col_DetailEnd";
	}

}
