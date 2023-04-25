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
import org.springframework.data.domain.Page;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.repository.AppRepository;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.corp.repository.RecruitRepository;

class RecruitServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	private RecruitService recruitService;
	@Autowired
	private AppService appService;
	@Autowired
	private AppRepository appRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RecruitRepository recruitRepository;
	
//	@Test
//	void testFindAllByCorpId() throws Exception {
//		System.out.println(recruitService.findAllByCorpId(1L));
//	}
	
//	App table 때문에 테스트 안됨->on delete set null 추가함
//	@Test
//	void testRemove() throws Exception {
//		recruitService.remove(1L);
//	}

//	@Test
//	void testUpdate() throws Exception{
//		RecruitDto updateRecruit=RecruitDto.builder()
//										   .rcTitle("수정제목")
//										   .rcContent("수정내용")
//										   .rcPosition("수정직급")
//										   .build();
//		recruitService.update(2L, updateRecruit);
//	}
	
	@Disabled
	@Test
	void testGetRecruitList() throws Exception{
		int page=0;
		int size=10;
		Page<RecruitDto> recruitDtoPage=recruitService.getRecruitList(page, size);
		List<RecruitDto> recruitDtoList=recruitDtoPage.getContent();
		assertEquals(size, recruitDtoList.size());
	}
	
	@Test
	void testIncreaseReadCount()throws Exception {
		RecruitDto recruit=new RecruitDto();
		recruit=recruitService.findRecruit(1L);
		System.out.println("recruit>>>>"+recruit);
		
		//recruitRepository.save(recruit);
		
		Long id=recruit.getId();
		System.out.println("id보자>>>>"+id);//1뜸
		System.out.println("증가전조회수>>>>"+recruit.getRcReadCount());
		recruitService.increaseReadCount(id);
	    System.out.println("증가후조회수>>>>>"+recruit.getRcReadCount());
		
	}
	
	
	
	
	
	
	
	
}