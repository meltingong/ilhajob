package com.itwill.ilhajob.corp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.repository.CorpRepository;

class CorpServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	CorpService corpService;
	@Autowired
	CorpRepository corpRepository;
	
	//@Disabled
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
}
