package com.itwill.ilhajob.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
}
