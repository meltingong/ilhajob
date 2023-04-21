package com.itwill.ilhajob.user.service;

import java.util.List;

import com.itwill.ilhajob.user.dto.RecruitScrapDto;

public interface RecruitScrapService {
	public void insertScrap(RecruitScrapDto recruiScrapDto) throws Exception;
	
	public void deleteScrap(long id) throws Exception;
	
	public List<RecruitScrapDto> sellectByUserId(long userId);
	
	public RecruitScrapDto sellectById(long id);
}
