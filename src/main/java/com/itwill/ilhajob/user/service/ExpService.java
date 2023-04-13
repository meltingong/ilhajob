package com.itwill.ilhajob.user.service;

import java.util.List;

import com.itwill.ilhajob.user.dto.ExpDto;

public interface ExpService {
	ExpDto createExp(ExpDto exp);
	
	ExpDto updateExp(Long id, ExpDto exp);
	
	void removeById(Long id);
	
	List<ExpDto> findExpListByUserId(Long userId);
	
	List<ExpDto> findAll();
}
