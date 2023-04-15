package com.itwill.ilhajob.corp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.repository.AppRepository;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;

class RecruitServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	private RecruitService recruitService;
	@Autowired
	private AppService appService;
	@Autowired
	private AppRepository appRepository;
	@Autowired
	private ModelMapper modelMapper;
	
//	@Test
//	void testFindAllByCorpId() throws Exception {
//		System.out.println(recruitService.findAllByCorpId(1L));
//	}
	
//	App table 때문에 테스트 안됨->DataintegrityException....
	@Test
	void testRemove() throws Exception {
		recruitService.remove(16L);
	}
		
/*		List<AppDto> appList=appService.findAllByRecruitId(1L);
		System.out.println(appList);

	
//	@Disabled
//	@Test
//	void testUpdate() throws Exception{
//		RecruitDto updateRecruit=RecruitDto.builder()
//										   .rcContent("수정내용")
//										   .rcPosition("수정직급")
//										   .build();
//		recruitService.update(1L, updateRecruit);
//	}
	
}
*/
}