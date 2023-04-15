package com.itwill.ilhajob.corp.controller;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.controller.LoginCheck;

@Controller
public class RecruitController {
	@Autowired
	private CorpService corpService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RecruitService recruitService;

	@RequestMapping(value = { "/", "/index" })
	public String main(Model model) throws Exception {
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "index";
		return forward_path;
	}

	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception {
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "recruit-list";
		return forward_path;
	}

	@RequestMapping(value = "/recruit-detail", params = "!id")
	public String recruit_detail() {
		return "redirect:index";
	}

	//@LoginCheck
	@RequestMapping(value = "/recruit-detail", params = "id")
	public String recruit_detail(@RequestParam long id, Model model) throws Exception {
		RecruitDto recruit = recruitService.findRecruit(id);
		model.addAttribute("recruit", recruit);
		List<ManagerDto> managerList = managerService.findManagerByCorpID(recruit.getCorp().getId());
		model.addAttribute("managerList", managerList);
		String forward_path = "recruit-detail";
		return forward_path;
	}

	@RequestMapping("/dashboard-post-job")
	public String dashboard_post_job_form(HttpServletRequest request, Model model) throws Exception {
		CorpDto loginCorp = corpService.findCorp((String) request.getSession().getAttribute("sCorpId"));
		model.addAttribute("corp", loginCorp);
		String forward_path = "dashboard-post-job";
		return forward_path;
	}

	@PostMapping("/dashboard-post-job-action")
	public String dashboard_post_job_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request)
			throws Exception {
		CorpDto loginCorp = corpService.findCorp((String) request.getSession().getAttribute("sCorpId"));
		recruitDto.setRcDate(LocalDateTime.now());
		recruitDto.setRcDeadline(LocalDateTime.now());
		recruitDto.setCorp(loginCorp);
		recruitDto = recruitService.create(recruitDto);
		String forward_path = "redirect:recruit-detail?id=" + recruitDto.getId();
		return forward_path;
	}

	// 테스트아직 안함
//	   @PostMapping("/dashboard-post-remove-action")
//	   public String dashboard_post_remove_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request) throws Exception {
//		  CorpDto loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
//		  System.out.println(recruitDto);
//		  //recruitService.remove(0);
//	      String forward_path = "redirect:recruit-list";
//	      return forward_path;
//	   }

	
	@PostMapping("/recruit-delete-action")
	public String recruit_delete_action(@ModelAttribute RecruitDto recruitDto) throws Exception {
		//System.out.println("삭제 전");
		//System.out.println(">>>>>>>recruit>>>>>>>" + recruitDto);
		System.out.println(recruitDto.getId());
		recruitService.remove(recruitDto.getId());
		//System.out.println("삭제 후");
		return "redirect:dashboard-manage-job";
	}
 
	@PostMapping("/recruit-modify-form")
	public String recruit_modify_form(HttpServletRequest request,@ModelAttribute RecruitDto recruitDto, Model model) throws Exception {
		System.out.println("recruit update");
		System.out.println(recruitDto);
		//System.out.println(recruitDto.getCorp().getId()); //null뜸
		// 일단 회사 로그인
//		CorpDto loginCorp = corpService.findCorp((String) request.getSession().getAttribute("sCorpId"));
//		model.addAttribute("corp", loginCorp);
//		System.out.println("로그인 회사 정보"+loginCorp);
//
		String sCorpId = (String) request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findCorp(sCorpId);
		recruitDto.setCorp(corpDto);
		RecruitDto updateRecruit=recruitService.update(recruitDto);
		System.out.println(updateRecruit);
		//RecruitDto recruit=recruitService.findRecruit(recruitDto.getId());
		//model.addAttribute("recruit",recruit);

		return "redirect:recruit-modify-form";
	}

}
