package com.itwill.ilhajob.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.AwardsDto;
import com.itwill.ilhajob.user.entity.Awards;
import com.itwill.ilhajob.user.repository.AwardsRepository;

@Service
public class AwardsServiceImpl implements AwardsService {
	
	@Autowired
	private AwardsRepository awardsRepository;
	@Autowired
	private ModelMapper mapper;	
	
	public AwardsServiceImpl(AwardsRepository awardsRepository, ModelMapper mapper) {
		this.awardsRepository = awardsRepository;
		this.mapper = mapper;
	}

	@Override
	public AwardsDto saveAwards(AwardsDto awardsDto) {
		Awards awards = mapper.map(awardsDto, Awards.class);
		awardsRepository.save(awards);
		return mapper.map(awards, AwardsDto.class);
	}

	@Override
	public void removeAwardsById(Long id) {
		awardsRepository.deleteById(id);
	}
	
	@Override
	public void removeAwardsByUserId(Long userId) {
		awardsRepository.deleteById(userId);
	}
	
	@Override
	public AwardsDto findAwardsById(Long id) {
		Awards awards = awardsRepository.findById(id).get();
		return mapper.map(awards, AwardsDto.class);
	}

	@Override
	public List<AwardsDto> findAwardsByUserId(Long userId) {
		List<Awards> tempList = awardsRepository.findAllById(userId);
		List<AwardsDto> awardsList = tempList.stream().map(award -> mapper.map(tempList, AwardsDto.class)).collect(Collectors.toList());
		return awardsList;
	}

	@Override
	public List<AwardsDto> findAwardsList() {
		List<Awards> tempList = awardsRepository.findAll();
		List<AwardsDto> awardsList = tempList.stream().map(awards -> mapper.map(tempList, AwardsDto.class)).collect(Collectors.toList());
		return awardsList;
	}
}
