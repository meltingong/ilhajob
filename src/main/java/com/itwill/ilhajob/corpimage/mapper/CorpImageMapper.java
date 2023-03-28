package com.itwill.ilhajob.corpimage.mapper;

import java.util.List;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.corpimage.CorpImage;

public interface CorpImageMapper {
	public int insertCorpImage(CorpImage corp_image);
	public CorpImage selectBySEQ(int corp_image_seq);
	public List<CorpImage> selectById(String corp_id);
	public List<CorpImage> selectAll();
	public int updateCorpImage(CorpImage corp_image);
	public int deleteCorpImageById(String corp_id);
	public int deleteCorpImageBySEQ(int corp_image_seq);
}
