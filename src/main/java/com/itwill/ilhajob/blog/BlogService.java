package com.itwill.ilhajob.blog;

import java.util.List;

public interface BlogService {


	int insertBlog(Blog blog);
	
	Blog findBlog(int blogSeq);
	
	List<Blog> selectAll();

	List<Blog> selectByBlogCate(int blogCateSeq);

	List<Blog> findByUserSeqBlogList(int userSeq);

	int updateBlog(Blog blog);

	int deleteBlog(int blogSeq);

	int updateBlogReadCount(int blogSeq);
	
	int updateBlogLikeCount(int blogSeq);

	List<Blog> findByBlogAndCommetAll(int blogSeq);


		
		

}
