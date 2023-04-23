package com.itwill.ilhajob.corp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.dto.RecruitTagListDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.dto.RecruitScrapDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.service.RecruitScrapService;
import com.itwill.ilhajob.user.service.UserService;

@RestController
public class RecruitRestController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private TagService tagService;
	@Autowired
	private RecruitTagService recruitTagService;
	@Autowired
	private UserService userService;
	@Autowired
	private RecruitScrapService recruitScrapService;
	
	@PostMapping(value="/getRecruitTag", produces = "application/json;charset=UTF-8")
	public Map<String,Object> getRecruitTagData(@RequestBody Map<String,String> data,HttpServletRequest request) throws Exception{
		System.out.println("컨트롤러도착");
		Map<String, Object> map = new HashMap<String,Object>();
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		List<RecruitTagListDto> recruitTagListDto = new ArrayList<RecruitTagListDto>();
		Long id = 0L;
		List<TagDto> tagList = new ArrayList<TagDto>();
		
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		UserDto loginUser = null;
		if(sUserId!=null) {
			loginUser = userService.findUser(sUserId);
		}
		map.put("loginUser", loginUser);
		
		if(loginUser!=null) {
		//스크랩 (북마크)로고 출력
			List<RecruitScrapDto> recruitScrapList = recruitScrapService.sellectByUserId(loginUser.getId());
			//스크랩확인 카운트 리스트
			List<Integer> countList = new ArrayList<Integer>();
			countList.add(0); //테이블은 1부터 id가 있으니 처음은 0
			
			for(RecruitDto recruit :recruitList) {
			    boolean hasRecruitScrap = false; // 리크루트 스크랩이 있는지 여부를 나타내는 변수
			    for(RecruitScrapDto recruitscrap:recruitScrapList) {
			        if(recruit.getId() == recruitscrap.getRecruit().getId()) {
			            hasRecruitScrap = true; // 리크루트 스크랩이 있을 때
			            break; // 리크루트 스크랩이 있으면 반복문 종료
			        }
			    }
			    if(hasRecruitScrap) {
			        countList.add(1); // 리크루트 스크랩이 있을 때
			    } else {
			        countList.add(0); // 리크루트 스크랩이 없을 때
			    }
			}
			System.out.println("로그인유저:"+loginUser+"카운트"+countList+"스크랩리스트"+recruitScrapList);
			map.put("countList", countList);
		}
		//전체태그선택
		if(data.get("tagId").equals("전체")) {
			List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
			
			for(RecruitDto recruit : recruitList) {
				tagList=new ArrayList<TagDto>();
				for(RecruitTagDto recruitTag:recruitTagList) {
					
					if(recruitTag.getRecruit().getId()==recruit.getId()) {
								id = recruitTag.getId();
								tagList.add(recruitTag.getTag());
					}
					
				}
				recruitTagListDto.add(RecruitTagListDto.builder().id(id).recruit(recruit).tagList(tagList).build());
			}
			map.put("data", recruitTagListDto);
			System.out.println("전체실행완료");
			return map;
		}else {
		//일부태그선택시
		Long tagId = Long.parseLong(data.get("tagId"));
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAllBytagId(tagId);
		
		for(RecruitTagDto recruitTag:recruitTagList) {
			tagList= new ArrayList<TagDto>();
			Long rId = recruitTag.getRecruit().getId();
			List<RecruitTagDto> recruitTagListByRecruitid = recruitTagService.selectAllByRecruitId(rId);
			for(RecruitTagDto recruitTagDto: recruitTagListByRecruitid) {
				tagList.add(recruitTagDto.getTag());
			}
			recruitTagListDto.add(RecruitTagListDto.builder().id(id).recruit(recruitTag.getRecruit()).tagList(tagList).build());
		}
		
		map.put("data", recruitTagListDto);
		System.out.println("태그선택실행완료");
		System.out.println(map);
		return map;
		
		}
	}
}

	
