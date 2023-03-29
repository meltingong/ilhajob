package com.itwill.ilhajob.blogComment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.blogComment.BlogComment;

@Mapper
public interface BlogCommentMapper {
	
	public BlogComment findBlogComment(int commentSeq);

	List<BlogComment> selectAll();
	
	public List<BlogComment> selectByBlogCommentUser(int userSeq);
	
	public int insertBlogComment(BlogComment blogComment);	

	public int updateBlogComment(BlogComment blogComment);	
		
	public int removeBlogComment(BlogComment blogComment);
	
}
