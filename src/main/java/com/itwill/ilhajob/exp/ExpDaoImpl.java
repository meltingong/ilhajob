package com.itwill.ilhajob.exp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.exp.mapper.ExpMapper;

@Repository
public class ExpDaoImpl {
	@Autowired
	private ExpMapper expMapper;
	
	public ExpDaoImpl(ExpMapper expMapper) {
		this.expMapper = expMapper;
	}

	public ExpDaoImpl() {

	}
	
	public ExpMapper getExpMapper() {
		return expMapper;
	}
	
	public void setExpMapper(ExpMapper expMapper) {
		this.expMapper = expMapper;
	}
	
	/*
	 * 경력 전체보기 (admin 없어서 필요없을 것 같음)
	 
	 public List<Exp> selectAll(){
		 List<Exp> expList = expMapper.selectAll();
		 return expList;
	 }
	*/

	/*
	 * 경력 seq로 경력사항 찾기(필요없을 듯)
	 * 
		public Exp selectByExpSeq(int expSeq) {
			Exp findExp = expMapper.selectByExp(expSeq);
			return findExp;
		}
	 * 
	 */
	
	
	 /*
	  * 한 유저의 경력 전체보기(userSeq로 찾기)
	  */
	 
	 public List<Exp> selectByUser(int userSeq){
		 List<Exp> expList = expMapper.selectByUserSeq(userSeq);
		 return expList;
	 }
	
	 
	 
}
