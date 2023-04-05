package com.itwill.ilhajob.cv;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.app.AppService;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.awards.AwardsService;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.edu.EduService;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.exp.ExpService;
import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
import com.itwill.ilhajob.user.controller.LoginCheck;

@Controller
public class CvController {
	
	@Autowired
	private CvService cvService;
	/*
	@Autowired
	private AwardsService awardsService;
	@Autowired
	private EduService eduService;
	@Autowired
	private ExpService expService;
	@Autowired 
	private AppService appService;
	@Autowired
	private UserService userService;
	*/
	
	/* 테스트용 매핑 - user 붙인 후 삭제할 것 */
	/** dash board */
//	@LoginCheck
	@RequestMapping("/candidate-dashboard")
	public String candidate_dashboard() {
		return "candidate-dashboard";
	}
	
	/************************* cv list *******************************/
//	@LoginCheck
	@RequestMapping(value = "/cv-list")
	public String cv_list(HttpServletRequest request, Model model) {
		String forwardpath = "";
		/**************** 실제 보여줄 서비스(userSeq로 cv list) ********/
		if(request.getSession().getAttribute("userSeq") != null) {
			int userSeq = (int)request.getSession().getAttribute("userSeq");
			List<Cv> cvList = cvService.findCvListByUserSeq(userSeq);
			model.addAttribute("cvList", cvList);
			forwardpath = "candidate-dashboard-cv-manager";
		
		/********* 테스트용 전체 cv list(일반회원 로그인 구현 후 삭제할 것) **********/ 
		} else {
			List<Cv> cvList = cvService.selectAll();
			model.addAttribute("cvList", cvList);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> cvList" + cvList);
			forwardpath = "candidate-dashboard-cv-manager";
		}
		return forwardpath;
	}
	
	/************************* cv form *******************************/
	/*
	 * cv list(최신 이력서 하나 기본으로 보여주고 드롭박스로 선택 가능)
	 * --> cvService.findCvListByUserSeq(userSeq)를 desc로 정렬 ?
	 * cv update
	 * awards 추가, 수정, 삭제
	 * edu 추가, 수정, 삭제
	 * exp crud 추가, 수정, 삭제
	 * 선택된 cv로 apply(apply 버튼 추가 예정)
	 */
	/** cv detail */
	
//	@LoginCheck
	@RequestMapping(value = "/cv-write-form")
	public String cv_wirte_from(HttpServletRequest request) {
		String forwardpath = "candidate-dashboard-resume-write";
		return forwardpath;
	}

	//	@LoginCheck
	@RequestMapping(value = "/cv-detail")
	public String cv_detail(int userSeq, int cvSeq, Model model) {
		String forwardpath = "";
		
		/* user cv list */
		List<Cv> cvList = cvService.findCvListByUserSeq(userSeq);
		System.out.println(cvList);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		Cv cvDetail = cvService.detailCv(cvSeq);
		System.out.println(">>>>>>>> cv " + cvDetail);
		if(cvDetail != null) {
			// 어디로 보낼지 더 생각하기
			forwardpath = "redirect:cv-list";
		}
		model.addAttribute("cvDetail", cvDetail);
		forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
	
//	@LoginCheck
	@RequestMapping(value = "/cv-update-form")
	public String cv_update_from() {
		/*
		 * login check
		 */
		String forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
	
	/************************* cv action *******************************/
	/** write_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-write-action")
	@GetMapping(value = "/cv-write-action")
	public String cv_write_action(@ModelAttribute Cv cv) {
		/*
		 * login check
		 */
		try {
			cvService.createCv(cv);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cv-list";
	}
	
	/** update_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@GetMapping(value = "/cv-update-action")
//	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, @ModelAttribute List<Awards> awardsList, @ModelAttribute Edu edu, @ModelAttribute Exp exp, Model model) {
	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, Model model) {
		/*
		 * login check
		 */
		try {
//			for (Awards awards : awardsList) {
//				List<Awards> updateAwardsList = new ArrayList<Awards>();
//				updateAwardsList.add(awardsService.updateAwards(awards.));
//			}
//			Awards awards = awardsService.findAwards(awards.getAwardsSeq());
//			eduService.updateEdu(edu);
//			expService.updateExp(exp);
//			cv.setAwardsList(awards);
//			cv.setEduList(null);
//			cv.setExpList(null);
			int userSeq = (int)request.getSession().getAttribute("userSeq");
//			List<Edu> eduList = eduService.selectEduByUserSeq(userSeq);
//			model.addAttribute("eduList", eduList);
			cvService.updateCv(cv);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cv-list";
	}
	
	/** delete_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-delete")
	@RequestMapping(value = "/cv-delete")
	public String cv_delete_action(@RequestParam int cvSeq) throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>> test <<<<<<<<<<<<<");
		cvService.remove(cvSeq);
		return "redirect:cv-list";
	}
	
	/*********************** cv apply action *************************/
	@RequestMapping("cv-apply-action")
//	@PostMapping("cv-apply-action")
	public String cv_apply_action() {
		
//		return "candidate-dashboard-applied-job";
		return "index";
	}
	
	/************** Get 방식 요청 처리
	@GetMapping(value = {"/cv-write-action", "/cv-update-action", "/cv-delete"})
	public String cv_get() {
		// 메인 또는 cv-list로 이동
		return "redirect:cv-list";
	}
	 **************/
}
