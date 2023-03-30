package com.itwill.ilhajob.corp;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpDao {
	
	// 회사계정 회원가입(아이디,비밀번호,회사명만 입력)
	int insertCorp(Corp corp) throws Exception;
	
	// 회사계정 아이디로 회사정보 가져오기
	Corp selectById(String corpId) throws Exception;
	
	// 모든 회사정보 가져오기
	List<Corp> selectAll() throws Exception;
	
	Corp findCorpByIdWithAll(String corpId);
	public Corp findCorpByIdWithOrders(String corpId);
	
	// 회사 추가정보 입력하기(id로 식별)
	int updateCorp(Corp corp) throws Exception;
	
	// 회사 삭제하기(id로 식별)
	int deleteCorp(Corp corp) throws Exception;
	
	int existedCorp(String corpId);
}
