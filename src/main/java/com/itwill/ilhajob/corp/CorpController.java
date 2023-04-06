package com.itwill.ilhajob.corp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.naming.factory.webservices.ServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.app.AppService;
import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corpimage.CorpImage;
import com.itwill.ilhajob.corpimage.CorpImageService;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.recruit.RecruitService;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;

import groovyjarjarantlr4.v4.parse.ANTLRParser.exceptionGroup_return;



@Controller
public class CorpController {
	
	@Autowired
	private CorpService corpService;
	@Autowired
	private AppService appService;
	
	
	
//	@RequestMapping("/index")
//	public String main() {
//		String forward_path = "index";
//		return forward_path;
//	}
	
	@RequestMapping("/corp-list")
	public String corp_list(Model model) throws Exception {
		List<Corp> corpList = corpService.findCorpAll();
		model.addAttribute("corpList",corpList);
		String forward_path = "corp-list";
		
		
		return forward_path;
		
	}
	
	@RequestMapping("corp-detail")
	public String corp_detail_view(@RequestParam("corpId") String corpId,Model model) throws Exception {
		Corp corp=corpService.findCorpWithRecruits(corpId);
		model.addAttribute("corp", corp);
		return "corp-detail";
		
	}
	
//	@RequestMapping("/login")
//	public String login() {
//		String forward_path = "login";
//		return forward_path;
//	}
	@PostMapping("corp_login_action")
	public String corp_login_action(@ModelAttribute("fcorp") Corp corp,Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			corpService.login(corp.getCorpId(), corp.getCorpPassword());
			session.setAttribute("sCorpId", corp.getCorpId());
			System.out.println(corp.getCorpId());
			forwardPath="redirect:dashboard";
		}catch (CorpNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="login";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="login";
		}
		return forwardPath;
	}
	
	@RequestMapping("/dashboard")
	public String corp_dashboard_view(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		
		/************** login check **************/
		request.getSession().setAttribute("sCorpId", "corp_01"); //임시로 아이디 로그인상태
		String sCorpId =(String)request.getSession().getAttribute("sCorpId");
		if(sCorpId==null) {
			forwardPath= "redirect:login";
		}else {
			//System.out.println(loginCorp);
			Corp loginCorp=corpService.findCorp(sCorpId);
			//request.setAttribute("loginCorp", loginCorp);
			forwardPath="dashboard";
		}
		/****************************************/
		//forwardPath="dashboard";
		return forwardPath;
	}
	
	@RequestMapping("/dashboard-company-profile")
	public String corp_dashboard_company_profile(HttpServletRequest request,Model model) throws Exception {
		
		String forwardPath ="";
		
		String sCorpId = (String)request.getSession().getAttribute("sCorpId");
		Corp corp=corpService.findCorpWithimagesAndManagers(sCorpId);
		model.addAttribute("corp", corp);
		forwardPath =  "dashboard-company-profile";
				
		return forwardPath;
	}
	
	/*
	@PostMapping("/corp-update-action") //400에러 Date 변환 문제...
	public String corp_update_action(@ModelAttribute Corp corp) throws Exception {
		
		corpService.update(corp);
		return "redirect:corp-detail";
	}
	*/
	
	@RequestMapping("/dashboard-manage-job")
	public String corp_dashboard_manage_job(HttpServletRequest request ,Model model)throws Exception{
		String sCorpId = (String)request.getSession().getAttribute("sCorpId");
		Corp corp=corpService.findCorpWithRecruits(sCorpId);
		model.addAttribute("corp", corp);
		
		//지원자 숫자 보여주기
		int appCount=appService.findAppCountByCorpId(sCorpId);
		System.out.println(appCount);
		model.addAttribute("appCount", appCount);
		
		return "dashboard-manage-job";
	}
	
	@RequestMapping("/dashboard-applicants")
	public String corp_dashboard_applicants() {
		return "dashboard-applicants";
	}
	
	
//	@ExceptionHandler(Exception.class)
//	public String corp_exception_handler(Exception e) {
//		System.out.println("에러..");
//		return "shop-checkout";
//	}
}
