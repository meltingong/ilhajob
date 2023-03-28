package com.itwill.ilhajob.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.recruit.Recruit;

@Mapper
public interface RecruitMapper {
	
	public int insertRecruit();
	
	public int updateBySeq();
	
	public int deleteBySeq();
	
	public List<Recruit> findByCorpId();
	
	public List<Recruit> findByJob();
	
	public Recruit findBySeq();
}
