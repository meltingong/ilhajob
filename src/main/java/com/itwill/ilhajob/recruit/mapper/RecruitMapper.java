package com.itwill.ilhajob.recruit.mapper;

import java.util.List;

import com.itwill.ilhajob.recruit.Recruit;

public interface RecruitMapper {
	
	public int insertRecruit();
	
	public int updateBySeq();
	
	public int deleteBySeq();
	
	public List<Recruit> findByCorpId();
	
	public List<Recruit> findByJob();
	
	public Recruit findBySeq();
}
