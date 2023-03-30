package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blogComment.mapper.BlogCommentMapper;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
	public BlogComment findBlogComment(int commentSeq) {
		return blogCommentMapper.findBlogComment(commentSeq);
	}
	
	public List<BlogComment> selectAll() {
		return blogCommentMapper.selectAll();
	}
	
	public List<BlogComment> selectByBlogComment(int blogSeq) {
		return blogCommentMapper.selectByBlogComment(blogSeq);
	}
	
	public int insertBlogComment(BlogComment blogComment) {
		return blogCommentMapper.insertBlogComment(blogComment);
	}
		
	public int updateBlogComment(BlogComment blogComment) {
		return blogCommentMapper.updateBlogComment(blogComment);
	}
	
	public int deleteBlogComment(int commentSeq) {
		return blogCommentMapper.deleteBlogComment(commentSeq);
	}
	
}