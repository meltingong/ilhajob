package com.itwill.ilhajob.corp.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.repository.RecruitRepository;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	private RecruitRepository recruitRepository;
	private ModelMapper modelMapper;
	
	public RecruitServiceImpl(RecruitRepository recruitRepository, ModelMapper modelMapper) {
		this.recruitRepository = recruitRepository;
		this.modelMapper = modelMapper;
	}
	
	
	
	//마감일 됐는지 여부 확인
//	@Override
//	public boolean isDeadLine(Date rcDeadline) throws Exception {
//		Date now=new Date();
//		return now.after(rcDeadline);
//	}
	
//	//마감일 설정
//	@Override
//	public Date addDay(Date date, int day) throws Exception {
//		long time=date.getTime();
//		time+=day*24*60*60*1000;
//		return new Date(time);
//	}

	//마감일 
	@Override
	public String getStatus(Date rcDeadLine) throws Exception {
		//현재 시간으로 초기화
		LocalDate today=LocalDate.now();
		LocalDate deadLineLocalDate=rcDeadLine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long daysUntilDeadLine=ChronoUnit.DAYS.between(today, deadLineLocalDate);
		
		if (daysUntilDeadLine < 0) {
            return "마감";
        } else if (daysUntilDeadLine == 0) {
            return "마감 예정";
        } else {
            return "D-" + daysUntilDeadLine;
        }
	}



	@Override
	public int saveRecruitDto(RecruitDto RecruitDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int updateRecruitDto(RecruitDto RecruitDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int removeRecruitDto(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<RecruitDto> findRecruitDtoListAllWithCorp() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RecruitDto> findRecruitDtoListByCorpId(CorpDto corp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RecruitDto> findRecruitDtoListByJob(String job) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public RecruitDto findRecruitDto(int rcSeq) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
