package com.itwill.ilhajob.user;

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
	@RequestMapping(value = "/index")
	public String main() {
		return "index";
	}
	
	//회원 정보 보기
	@RequestMapping(value = "/candidate-dashboard-profile")
	public String user_view() {
		return "candidate-dashboard-profile";
	}
	
	//회원 로그인 폼
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	//회원 로그인 액션
	@RequestMapping
	public String login_action(@ModelAttribute("fuser")User user,Model model,HttpSession session) throws Exception{
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
