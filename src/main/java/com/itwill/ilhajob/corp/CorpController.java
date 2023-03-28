package com.itwill.ilhajob.corp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CorpController {
	@Autowired
	private CorpService corpService;
}
