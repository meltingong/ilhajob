package com.itwill.ilhajob.corp.controller;

import java.io.Console;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.controller.LoginCheck;
import com.itwill.ilhajob.user.dto.RecruitScrapDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.User;
import com.itwill.ilhajob.user.service.CvService;
import com.itwill.ilhajob.user.service.RecruitScrapService;
import com.itwill.ilhajob.user.service.UserService;


@Controller
public class RecruitController {
	@Autowired
	private CorpService corpService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private TagService tagService;
	@Autowired
	private RecruitTagService recruitTagService;
	@Autowired
	private AppService appService;
	@Autowired
	private CvService cvService;
	@Autowired
	private RecruitScrapService recruitScrapService;
	@Autowired
	private UserService userService;
	
	//home에 recruitList 뿌리기
	@RequestMapping(value = { "/", "/index" })
	public String main(Model model) throws Exception {
		// 전체 공고 리스트
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		
		// 마감 임박(Today+7 까지) 공고 리스트
		List<RecruitDto> tempRecruitList = recruitService.findRecruitAll();
		List<RecruitDto> deadLineRecruitList = new ArrayList<RecruitDto>();

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime deadline = today.plusDays(7);
		
		for (RecruitDto recruit : tempRecruitList) {
			if (recruit.getRcDeadline().compareTo(deadline) <= 0) {
				// status 문제 수정 되면 recruit.getRcStatus() == 0 으로 조건 추가
				// LocalDateTime 이라서 현재 시간 기준임 수정 필요....
				deadLineRecruitList.add(recruit);
			}
		}
		System.out.println("마감임박 공고리스트 : " + deadLineRecruitList);
		System.out.println("마감임박 공고리스트 수 : " + deadLineRecruitList.size());
		model.addAttribute("deadLineRecruitList", deadLineRecruitList);
		
		//태그리스트
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
		List<TagDto> tagList = tagService.selectAll();
		model.addAttribute("recruitTagList", recruitTagList);
		model.addAttribute("tagList", tagList);
		
		String forward_path = "index";
		return forward_path;
	}
	

	
	
	//조회수 증가 기능->수정중...ㅠ
	@RequestMapping("/increase-readCount-action")
	public String increase_readCount(@RequestParam("id")Long id,@ModelAttribute RecruitDto recruitDto,HttpServletRequest request,Model model) throws Exception {
		RecruitDto recruit=recruitService.findRecruit(id);
		recruitService.increaseReadCount(id);
		//RecruitDto updateRecruit=recruitService.update(recruit.getId());
		//System.out.println("update>>>"+updateRecruit);
		model.addAttribute("updateRecruit",recruit);
		return "recruit-detail";
	}

	@GetMapping("/recruit-list")
	public String recruit_list(@RequestParam(defaultValue = "0") int page,
	                        @RequestParam(defaultValue = "6") int size,
	                        Model model,HttpServletRequest request) throws Exception {
		//페이징 기능 추가->일단 6개씩 나오게 해놓음
	    Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
	    Page<RecruitDto> recruitPage = recruitService.findAll(pageable);
	    int nowPage = recruitPage.getNumber();
	    
	    //이전, 다음페이지 설정해야함...
	    model.addAttribute("recruitList", recruitPage.getContent());
	    model.addAttribute("nowPage", nowPage);
	    model.addAttribute("totalPage", recruitPage.getTotalPages());
	    model.addAttribute("prePage", recruitPage.hasPrevious() ? recruitPage.previousPageable().getPageNumber() : 0);
	    model.addAttribute("nextPage", recruitPage.hasNext() ? recruitPage.nextPageable().getPageNumber() : recruitPage.getTotalPages() - 1);
	
		//태그리스트
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
		List<TagDto> tagList = tagService.selectAll();
		model.addAttribute("recruitTagList", recruitTagList);
		model.addAttribute("tagList", tagList);
		
		
		//스크랩리스트(로그인아이디가 있다면 북마크리스트 넣어줌)
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		UserDto loginUser = null;
		if(sUserId!=null) {
			loginUser = userService.findUser(sUserId);
		}
		model.addAttribute("loginUser", loginUser);
		
		
		//로그인시에만 스크랩 (북마크)로고 출력
		if(loginUser!=null) {
			List<RecruitScrapDto> recruitScrapList = recruitScrapService.sellectByUserId(loginUser.getId());
			List<RecruitDto> recruitList = recruitService.findRecruitAll();
			//스크랩상태확인 리스트
			Map<Long,Integer> status = new HashMap<Long, Integer>();
			
			for(RecruitDto recruit :recruitList) {
			    boolean hasRecruitScrap = false; // 리크루트 스크랩이 있는지 여부를 나타내는 변수
			    for(RecruitScrapDto recruitscrap:recruitScrapList) {
			        if(recruit.getId() == recruitscrap.getRecruit().getId()) {
			            hasRecruitScrap = true; // 리크루트 스크랩이 있을 때
			            break; // 리크루트 스크랩이 있으면 반복문 종료
			        }
			    }
			    if(hasRecruitScrap) {
			    	status.put(recruit.getId(), 1); // 리크루트 스크랩이 있을 때
			    } else {
			    	status.put(recruit.getId(), 0); // 리크루트 스크랩이 없을 때
			    }
			}
			System.out.print("status"+status);
			model.addAttribute("status", status);
			model.addAttribute("recruitScrapList", recruitScrapList);
		}
		
		String forward_path = "recruit-list";
		return forward_path;
		
		
	}
	
//	@RequestMapping("/recruit-list")
//	public String recruit_list(Model model) throws Exception {
//		//공고리스트
//		List<RecruitDto> recruitList = recruitService.findRecruitAll();
//		model.addAttribute("recruitList", recruitList);
//		
//		//태그리스트
//		List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
//		List<TagDto> tagList = tagService.selectAll();
//		model.addAttribute("recruitTagList", recruitTagList);
//		model.addAttribute("tagList", tagList);
//		
//		String forward_path = "recruit-list";
//		return forward_path;
//		
//		
//	}

	@RequestMapping(value = "/recruit-detail", params = "!id")
	public String recruit_detail() {
		return "redirect:index";
	}

	//@LoginCheck
	@RequestMapping(value = "/recruit-detail", params = "id")
	public String recruit_detail(@RequestParam long id, Model model,HttpServletRequest request) throws Exception {
		RecruitDto recruit = recruitService.findRecruit(id);
		model.addAttribute("recruit", recruit);
		List<ManagerDto> managerList = managerService.findManagerByCorpID(recruit.getCorp().getId());
		model.addAttribute("managerList", managerList);
		
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId!=null) {
			UserDto user= userService.findUser(sUserId);
			//공고스크랩
			if(user!=null) {
				RecruitScrapDto scrap = 
						recruitScrapService.sellectByUserIdAndRecruitId(user.getId(), recruit.getId());
				System.out.println("공고스크랩:"+scrap);
				model.addAttribute("scrap", scrap);
			}
		}
		
		
		//공고태그리스트 선별
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAllByRecruitId(id);
		List<String> recruitTagNameList = new ArrayList<String>();
		for (RecruitTagDto recruitTagDto : recruitTagList) {
			TagDto tag = tagService.selectTag(recruitTagDto.getTag().getTagId());
			recruitTagNameList.add(tag.getTagName());
		}
		model.addAttribute("recruitTagNameList", recruitTagNameList);
		model.addAttribute("scrap", null);
		
		
		String forward_path = "recruit-detail";
		return forward_path;
	}

	@RequestMapping("/dashboard-post-job")
	public String dashboard_post_job_form(HttpServletRequest request, Model model) throws Exception {
		CorpDto loginCorp = corpService.findByCorpId((Long) request.getSession().getAttribute("id"));
		model.addAttribute("corp", loginCorp);
		String forward_path = "dashboard-post-job";
		return forward_path;
	}

	@PostMapping("/dashboard-post-job-action")
	public String dashboard_post_job_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request)
			throws Exception {
		CorpDto loginCorp = corpService.findByCorpId((Long) request.getSession().getAttribute("id"));
		recruitDto.setRcDate(LocalDateTime.now());
		recruitDto.setRcDeadline(LocalDateTime.now().plusDays(30));
		recruitDto.setRcStatus(0);
		recruitDto.setCorp(loginCorp);
		recruitDto = recruitService.create(recruitDto);
		String forward_path = "redirect:recruit-detail?id=" + recruitDto.getId();
		return forward_path;
	}

	// 테스트아직 안함
//	   @PostMapping("/dashboard-post-remove-action")
//	   public String dashboard_post_remove_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request) throws Exception {
//		  CorpDto loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
//		  System.out.println(recruitDto);
//		  //recruitService.remove(0);
//	      String forward_path = "redirect:recruit-list";
//	      return forward_path;
//	   }

	@PostMapping("/recruit-delete-action")
	public String recruit_delete_action(@ModelAttribute RecruitDto recruitDto) throws Exception {
		System.out.println("삭제 전");
		System.out.println(">>>>>>>recruit>>>>>>>" + recruitDto);
		System.out.println(recruitDto.getId());
		recruitService.remove(recruitDto.getId());
		System.out.println("삭제 후");
		
		return "redirect:dashboard-manage-job";
	}
 
	@RequestMapping("/recruit-modify-form")
	public String recruit_modify_form(HttpServletRequest request,@ModelAttribute RecruitDto recruitDto, Model model) throws Exception {
		// 일단 회사 정보가져와서 담기
		Long sCorpId =(Long)request.getSession().getAttribute("id");
		CorpDto corpDto=corpService.findByCorpId(sCorpId);
		recruitDto.setCorp(corpDto);
		
		//태그리스트 - 공고태그 연산작업 
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAllByRecruitId(recruitDto.getId());
		List<TagDto>rTagList = new ArrayList<TagDto>();
		for (RecruitTagDto recruitTagDto : recruitTagList) {
			rTagList.add(recruitTagDto.getTag());
		}
		
		List<TagDto>tagList = tagService.selectAll().subList(0, 3); //태그 1~3번만 출력
		tagList.removeAll(rTagList);
		System.out.println(tagList);
		
		
		RecruitDto setRecruit=recruitService.findRecruit(recruitDto.getId());
		System.out.println("setRecruit>>>"+setRecruit);
		model.addAttribute("recruit",setRecruit);
		model.addAttribute("tagList",tagList);
		model.addAttribute("recruitTagList",recruitTagList);
		
		
		return "recruit-modify-form";
	}
	
	@RequestMapping("/recruit-modify-action")
	public String recruit_modify_action(@ModelAttribute RecruitDto recruitDto,Model model,HttpServletRequest request) throws Exception {
		Long sCorpId =(Long)request.getSession().getAttribute("id");
		CorpDto corpDto=corpService.findByCorpId(sCorpId);
		recruitDto.setCorp(corpDto);
		recruitDto.setRcDate(LocalDateTime.now());
		//마감일=등록일+30일로 설정
		recruitDto.setRcDeadline(LocalDateTime.now().plusDays(30));
		recruitDto.setRcStatus(0);
		//System.out.println("pre modify action >>>>"+recruitDto);
		
		RecruitDto checkRecruit = recruitService.update(recruitDto);
		
		
		//System.out.println("update check>>>>"+checkRecruit);
		model.addAttribute("id",recruitDto.getId());
		return "redirect:recruit-detail?id=" + recruitDto.getId();
		
		//RecruitDto updateRecruit= recruitService.update(recruitDto);
		//System.out.println("updateRecruit>>>"+updateRecruit);
		//model.addAttribute("updateRecruit", updateRecruit);
	}
	
	//공고리스트-지원자 이력서보기-승인 버튼 클릭 시
	@RequestMapping("/cv-approve-action")
	public String cv_approve_action(@ModelAttribute AppDto appDto){
		System.out.println("승인 전 컨트롤러 확인");
		System.out.println("appDto>>>>>>>>"+appDto); //appstatus=0,cv=null인 상태
		appDto.setAppStatus(2);
		System.out.println("appDto 승인 버튼 클릭 후>>>>"+appDto); //appstatus=2로 변경됨
		AppDto approveAppDto=appService.updateApp(appDto.getId(), appDto.getAppStatus());
		System.out.println("update된 appDtp>>>>"+approveAppDto); //recruit, cv다 불러옴 +appStatus 2되는 것 확인
		return "redirect:dashboard-applicants?id="+approveAppDto.getRecruit().getId();
	}
	//공고리스트-지원자 이력서보기-거절 버튼 클릭 시
	@RequestMapping("/cv-reject-action")
	public String cv_reject_action(@ModelAttribute AppDto appDto) {
		appDto.setAppStatus(3);
		System.out.println("appDto 거절 버튼 클릭 후>>>>"+appDto);
		AppDto rejectAppDto=appService.updateApp(appDto.getId(), appDto.getAppStatus());
		System.out.println("reject된 appDto>>>>"+rejectAppDto); //recruit, cv다 불러옴 +appStatus 3되는 것 확인
		return "redirect:dashboard-applicants?id="+rejectAppDto.getRecruit().getId();
	}
	
	
}
