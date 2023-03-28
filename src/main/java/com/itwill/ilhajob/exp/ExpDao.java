package com.itwill.ilhajob.exp;

import java.util.List;

public interface ExpDao {
	
	int insertExp(Exp exp);
	
	List<Exp> selectByNo(int expSeq);
	
	//List<Exp> selectAll();
	
	int updateExp(Exp exp);
	
	int deleteExp(int expSeq);
	
}
