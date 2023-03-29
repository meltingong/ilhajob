package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blogComment.mapper.BlogCommentMapper;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
	public int insertBlogComment(BlogComment blogComment) {
		int insertRowCount = blogCommentMapper.insertBlogComment(blogComment);
		return insertRowCount;
	}
	
	public BlogComment selectByBlogComment(int commentSeq) {
		return blogCommentMapper.selectByBlogComment(commentSeq);
	}
	
	public List<BlogComment> selectAll() throws Exception{
		return blogCommentMapper.selectAll();
	}
	
	public List<BlogComment> selectByBlogSeq(int blogSeq) throws Exception{
		return blogCommentMapper.selectByBlogSeq(blogSeq);
	}
	
	public int updateBlogComment(BlogComment blogComment) {
		int updateRowCount = blogCommentMapper.updateBlogComment(blogComment);
		return updateRowCount;
	}
	
	public int deleteBlogComment(int commentSeq) {
		int deleteRowCount = blogCommentMapper.deleteBlogComment(commentSeq);
		return deleteRowCount;
	}
}