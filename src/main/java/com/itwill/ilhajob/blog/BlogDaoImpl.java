package com.itwill.ilhajob.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blog.mapper.BlogMapper;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	private BlogMapper blogMapper;
}
