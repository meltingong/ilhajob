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
	
	public List<BlogComment> selectAll() throws Exception{
		return blogCommentMapper.selectAll();
	}
	public List<BlogComment> selectByBlogCommentUser(int userSeq) {
		return blogCommentMapper.selectByBlogCommentUser(userSeq);
	}
	public int insertBlogComment(BlogComment blogComment) {
		int insertRowCount = blogCommentMapper.insertBlogComment(blogComment);
		return insertRowCount;
	}
		
	public int updateBlogComment(BlogComment blogComment) {
		int updateRowCount = blogCommentMapper.updateBlogComment(blogComment);
		return updateRowCount;
	}
	
	public int removeBlogComment(BlogComment blogComment) {
		int deleteRowCount = blogCommentMapper.removeBlogComment(blogComment);
		return deleteRowCount;
	}
	
}