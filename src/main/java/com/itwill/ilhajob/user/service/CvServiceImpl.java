package com.itwill.ilhajob.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.entity.Cv;
import com.itwill.ilhajob.user.repository.CvRepository;

import lombok.RequiredArgsConstructor;

@Service
public class CvServiceImpl implements CvService{

	private final CvRepository cvRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public CvServiceImpl(CvRepository cvRepository, ModelMapper modelMapper) {
		this.cvRepository = cvRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CvDto saveCv(CvDto cvDto) {
		Cv cv = modelMapper.map(cvDto, Cv.class);
		cvRepository.save(cv);
		return modelMapper.map(cv,CvDto.class);
	}
	
	public CvDto updateCv(Long id, CvDto cvDto) {
		Cv cv = cvRepository.findById(id).get();
		cv.builder()
		.cvName(cvDto.getCvDescription())
		.cvDescription(cvDto.getCvDescription())
		.cvPortfolio(cvDto.getCvPortfolio())
//		.awardslist(cvDto.getAwardsList())
//		.edulist(cvDto.getEduList())
//		.explist(cvDto.getExpList())
		.build();
		cvRepository.save(cv);
		return modelMapper.map(cv, CvDto.class);
//		cvDto = modelMapper.map(cv, CvDto.class);
//		return cvDto;
	};
	

	@Override
	public void removeById(Long id) {
		cvRepository.deleteById(id);
		cvRepository.flush();
	}

	@Override
	public CvDto findCvById(Long id) {
		Cv cv = cvRepository.findById(id).get();
		return modelMapper.map(cv, CvDto.class);
	}

	@Override
	public List<CvDto> findCvByUser(Long id) {
		List<Cv> cvList = cvRepository.findById(id).get().getUser().getCvList();
//		List<Cv> cvList = cvRepository.findById(id).orElse(null).getUser().getCvList();
		return cvList.stream().map(cv -> modelMapper.map(cv, CvDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CvDto> findCvAll() {
		List<Cv> cvList = cvRepository.findAll();
		return cvList.stream().map(cv -> modelMapper.map(cv, CvDto.class)).collect(Collectors.toList());
	}
}
