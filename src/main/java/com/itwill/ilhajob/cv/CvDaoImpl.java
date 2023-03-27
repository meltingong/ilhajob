package com.itwill.ilhajob.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.cv.mapper.CvMapper;

@Repository
public class CvDaoImpl implements CvDao{

	@Autowired
	private CvMapper cvMapper;
}
