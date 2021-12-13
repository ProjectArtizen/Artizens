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

import artizens.controller.dto.SampleDTO;
import artizens.domain.SampleVO;
import artizens.service.SampleService;

@Controller
public class SampleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired SampleService sampleService;
	
	@GetMapping("/test-mvc")
	public String getSample(Model model) {
		List<SampleVO> result = sampleService.findAll();
		LOGGER.info("result={}",result);
		model.addAttribute("result",result);
		return "artWork/Test";
	}
	
	@PostMapping("/test-mvc")
	public String postSample( @ModelAttribute SampleDTO sampleDTO, Model model ) {
		int result = sampleService.save(sampleDTO.getTitle(), sampleDTO.getName());
		LOGGER.info("result={}",result);
		return "artwork/Test";
	}
	
	
}
