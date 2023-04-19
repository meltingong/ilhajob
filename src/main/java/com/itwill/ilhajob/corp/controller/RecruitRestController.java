package com.itwill.ilhajob.corp.controller;

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
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
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
	public Map<String,Object> getRecruitTagData(@RequestBody Map<String,String> data){
		System.out.println("컨트롤러도착");
		Map<String, Object> map = new HashMap<String,Object>();
		
		//전체태그선택
		if(data.get("tagId").equals("전체")) {
			System.out.println(data.get("tagId"));
			List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
			System.out.println("전체실행완료");
			map.put("data", recruitTagList);
			List<TagDto> tagList = tagService.selectAll();
			map.put("tagData", tagList);
			return map;
		}else {
		//일부태그선택
		Long tagId = Long.parseLong(data.get("tagId"));
		System.out.println(tagId);
		List<RecruitTagDto> corpTagList= recruitTagService.selectAllBytagId(tagId);
		map.put("data", corpTagList);
		System.out.println("태그선택실행완료");
		List<TagDto> tagList = tagService.selectAll();
		map.put("tagData", tagList);
		
		TagDto tag = tagService.selectTag(tagId);
		map.put("tag", tag);
		return map;
		}
	}
}
