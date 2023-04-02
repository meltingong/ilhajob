package com.itwill.ilhajob.corp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.corp.Corp;

@Mapper
public interface CorpMapper {
	/*
	 * 메쏘드이름은 	GuestMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 GuestMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 GuestMapper.xml 파일의 resultType 와일치
	 */
	public Corp selectById(String corpId);
	public List<Corp> selectAll();
	//회사 이미지리스트와 매니저정보 리스트로 불러오기
	public Corp findCorpByIdWithAll(String corpId);
	//회사 오더와 상품정보 가져오기
	public Corp findCorpByIdWithOrders(String corpId);
	//회사 공고정보목록 가져오기
	public Corp findCorpByIdWithRecruit(String corpId);
	//회사 리뷰 목록 가져오기
	public Corp findCorpByIdWithReview(String corpId);
	
	public int insertCorp(Corp corp);
	public int deleteCorp(String corpId);
	public int updateCorp(Corp corp);
	
	public int existedCorp(String corpId); 
}
