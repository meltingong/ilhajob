package com.itwill.ilhajob.exp;

public class ExpDaoTest {

	public static void main(String[] args) {
		ExpDaoImpl expDaoImpl = new ExpDaoImpl();
		
		System.out.println("userSeq 2번으로 경력사항 찾기");
		System.out.println(expDaoImpl.selectByUser(2));
		
		System.out.println("test2@test.com 이메일로 경력사항 찾기");
		System.out.println(expDaoImpl.selectByUserEmail("test2@test.com"));
	}

}
