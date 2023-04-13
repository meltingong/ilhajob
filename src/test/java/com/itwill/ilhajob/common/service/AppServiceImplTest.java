package com.itwill.ilhajob.common.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.common.dto.AppDto;

class AppServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	private AppService appService;
	
	@Test
	void testFindAllByRecruitId() {
		System.out.println(appService.findAllByRecruitId(1L));
		List<AppDto> appDtoList = appService.findAllByRecruitId(1L);
		
	}

	@Test
	void testFindAllByUserId() {
		System.out.println(appService.findAllByUserId(1L));
	}

}
