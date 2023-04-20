package com.itwill.ilhajob.corp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController
public class RecruitRestController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private TagService tagService;
	@Autowired
	private RecruitTagService recruitTagService;
	
	@PostMapping(value="/getRecruitTag", produces = "application/json;charset=UTF-8")
	public Map<String,Object> getRecruitTagData(@RequestBody Map<String,String> data) throws Exception{
		System.out.println("컨트롤러도착");
		Map<String, Object> map = new HashMap<String,Object>();
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		List<RecruitTagListDto> recruitTagListDto = new ArrayList<RecruitTagListDto>();
		Long id = 0L;
		List<TagDto> tagList = new ArrayList<TagDto>();
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
		return map;
		
		}
	}
}
