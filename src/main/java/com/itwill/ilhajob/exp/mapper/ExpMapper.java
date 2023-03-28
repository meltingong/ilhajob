package com.itwill.ilhajob.exp.mapper;

import java.util.List;

import com.itwill.ilhajob.exp.Exp;

public interface ExpMapper {

	public Exp selectByExp(int expSeq);
	
	public List<Exp> selectAll();
	
	public List<Exp> selectByUserSeq(int userSeq);
	
	public int insertExp(Exp exp);
	
	public int updateExp(Exp exp);
	
	public int deleteExp(int expSeq);
}
