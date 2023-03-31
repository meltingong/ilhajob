package com.itwill.ilhajob.corp;

import com.itwill.ilhajob.user.User;

public interface CorpService {

	/*
	 * 기업가입
	 */
	// id, password, name 으로 가입
	int create(User user) throws Exception;

	/*
	 * 기업로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공
	 */
	int login(Corp corp) throws Exception;
	/*
	 * 기업로그아웃
	 */

	/*
	 * 기업상세보기
	 */
	User findUser(String corpId) throws Exception;

	/*
	 * 기업 추가정보등록 및 수정
	 */
	int update(Corp corp) throws Exception;

	/*
	 * 기업탈퇴
	 */
	int remove(String corpId) throws Exception;

	/*
	 * 아이디중복체크
	 */
	boolean isDuplicateId(String corpId) throws Exception;
	
	/*
	 * 
	 */
	
	
}
