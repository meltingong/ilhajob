package com.itwill.ilhajob.corp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;

@Controller
public class CorpController {
	@Autowired
	private CorpService corpService;
	
	@RequestMapping("/index-16-test")
	public String main() {
		String forward_path = "index-16-test";
		return forward_path;
	}
	
	@RequestMapping("/login-test")
	public String login_test() {
		String forward_path = "login-test";
		return forward_path;
	}
	@PostMapping("corp_login_action")
	public String corp_login_action(@ModelAttribute("fcorp") Corp corp,Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			corpService.login(corp.getCorpId(), corp.getCorpPassword());
			session.setAttribute("sCorpId", corp.getCorpId());
			forwardPath="dashboard-test";
		}catch (CorpNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="login-test";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="login-test";
		}
		return forwardPath;
	}
	
	@RequestMapping("/dashboard-test")
	public String corp_dashboard_view(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		/************** login check **************/
		/****************************************/
		String sCorpId =(String)request.getSession().getAttribute("sCorpId");
		Corp loginCorp=corpService.findCorp(sCorpId);
		System.out.println(loginCorp);
		request.setAttribute("loginCorp", loginCorp);
		forwardPath="dashboard-test";
		
		return forwardPath;
	}
	
//	@ExceptionHandler(Exception.class)
//	public String corp_exception_handler(Exception e) {
//		System.out.println("에러..");
//		return "shop-checkout";
//	}
}
