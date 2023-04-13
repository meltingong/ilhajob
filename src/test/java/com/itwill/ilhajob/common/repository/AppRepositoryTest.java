package com.itwill.ilhajob.common.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.service.CorpService;

class AppRepositoryTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	private AppRepository appRepository;
	@Autowired
	private CorpService corpService;
	@Autowired
	private ModelMapper modelMapper;
	
	@Test
	void testCountByCorpId() {
		//System.out.println(appRepository.countByCorpId(1L));
	}
	@Test
	void testCountByCorpId2() throws Exception {
		CorpDto corpDto = corpService.findCorp("corp_01");
		Corp corp = modelMapper.map(corpDto, Corp.class);
		//System.out.println(appRepository.countByCorp(corp));
	}

	@Test
	void testFindAppsByRecruitId() {
		//List<App> appList = appRepository.findAppsByRecruitId(1L);
//		List<AppDto> appDtoList = appList.stream()
//									.map(app->modelMapper.map(app, AppDto.class))
//									.collect(Collectors.toList());
	}

	@Test
	void testFindAppsByCvId() {
		
	}

	@Test
	void testFindAppsByUserId() {
		
	}

	@Test
	void testFindAppsByUserEmail() {
		
	}

	@Test
	void testFindAppsByCorpId() {
	//	List<App> appList = appRepository.findAppsByCorpId(1L);
	}

	@Test
	void testFindAppsByCorpLoginId() {
		
	}

}
