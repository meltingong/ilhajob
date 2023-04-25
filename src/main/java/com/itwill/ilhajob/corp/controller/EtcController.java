package com.itwill.ilhajob.corp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtcController {

	@RequestMapping("faqs")
	public String faqs() {
		
		return "faqs";
	}
}
