package com.itwill.ilhajob.corpimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corpimage.mapper.CorpImageMapper;

@Repository
public class CorpImageDaoImpl {
	@Autowired
	private CorpImageMapper corpImageMapper;
	//회사이미지 1개 추가
	public int insertCorpImage(CorpImage corpImage) {
		return corpImageMapper.insertCorpImage(corpImage);
	}
	//회사 이미지 1개 선택 
	public CorpImage selectBySeq(int corpImageSeq) {
		return corpImageMapper.selectBySEQ(corpImageSeq);
	}
	//회사 이미지리스트 선택
	public List<CorpImage> selectBySeq(String corpId) {
		return corpImageMapper.selectById(corpId);
	}
	//전 회사 이미지리스트 선택
	public List<CorpImage> selectAll(){
		return corpImageMapper.selectAll();
	}
	//회사이미지 수정
	public int updateCorpImage(CorpImage corpImage) {
		return corpImageMapper.updateCorpImage(corpImage);
	}
	public int deleteCorpImageById(String corpId) {
		return corpImageMapper.deleteCorpImageById(corpId);
	}
	public int deleteCorpImageBySEQ(int corpImageSeq) {
		return corpImageMapper.deleteCorpImageBySEQ(corpImageSeq);
	}
}
