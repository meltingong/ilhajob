package com.itwill.ilhajob.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.user.User;

@Mapper
public interface UserMapper {
	
	public int create(User user);

	public int update(User user);

	public int remove(String userId);

	public User findUser(String userId);

	public int existedUser(String userId);
	
}