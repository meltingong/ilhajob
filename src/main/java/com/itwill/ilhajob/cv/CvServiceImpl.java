package com.itwill.ilhajob.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService{

	@Autowired
	private CvDao cvDao;
}
