package com.itwill.ilhajob.recruit;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

public class RecruitDaoImpl implements RecruitDao {
	
	@Autowired
	private RecruitMapper recruitMapper;
	
	
}
