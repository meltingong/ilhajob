package com.itwill.ilhajob.blogComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blogComment.mapper.BlogCommentMapper;
@Repository
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private BlogCommentMapper blogCommentMapper;
}
