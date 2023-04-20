package com.itwill.ilhajob.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.CorpBookmarkDto;
import com.itwill.ilhajob.user.repository.CorpBookmarkRepository;

@Service
public class CorpBookmarkServiceImpl {

	private final CorpBookmarkRepository corpBookmarkRepository;
	private final ModelMapper modelMapper;
	
	public CorpBookmarkServiceImpl(CorpBookmarkRepository corpBookmarkRepository,ModelMapper modelMapper) {
		this.corpBookmarkRepository = corpBookmarkRepository;
		this.modelMapper = modelMapper;
	}
	
	public CorpBookmarkDto createBookmark(CorpBookmarkDto corpBookmarkDto) {
		
		return corpBookmarkDto;
	}
	
}
