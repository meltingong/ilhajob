package com.itwill.ilhajob.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.ilhajob.user.dto.ExpDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.service.ExpService;
import com.itwill.ilhajob.user.service.UserService;

@Controller
public class ExpController {
	
	@Autowired
	private ExpService expService;
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/exp-create")
	public String createExp(HttpServletRequest request, @ModelAttribute ExpDto expDto) throws Exception {
		
		System.out.println(">>>>>>>>>>>> expDto : " + expDto);
		
		String userId = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userId);
		expDto.setUser(user);
		expService.createExp(expDto);
		System.out.println(">>>>>>>>>>>> expDto : " + expDto);
		
		return "cv-detail";
	}
}
