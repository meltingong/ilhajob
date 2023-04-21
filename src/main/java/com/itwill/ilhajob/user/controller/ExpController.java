package com.itwill.ilhajob.user.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String createExp(
			HttpServletRequest request, 
			@RequestParam(name="expCorpName") String expCorpName,
			@RequestParam(name="expPosition") String expPosition,
			@RequestParam(name="expContent") String expContent,
			@RequestParam(name="expStartDate") String expStartDate,
			@RequestParam(name="expEndDate") String expEndDate,
			@RequestParam(name="cvId") String cvId,
			RedirectAttributes redirectAttributes
			) throws Exception {
		
		System.out.println(">>>>>>>>>>>> expStartDate : " + expStartDate);
		
		String userId = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userId);
		
		ExpDto expDto = new ExpDto();
		expDto.setExpCorpName(expCorpName);
		expDto.setExpPosition(expPosition);
		expDto.setExpContent(expContent);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime startDateTime = LocalDate.parse(expStartDate, formatter).atStartOfDay();
		LocalDateTime endDateTime = LocalDate.parse(expEndDate, formatter).atStartOfDay();
		expDto.setExpStartDate(startDateTime);
		expDto.setExpEndDate(endDateTime);
		expDto.setUser(user);
		
		expService.createExp(expDto);
		System.out.println(">>>>>>>>>>>> expDto : " + expDto);
		redirectAttributes.addAttribute("cvId", cvId);
		return "redirect:cv-detail";
	}
	
	@PostMapping(value = "/exp-update")
	public String updateExp() {
		return "";
	}
	
	@PostMapping(value = "/exp-delete")
	public String deleteExp(@RequestParam(name = "expId") String id, @RequestParam String cvId, RedirectAttributes redirectAttributes) {
		Long expId = Long.parseLong(id.replace(",", ""));
		expService.removeById(expId);
		redirectAttributes.addAttribute("cvId", cvId);
		return "redirect:cv-detail";
	}
}
