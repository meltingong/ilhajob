package com.itwill.ilhajob.corp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.repository.CorpRepository;

class CorpServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	CorpService corpService;
	@Autowired
	CorpRepository corpRepository;
	
	@Disabled
	@Test
	void testLogin() throws Exception {
		//System.out.println(corpService.findCorp("corp_01"));
		Corp corp = corpRepository.findById(5L).orElse(null);
		System.out.println(corp);
	}
	@Disabled
	@Test
	void testFindCorp() throws Exception {
		System.out.println(corpService.findByCorpLoginId("corp_03"));
	}
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented"); // TODO
	}
	
	//corpName으로 검색기능구현
	@Test
	void testSearchBycorpName()throws Exception {
		Corp corp1=corpRepository.findById(2L).orElse(null);
		Corp corp2=corpRepository.findById(3L).orElse(null);
		System.out.println("corp1>>>>>>>>>>"+corp1);
		System.out.println("corp2>>>>>>>>>>"+corp2);
		corpRepository.save(corp1);
		corpRepository.save(corp2);
		List<CorpDto> result1=corpService.searchByCorpName("우아");
		List<CorpDto> result2=corpService.searchByCorpName("우아한청년들");
		System.out.println("result1:회사이름 일부만 쳤을때>>>>>>>>>>"+result1);
		System.out.println("result2:회사이름 전체 쳤을때>>>>>>>>>>"+result2);
	}
	
}
