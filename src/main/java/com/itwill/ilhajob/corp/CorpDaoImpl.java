package com.itwill.ilhajob.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.mapper.CorpMapper;

@Repository
public class CorpDaoImpl implements CorpDao{
	@Autowired
	private CorpMapper corpMapper;
	
	public int insertCorp(Corp corp) {
		return corpMapper.insertCorp(corp);
	}
	
	public Corp selectById(String corpId) {
		return corpMapper.selectById(corpId);
	}
	
	public Corp findCorpByIdWithCorpImage(String corpId) {
		return corpMapper.findCorpByIdWithCorpImage(corpId);
	}
	
	public List<Corp> selectAll() throws Exception{
		return corpMapper.selectAll();
	}
	
	public int updateCorp(Corp corp) {
		int updateRowCount = corpMapper.updateCorp(corp);
		return updateRowCount;
	}
	
	public int deleteCorp(Corp corp) {
		int deleteRowCount = corpMapper.updateCorp(corp);
		return deleteRowCount;
	}
}
