package com.itwill.ilhajob.exp;

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
	 * 
	 */
	
}
