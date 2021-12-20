package artizens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import artizens.mapper.UserMapper;
import artizens.mapper.dto.InsertUserDto;

@Controller
public class testController {
	
	@Autowired UserMapper userMapper;
	
	@RequestMapping("/welcome-jsp.do")
	public String welcomes(Model model) {
		System.out.println("jsp실행");
		model.addAttribute("name","dlsssㅊㅌsswngus");
	    return "welcome";
	}

	@GetMapping("/welcome-thymeleaf.do")
	public String welcome(Model model) throws Exception {
		System.out.println("thymelaf실행");
	    model.addAttribute("greeting", "Hello Thymelssseㄴㅇㄴㅇㄴafs!s");
	    return "thymeleaf/welcome";
	}
	
	@GetMapping("/testInsert")
	public String insertUser() {
		return "insertUserForm";
	}
	
	@PostMapping("/testInsert")
	@ResponseBody
	public String insertUserPost(@ModelAttribute InsertUserDto insertUserDto) {
		System.out.println("insertUserDto = " + insertUserDto.toString());
		userMapper.insertUser(insertUserDto);
		System.out.println("userId = " + insertUserDto.getId());
		return "Good";
	}
}
