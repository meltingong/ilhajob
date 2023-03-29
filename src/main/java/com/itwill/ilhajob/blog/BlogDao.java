package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao {
	
	Blog findBlog(int blogSeq);
	
	List<Blog> selectAll();
	
	List<Blog> selectByBlogUser(int userSeq);
	
	int insertBlog(Blog blog);
	
	int updateBlog(Blog blog);
	
	int deleteBlog(int blogSeq);
	
}
