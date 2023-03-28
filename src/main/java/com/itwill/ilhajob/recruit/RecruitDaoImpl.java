package com.itwill.ilhajob.recruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

@Repository
public class RecruitDaoImpl implements RecruitDao {
	
	@Autowired
	private RecruitMapper recruitMapper;
	
	
}
