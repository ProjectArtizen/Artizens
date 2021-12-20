package artizens.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import artizens.controller.dto.MybatisTestDto;
import artizens.controller.dto.TestDto;
import artizens.domain.UserProfile;
import artizens.mapper.UserMapper;
import artizens.service.UserProfileService;

@Controller
public class MybatisController {
	
	@Autowired UserMapper userMapper;
	@Autowired UserProfileService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisController.class);
	
	
	
	@RequestMapping(value = "/artizen/mybatis", method = RequestMethod.GET)
	public String insertUsers(Model model) {
		return "NewFile";
	}
	
	@RequestMapping(value = "/artizen/mybatis", method = RequestMethod.POST)
	public String insertByUserId(MybatisTestDto mybatisTestDto, Model model) {
		System.out.println(); // 에플리케이션을 restart
		LOGGER.info("mybatis={}", mybatisTestDto.getTest1());
		return "";
	}
	
	@GetMapping("/artizen/mybatis/{userId}")
	public String findByUserId(@PathVariable(name = "userId") Long id, Model model) {
		return "";
	}
	
	@GetMapping("/updateUser")
	public String updateByUser() {
		return "";
	}
}
