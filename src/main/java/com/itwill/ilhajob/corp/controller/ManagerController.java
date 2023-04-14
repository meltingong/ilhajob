package com.itwill.ilhajob.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private CorpService corpService;
	
	//매니저리스트
	
	@RequestMapping("/dashboard-manager-list")
	public String corp_dashboard_manager_list(HttpServletRequest request,Model model) throws Exception{
		String sCorpId = (String) request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findCorp(sCorpId);
		List<ManagerDto> managerList = managerService.findManagerByCorpID(corpDto.getId());
		System.out.println(managerList);
		model.addAttribute("managerList",managerList);
		
		return "dashboard-manager-list";
	}
}
