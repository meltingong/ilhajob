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

}
