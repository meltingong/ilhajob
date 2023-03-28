package com.itwill.ilhajob.corpimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corpimage.mapper.CorpImageMapper;

@Repository
public class CorpImageDaoImpl {
	@Autowired
	private CorpImageMapper corpImageMapper;
	
	public int insertCorpImage(CorpImage corpImage) {
		int insertRowCount = corpImageMapper.insertCorpImage(corpImage);
		return insertRowCount;
	}
}
