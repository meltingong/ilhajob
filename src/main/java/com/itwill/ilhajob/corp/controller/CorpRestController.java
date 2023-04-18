package com.itwill.ilhajob.corp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.service.CorpTagService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.service.CorpService;

@RestController
public class CorpRestController {
	@Autowired
	private CorpTagService corpTagService;
	@Autowired
	private CorpService corpService;
	
	@GetMapping("/getTagData")
	public HashMap<String, Object> getTagData(@RequestParam Long tagId){
		HashMap<String, Object> map = new HashMap<String,Object>();
		List<CorpTagDto> corpTagList= corpTagService.selectAllByCorpId(tagId);
		map.put("data", corpTagList);
		System.out.println(corpTagList);
		return map;
	}
	
	//corpName으로 검색
	@GetMapping("/search")
	public List<CorpDto> searchByCorpName(@RequestParam("corpName")String corpName) throws Exception{
		List<CorpDto> corpSearchList=corpService.searchByCorpName(corpName);
		return corpSearchList;
	}
	
	
}
