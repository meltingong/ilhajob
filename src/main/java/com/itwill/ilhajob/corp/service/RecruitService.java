package com.itwill.ilhajob.corp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;

public interface RecruitService {
	
	//공고등록
	int save(RecruitDto RecruitDto) throws Exception;
	//공고수정
	int update(RecruitDto RecruitDto) throws Exception;
	//공고삭제
	int remove(Map<String, Object> map) throws Exception;
	
	List<RecruitDto> findRecruitAll() throws Exception;
	
	//공고 상세
	RecruitDto findRecruitDto(int rcSeq) throws Exception;
	
	//마감 지났는지 여부 확인
	//boolean isDeadLine(Date rcDeadline) throws Exception;
	
	//마감일 설정
	//Date addDay(Date date,int day) throws Exception;
	
	//마감일 상태변화
	String getStatus(Date rcDeadLine)throws Exception;
}