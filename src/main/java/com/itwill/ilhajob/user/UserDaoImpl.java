package com.itwill.ilhajob.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.user.mapper.UserMapper;

@Repository(value = "userDaoImplMyBatisMapperInterface")
public class UserDaoImpl implements UserDao {
	
	@Autowired(required = false)
	private UserMapper userMapper;

	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



}