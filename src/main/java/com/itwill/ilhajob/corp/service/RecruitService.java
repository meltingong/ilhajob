package com.itwill.ilhajob.corp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;

public interface RecruitService {
	
	//공고등록
	int saveRecruitDto(RecruitDto RecruitDto) throws Exception;
	//공고수정
	int updateRecruitDto(RecruitDto RecruitDto) throws Exception;
	//공고삭제
	int removeRecruitDto(Map<String, Object> map) throws Exception;
	
	List<RecruitDto> findRecruitDtoListAllWithCorp() throws Exception;
	
	//corp회원이 등록한 공고리스트
	List<RecruitDto> findRecruitDtoListByCorpId(CorpDto corp) throws Exception;
	//직무별 공고리스트
	List<RecruitDto> findRecruitDtoListByJob(String job) throws Exception;
	//공고 상세
	RecruitDto findRecruitDto(int rcSeq) throws Exception;
	
	//마감 지났는지 여부 확인
	//boolean isDeadLine(Date rcDeadline) throws Exception;
	
	//마감일 설정
	//Date addDay(Date date,int day) throws Exception;
	
	//마감일 상태변화
	String getStatus(Date rcDeadLine)throws Exception;
}