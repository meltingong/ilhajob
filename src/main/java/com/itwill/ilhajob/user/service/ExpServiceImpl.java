package com.itwill.ilhajob.user.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.ExpDto;
import com.itwill.ilhajob.user.entity.Exp;
import com.itwill.ilhajob.user.repository.ExpRepository;
@Service
public class ExpServiceImpl implements ExpService{
	
	private final ExpRepository expRepository;
	private final ModelMapper modelMapper;
	
	public ExpServiceImpl(ExpRepository expRepository, ModelMapper modelMapper) {
		this.expRepository = expRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ExpDto createExp(ExpDto expDto) {
		Exp exp = modelMapper.map(expDto, Exp.class);
		exp = expRepository.save(exp);
		return modelMapper.map(exp, ExpDto.class);
	}

	@Override
	public ExpDto updateExp(Long id, ExpDto expDto) {
		Optional<Exp> exp = expRepository.findById(id);
		exp.get().setExpContent(expDto.getExpContent());
		exp.get().setExpCorpName(expDto.getExpCorpName());
		exp.get().setExpPosition(expDto.getExpPosition());
		exp.get().setExpStartDate(expDto.getExpStartDate());
		exp.get().setExpEndDate(expDto.getExpEndDate());
		return modelMapper.map(exp, ExpDto.class);
	}

	@Override
	public void removeById(Long id) {
		expRepository.deleteById(id);
	}

	@Override
	public List<ExpDto> findExpListByUserId(Long userId) {
		List<Exp> expList = expRepository.findByUserId(userId);
		return null;
	}

	@Override
	public List<ExpDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
