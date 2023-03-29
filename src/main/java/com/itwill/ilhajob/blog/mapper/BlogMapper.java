package com.itwill.ilhajob.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.blog.Blog;
import com.itwill.ilhajob.blogComment.BlogComment;

@Mapper
public interface BlogMapper {
	
	public Blog findBlog(int blogSeq);
	
	public List<Blog> selectAll();
	
	public List<Blog> selectByBlogUser(int userSeq);

	public int insertBlog(Blog blog);
	
	public int updateBlog(Blog blog);

	public int deleteBlog(int blogSeq);

}
