package com.itwill.ilhajob.user.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.ilhajob.common.controller.ImageController;
import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.dto.AwardsDto;
import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.dto.EduDto;
import com.itwill.ilhajob.user.dto.ExpDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.exception.UserNotFoundException;
import com.itwill.ilhajob.user.service.AwardsService;
import com.itwill.ilhajob.user.service.CvService;
import com.itwill.ilhajob.user.service.EduService;
import com.itwill.ilhajob.user.service.ExpService;
import com.itwill.ilhajob.user.service.UserService;

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
	@Autowired
	private RecruitService recruitService;
	@Autowired 
	private AppService appService;
	@Autowired
	private UserService userService;
	
	/************************* cv form *******************************/
	/** cv write form */
	@LoginCheck
	@RequestMapping(value = "/cv-write-form")
	public String cv_wirte_from(HttpServletRequest request, Model model) throws Exception {
		Long userId = (Long)request.getSession().getAttribute("id");
		String userEmail = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userEmail);		
		model.addAttribute("userId" + userId);
		model.addAttribute("user" + user);

		/* eduList */
		List<EduDto> eduList = eduService.findEduListByUserId(userId);
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<ExpDto> expList = expService.findExpListByUserId(userId);
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
		model.addAttribute("awardsList", awardsList);
		
		String forwardpath = "candidate-dashboard-resume-write";
		return forwardpath;
	}

	/** cv detail param(cvId) 없을 때 */
	@LoginCheck
	@RequestMapping(value = "/cv-detail", params = "!cvId")
	public String cv_detail(HttpServletRequest request, Model model) throws Exception {
		String forwardpath = "";
		/* user cv list 가져오기 */
		Long userId = (Long)request.getSession().getAttribute("id");
		String userEmail = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userEmail);
		model.addAttribute("userId", userId);
		model.addAttribute("user" + user);
		List<CvDto> cvList = cvService.findByUserId(userId);
		
		if (cvList == null || cvList.size() == 0) {
			forwardpath = "redirect:cv-write-form";
		} else {
			model.addAttribute("cvList", cvList);
			
			/* 가장 최근 작성한(cvId 기준) cv의 detail */
			CvDto cvDetail = cvList.get(cvList.size()-1);
			model.addAttribute("cvDetail", cvDetail);
			
			/* eduList */
			List<EduDto> eduList = eduService.findEduListByUserId(userId);
			model.addAttribute("eduList", eduList);
			
			/* expList */
			List<ExpDto> expList = expService.findExpListByUserId(userId);
			model.addAttribute("expList", expList);
			
			/* awardsList */
			List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
			model.addAttribute("awardsList", awardsList);
			
			forwardpath = "candidate-dashboard-resume";
		}
		return forwardpath;
	}
	
	/** cv detail param(cvId) 있을 때 */
	@LoginCheck
	@RequestMapping(value = "/cv-detail")
	public String cv_detail(HttpServletRequest request, @RequestParam Long cvId, Model model) throws Exception {
		String forwardpath = "";
		
		Long userId = (Long)request.getSession().getAttribute("id");
		String userEmail = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userEmail);		
		model.addAttribute("userId", userId);
		model.addAttribute("user" + user);
		
		/* user cv list */
		List<CvDto> cvList = cvService.findByUserId(userId);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		CvDto cvDetail = cvService.findCvById(cvId);
		model.addAttribute("cvDetail", cvDetail);
		
		/* eduList */
		List<EduDto> eduList = eduService.findEduListByUserId(userId);
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<ExpDto> expList = expService.findExpListByUserId(userId);
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
		model.addAttribute("awardsList", awardsList);
		
		if(cvList == null || cvDetail != null) {
			forwardpath = "redirect:cv-list";
		}
		
		forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
		
	/************************* cv action *******************************/
	/** write_action */
	@LoginCheck
	@PostMapping(value = "/cv-write-action")
	public String cv_write_action(HttpServletRequest request, @ModelAttribute CvDto cv, RedirectAttributes redirectAttributes) {
		try {
			String userEmail = (String)request.getSession().getAttribute("sUserId");
			UserDto user = userService.findUser(userEmail);
			cv.setUser(user);
			cvService.saveCv(cv);
			
			// redirectAttributes
			Long cvId = cv.getId();
			redirectAttributes.addAttribute("cvId", cvId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cv-detail";
	}
	
	/** update_action */
	@LoginCheck
	@PostMapping(value = "/cv-update-action")
	public String cv_update_action(HttpServletRequest request, @RequestParam(name = "id") Long cvId , @ModelAttribute CvDto cv, RedirectAttributes redirectAttributes) throws Exception {
		String userEmail = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userEmail);
		cv.setUser(user);
		cvService.updateCv(cvId, cv);
		
		// redirectAttributes
		redirectAttributes.addAttribute("cvId", cvId);
		return "redirect:cv-detail";
	}

	/** delete_action */
	@LoginCheck
	@RequestMapping(value = "/cv-delete-action", method = RequestMethod.POST)
	public String cv_delete_action(HttpServletRequest request, @RequestParam(name = "id") Long cvId) throws Exception {
		cvService.removeById(cvId);
		return "redirect:cv-detail";
	}
	
	/*********************** cv apply action *************************/
	@LoginCheck
	@ResponseBody
	@PostMapping("cv-apply-action")
	public String cv_apply_action(@RequestBody Map<String, Object> requestData ,HttpServletRequest request ) throws Exception {
		RecruitDto recruit = recruitService.findRecruit(Long.valueOf((Integer)requestData.get("recruitId"))); // null
		CvDto cv = cvService.findCvById(Long.valueOf((Integer)requestData.get("id")));
		UserDto user = (UserDto)requestData.get("user");
		
		Map<String, String> pathMap = ImageController.makeDir("cv");
		String saveFileName = cv.getId()+"_cv"+user.getUserName()+".json";
		try {
			AppDto app = new AppDto(0, 0, LocalDateTime.now(), recruit, cv, user);
			
			//pathMap.get("urlPath") + saveFileName;
			appService.insertApp(app);
			//json파일 폴더에 저장
			ObjectMapper mapper = new ObjectMapper();
	        String json = mapper.writeValueAsString(requestData);
	        Path filePath = Paths.get(pathMap.get("absolutePath") + saveFileName);
	        Files.write(filePath, json.getBytes());
		}catch (Exception e) {
			return "이력서 지원 실패";
		}
		return "이력서 지원 완료";
	}
	
	/************** Get 방식 요청 처리 */
	@GetMapping(value = {"/cv-write-action", "/cv-update-action", "/cv-delete-action"})
	public String cv_get() {
		return "redirect:index";
	}

}
