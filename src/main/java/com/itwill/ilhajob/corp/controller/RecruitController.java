package com.itwill.ilhajob.corp.controller;

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
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.RecruitService;


@Controller
public class RecruitController {
	@Autowired
	private CorpService corpService;
	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping(value = {"/","/index"})
	public String main(Model model) throws Exception{
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		System.out.println(recruitList);
		String forward_path = "index";
		return forward_path;
	}
	
	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception{
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "recruit-list";
		return forward_path;
	}
	
	@RequestMapping(value = "/recruit-detail",params = "!id")
	public String recruit_detail() {
		return "redirect:index";	
	}
	@RequestMapping(value = "/recruit-detail",params = "id")
	public String recruit_detail(@RequestParam long id, Model model) throws Exception{
		RecruitDto recruit = recruitService.findRecruit(id);
		model.addAttribute("recruit", recruit);
		System.out.println(recruit);
		System.out.println(recruit.getCorp());
		String forward_path = "recruit-detail";
		return forward_path;
	}
	
	   @RequestMapping("/dashboard-post-job")
	   public String dashboard_post_job_form(HttpServletRequest request,Model model) throws Exception {
		  CorpDto loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
	      model.addAttribute("corp",loginCorp);
	      String forward_path = "dashboard-post-job";
	      return forward_path;
	   }
	   @PostMapping("/dashboard-post-job-action")
	   public String dashboard_post_job_action(@ModelAttribute RecruitDto recruitDto,HttpServletRequest request,Model model) throws Exception {
		  CorpDto loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
		  recruitDto.setRcDeadline(new Date());
		  recruitDto.setCorp(loginCorp);
		  recruitService.create(recruitDto);
	      model.addAttribute("id",recruitDto.getId());
	      String forward_path = "recruit-detail";
	      return forward_path;
	   }
}
