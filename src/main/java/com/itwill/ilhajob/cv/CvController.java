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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.app.AppService;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.awards.AwardsService;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.edu.EduService;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.exp.ExpService;
import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.controller.LoginCheck;

@Controller
public class CvController {
	
	@Autowired
	private CvService cvService;
	@Autowired
	private AwardsService awardsService;
	@Autowired
	private EduService eduService;
	@Autowired
	private ExpService expService;
//	@Autowired 
//	private AppService appService;
	
	/************************* cv list *******************************/
//	@LoginCheck
	@RequestMapping(value = "/cv-list")
	public String cv_list(HttpServletRequest request, Model model) {
		String forwardpath = "";
//		if(request.getSession().getAttribute("userSeq") != null) {
//			int userSeq = (int)request.getSession().getAttribute("userSeq");
		
		/* 테스트용 userSeq 세팅, 조건문 */
		request.getSession().setAttribute("userSeq", 3);
		if(request.getSession() != null) {
		/* 테스트용 userSeq 세팅, 조건문 */
			int userSeq = (int)request.getSession().getAttribute("userSeq");
			List<Cv> cvList = cvService.findCvListByUserSeq(userSeq);
			model.addAttribute("cvList", cvList);
			forwardpath = "candidate-dashboard-cv-manager";
		} 
		else {
			List<Cv> cvList = cvService.selectAll();
			model.addAttribute("cvList", cvList);
			forwardpath = "redirect:cv-write-form";
		}
		return forwardpath;
	}
	
	/************************* cv form *******************************/
	/** cv write form */
//	@LoginCheck
	@RequestMapping(value = "/cv-write-form")
//	public String cv_wirte_from(HttpServletRequest request, Model model) {
	public String cv_wirte_from(@ModelAttribute User user, Model model) {
//		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		
		/* userSeq */
		int userSeq = user.getUserSeq();
		model.addAttribute("userSeq", userSeq);
		
		/* eduList */
		List<Edu> eduList = user.getEduList();
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<Exp> expList = user.getExpList();
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<Awards> awardsList = user.getAwardsList();
		model.addAttribute("awardsList", awardsList);
		String forwardpath = "candidate-dashboard-resume-write";
		return forwardpath;
	}

	/** cv detail param(cvSeq) 없을 때 */
//	@LoginCheck
	@RequestMapping(value = "/cv-detail", params = "!cvSeq")
//	public String cv_detail(int userSeq, Model model) {							// test
	public String cv_detail(@ModelAttribute User user, Model model) {
		String forwardpath = "";
		/* user cv list 가져오기 */
		List<Cv> cvList = cvService.findCvListByUserSeq(user.getUserSeq());
//		List<Cv> cvList = cvService.findCvListByUserSeq(userSeq); 				// test
		System.out.println(cvList);
		if (cvList.size() == 0) {
			forwardpath = "redirect:cv-write-form";
		} else {
			model.addAttribute("cvList", cvList);
			/* 가장 최근 작성한 cv의 detail */
			Cv cvDetail = cvService.detailCv(cvList.get(cvList.size()-1).getCvSeq());
			model.addAttribute("cvDetail", cvDetail);
			forwardpath = "candidate-dashboard-resume";
		}
		return forwardpath;
	}
	
	/** cv detail param(cvSeq) 있을 때 */
//	@LoginCheck
	@RequestMapping(value = "/cv-detail")
	public String cv_detail(@ModelAttribute User user, @RequestParam int cvSeq, Model model) {
		String forwardpath = "";
		/* user cv list */
		List<Cv> cvList = cvService.findCvListByUserSeq(user.getUserSeq());
		System.out.println(cvList);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		Cv cvDetail = cvService.detailCv(cvSeq);
		System.out.println(">>>>>>>> cv " + cvDetail);
		
		/* eduList */
		List<Edu> eduList = cvDetail.getEduList();
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<Exp> expList = cvDetail.getExpList();
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<Awards> awardsList = cvDetail.getAwardsList();
		model.addAttribute("awardsList", awardsList);
		
		if(cvDetail != null) {
			// 어디로 보낼지 더 생각하기
			forwardpath = "redirect:cv-list";
		}
		model.addAttribute("cvDetail", cvDetail);
		forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
	
	/************************* cv action *******************************/
	/** write_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-write-action")
	@RequestMapping(value = "/cv-write-action")
	public String cv_write_action(@ModelAttribute Cv cv, RedirectAttributes redirectAttributes) {
		try {
			cvService.createCv(cv);
			int cvSeq = cv.getCvSeq();
			redirectAttributes.addAttribute("cvSeq", cvSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		새로 작성한 이력서 디테일로 가는데, 작성한 다른 이력서 리스트도 추가해줘야하나?(셀렉트옵션)
		return "redirect:cv-detail";
	}
	
	/** update_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@GetMapping(value = "/cv-update-action")
//	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, @ModelAttribute List<Awards> awardsList, @ModelAttribute Edu edu, @ModelAttribute Exp exp, Model model) {
	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, Model model) {
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
//	@PostMapping(value = "/cv-delete-action")
	@RequestMapping(value = "/cv-delete-action")
	public String cv_delete_action(HttpServletRequest request, @RequestParam int cvSeq) throws Exception{
		cvService.remove(cvSeq);
		return "redirect:cv-list";
	}
	
	/*********************** cv apply action *************************/
//	@LoginCheck
//	@PostMapping("cv-apply-action")
	@RequestMapping("cv-apply-action")
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
