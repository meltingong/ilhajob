package com.itwill.ilhajob.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;

/*
/user_main 
/user_write_form 
/user_write_action 
/user_login_form
/user_login_action 
/user_logout_action 
/user_view /user_modify_form
/user_modify_action 
/user_remove_action
*/
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	/**************Local Exception Handler**************/
	@ExceptionHandler(Exception.class)
	public String user_excetpion_handler(Exception e) {
		return "user_error";
	}
	
	/*
	 * <<유저 정보>> my profile 유저정보 업데이트 폼
	 * 회원 로그인
	 * 회원 로그아웃
	 * 회원 정보 수정
	 * 회원 탈퇴
	 * 회원 정보 보기
	 */
	
	//메인 페이지
	@RequestMapping("/index")
	public String main() {
		return "index";
	}
	
	//회원 대시보드 보기
	@LoginCheck
	@RequestMapping("/candidate-dashboard")
	public String dashboard(HttpServletRequest request) throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		String forwardPath = "candidate-dashboard";
		return forwardPath;
	}
	
	//회원 정보 보기
	@LoginCheck
	@RequestMapping("/candidate-dashboard-profile")
	public String user_profile(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "candidate-dashboard-profile";
		return forwardPath;
	}
	
	// 회원 정보수정 폼 ***템플릿 복사해서 수정 가능한 modify-form 만들어야 함****
	@LoginCheck
	@RequestMapping("/candidate-dashboard-profile-modify-form")
	public String modify_form(HttpServletRequest request) {
		String forwardPath = "";
		
		
		return forwardPath;
	}
	
	//회원 로그인 폼
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//회원 로그인 액션
	@PostMapping("/user_login_action")
	public String user_login_action(@ModelAttribute("fuser")User user,Model model,HttpSession session) throws Exception{
		String forwardPath = "";
		try {
			userService.login(user.getUserEmail(),user.getUserPassword(),user.getSnsType(),user.getSnsId());
			session.setAttribute("sUserId", user.getUserEmail());
			forwardPath = "redirect:index";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath = "login";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "login";
		}
		return forwardPath;
	}
	
	// 회원 로그아웃 액션
	@LoginCheck
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		request.getSession().invalidate();
		forwardPath = "redirect:index";
		return forwardPath;
	}

	
	// my resume 이력서 작성 폼
	
	/*
	 * <<지원>> applied jobs 지원한 공고 목록
	 * 회사에 이력서 지원 하기
	 * 이력서 지원한 회사 목록 보기
	 */
	
	/*
	 * 리뷰(기업에 대한 리뷰) -- > 템플릿 페이지 만들 필요 있음
	 * 리뷰 작성 , 삭제 , 수정 
	 */
}