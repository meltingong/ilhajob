package com.itwill.ilhajob.corp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.CorpTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.service.CorpService;

@RestController
public class CorpRestController {
	@Autowired
	private TagService tagService;
	@Autowired
	private CorpTagService corpTagService;
	@Autowired
	private CorpService corpService;
	
	@PostMapping(value="/getTagData", produces = "application/json;charset=UTF-8")
	public Map<String, Object> getTagData(@RequestBody Map<String,String> data,Model model){
		Map<String, Object> map = new HashMap<String,Object>();
		
		
		//전체태그선택
		if(data.get("tagId").equals("전체")) {
			List<CorpTagDto> corpTagList = corpTagService.selectAll();
			
			map.put("data", corpTagList);
			return map;
		}else {
		//일부태그선택
		Long tagId = Long.parseLong(data.get("tagId"));
		System.out.println(tagId);
		List<CorpTagDto> corpTagList= corpTagService.selectListByTagId(tagId);
		
		map.put("data", corpTagList);
		return map;
		}
		
	}
	
	//corpName으로 검색
//	@GetMapping("/search")	
//	public List<CorpDto> searchByCorpName(@RequestParam("corpName")String corpName) throws Exception{
//		System.out.println("검색 컨트롤러");
//		List<CorpDto> corpSearchList=corpService.searchByCorpName(corpName);
//		System.out.println("searchList>>>>>>>>>"+corpSearchList);
//		return corpSearchList;
//	}
	
	
}
