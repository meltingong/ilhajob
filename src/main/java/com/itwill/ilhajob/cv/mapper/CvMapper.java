package com.itwill.ilhajob.cv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.cv.Cv;

@Mapper
public interface CvMapper {
	
	public Cv selectByCv(int cvSeq);
	
	public List<Cv> selectAll();
	
	public Cv selectByCvOfUserEmail(String userEmail);
	
	public int insertCv(Cv cv);
	
	public int updateCv(Cv cv);
	
	public int deleteCv(int cvSeq);
}