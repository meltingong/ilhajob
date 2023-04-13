package com.itwill.ilhajob.corp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;

class RecruitServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	private RecruitService recruitService;
	
	@Test
	void testFindAllByCorpId() throws Exception {
		System.out.println(recruitService.findAllByCorpId(1L));
	}

}
