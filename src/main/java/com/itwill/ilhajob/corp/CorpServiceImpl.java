package com.itwill.ilhajob.corp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.User;

@Service
public class CorpServiceImpl implements CorpService{
	
	@Autowired
	private CorpDao corpDao;
	
	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int login(Corp corp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public User findUser(String corpId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int update(Corp corp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int remove(String corpId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isDuplicateId(String corpId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
