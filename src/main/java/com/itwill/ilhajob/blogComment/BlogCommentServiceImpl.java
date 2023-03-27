package com.itwill.ilhajob.blogComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogCommentServiceImpl implements BlogCommentService{
	
	@Autowired
	private BlogCommentDao blogCommentDao;
	
	public BlogCommentServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
}
