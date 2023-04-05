package com.itwill.ilhajob.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping(value = {"/","/index"})
	public String main(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAllWithCorp();
		model.addAttribute("recruitList", recruitList);
		System.out.println(recruitList);
		String forward_path = "index";
		return forward_path;
	}
	
	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAllWithCorp();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "recruit-list";
		return forward_path;
	}
	
	@RequestMapping(value = "/recruit-detail",params = "!rcSeq")
	public String recruit_detail() {
		return "redirect:index";	
	}
	@RequestMapping(value = "/recruit-detail",params = "rcSeq")
	public String recruit_detail(@RequestParam int rcSeq, Model model) throws Exception{
		Recruit recruit = recruitService.findRecruit(rcSeq);
		model.addAttribute("recruit", recruit);
		System.out.println(recruit);
		String forward_path = "recruit-detail";
		return forward_path;
	}
	
	@RequestMapping("/dashboard-post-job")
	public String dashboard_post_job_form() {
		
		String forward_path = "dashboard-post-job";
		return forward_path;
	}
	@RequestMapping("/dashboard-post-job-action")
	public String dashboard_post_job_action(Model model) {
		
		String forward_path = "recruit-detail";
		return forward_path;
	}
}
