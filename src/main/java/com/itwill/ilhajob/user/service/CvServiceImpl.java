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

@Service
public class CvServiceImpl implements CvService{

	@Autowired
	private CvRepository cvRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CvDto saveCv(CvDto cvDto) {
		Cv cv = modelMapper.map(cvDto, Cv.class);
		cvRepository.save(cv);
		return modelMapper.map(cv,CvDto.class);
	}

	@Override
	public void removeById(Long id) {
		cvRepository.deleteById(id);
	}

	@Override
	public CvDto findCvById(Long id) {
		Optional<Cv> cv = cvRepository.findById(id);
		return modelMapper.map(cv, CvDto.class);
	}

	@Override
	public List<CvDto> findCvByUserId(Long userId) {
		return cvRepository.findCvByUserId(userId);
	}

	@Override
	public List<CvDto> findAll() {
		List<Cv> cvList = cvRepository.findAll();
		return cvList.stream().map(cv -> modelMapper.map(cvList, CvDto.class)).collect(Collectors.toList());
	}
}
