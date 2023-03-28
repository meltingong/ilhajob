package com.itwill.ilhajob.exp;

import java.util.List;

public interface ExpService {
	
	/*
	 * 경력사항 추가
	 */
	int insertExp(Exp exp);
	
	/*
	 * 유저seq로 경력사항 찾기
	 */
	
	List<Exp> selectByUserSeq(int userSeq);
	
	/*
	 * 
	 */
	
}
