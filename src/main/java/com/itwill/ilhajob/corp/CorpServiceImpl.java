package com.itwill.ilhajob.corp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpServiceImpl implements CorpService{
	
	@Autowired
	private CorpDao corpDao;
}
