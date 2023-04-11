package com.itwill.ilhajob.corp.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.corp.repository.RecruitRepository;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	private RecruitRepository recruitRepository;
	private ModelMapper modelMapper;
	
	public RecruitServiceImpl(RecruitRepository recruitRepository, ModelMapper modelMapper) {
		this.recruitRepository = recruitRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public List<RecruitDto> findRecruitAll() throws Exception {
		List<Recruit> recruitList = recruitRepository.findAll();
		return recruitList.stream()
				.map(recruit ->modelMapper.map(recruit, RecruitDto.class))
				.collect(Collectors.toList());
	}
	@Override
	public RecruitDto findRecruit(long id) throws Exception {
		Optional<Recruit> optionalRecurit = recruitRepository.findById(id);
		Recruit findRecruit = optionalRecurit.get();
		return modelMapper.map(findRecruit, RecruitDto.class);
	}
	
	@Override
	public int save(RecruitDto RecruitDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(RecruitDto RecruitDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int remove(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
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
	
}
