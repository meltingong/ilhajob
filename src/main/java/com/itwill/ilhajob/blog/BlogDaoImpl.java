package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blog.mapper.BlogMapper;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	private BlogMapper blogMapper;
	
	public Blog findBlog(int blogSeq) {
		return blogMapper.findBlog(blogSeq);
	}
	
	public List<Blog> selectAll() {
		return blogMapper.selectAll();
	}
	
	public List<Blog> selectByBlogCate(int blogCateSeq) {
		return blogMapper.selectByBlogCate(blogCateSeq);
	}
	
	public int insertBlog(Blog blog) {
		return blogMapper.insertBlog(blog);
	}
	
	public int updateBlog(Blog blog) {
		return blogMapper.updateBlog(blog);
	}
	
	public int deleteBlog(int blogSeq) {
		return blogMapper.deleteBlog(blogSeq);
	}

}