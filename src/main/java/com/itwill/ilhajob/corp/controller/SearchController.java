package com.itwill.ilhajob.corp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.dto.RecruitScrapDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.service.RecruitScrapService;
import com.itwill.ilhajob.user.service.UserService;

@Controller
public class SearchController {
		
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
	private RecruitScrapService recruitScrapService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/searchMain", method = RequestMethod.GET)
		public String searchRecruit(@RequestParam("searchKeyword") String searchKeyword, 
								  @RequestParam("searchSelect") String searchSelect,
								  @RequestParam(defaultValue = "0", name = "page") int curPage,
								  @RequestParam(defaultValue = "6") int pageScale,
			                      @RequestParam(defaultValue = "5") int blockScale,
								  Pageable pageable,
		                          Model model, HttpServletRequest request) {
		    try {
				pageable = PageRequest.of(curPage, pageScale, Sort.Direction.ASC, "id");
				Page<RecruitDto> searchRecruitList = recruitService.searchRcTitle(searchSelect, curPage, pageScale);
				
				//페이지블록번호
				int curBlock = (int) Math.ceil((searchRecruitList.getNumber()) / blockScale) + 1;
			    System.out.println("페이지블록번호 :"+curBlock);
			    //페이지 블록의 시작번호
			 	int blockBegin = (curBlock - 1) * blockScale + 1;
			 	//페이지 블록의 끝 번호
			 	int	blockEnd = blockBegin + blockScale - 1;
			 	System.out.println("페이지블록시작번호 :"+blockBegin);
			 	System.out.println("페이지블록  끝번호 :"+blockEnd);
		  	 	model.addAttribute("blockBegin", blockBegin);
		  	 	model.addAttribute("blockEnd", blockEnd);
		  	    model.addAttribute("curPage", searchRecruitList.getNumber());
		  	    model.addAttribute("totalPage", searchRecruitList.getTotalPages());
		  	    model.addAttribute("prePage", searchRecruitList.previousOrFirstPageable().getPageNumber());
		  	    model.addAttribute("nextPage", searchRecruitList.nextOrLastPageable().getPageNumber());
			 	
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
			 	
		    } catch (Exception e) {
		        // 예외 처리
		        e.printStackTrace();
		        model.addAttribute("errorMsg", "검색어를 찾을 수 없습니다!");
		    }
		    return "recruitList";
		}

}
