package com.itwill.ilhajob.blog;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.blog.mapper")
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootBlogDaoMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootBlogDaoMain.class, args);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		BlogDao blogDao=(BlogDao)appicationContext.getBean(BlogDao.class);
		System.out.println("--------findBlog--------");
		System.out.println(blogDao.findBlog(5));
		
		System.out.println("--------selectAll--------");
		System.out.println(blogDao.selectAll());
		
		System.out.println("--------selectByBlogCate--------");
		System.out.println(blogDao.selectByBlogCate(1));
		

		System.out.println("--------insertBlog test--------");
		System.out.println(blogDao.insertBlog(Blog.builder()
													.blogCateSeq(4)
													.blogContent("내용1")
													.blogSeq(0)
													.blogReadCount(4)
													.blogDate(new Date())
													.blogLike(4)
													.blogImage("이미지1")
													.blogTitle("test1")
													.userSeq(1)
													.build()));
		
		System.out.println("--------updateBlog test--------");
		System.out.println(blogDao.insertBlog(Blog.builder()
												.blogCateSeq(4)
												.blogContent("내용1수정")
												.blogSeq(0)
												.blogReadCount(5)
												.blogDate(new Date())
												.blogLike(4)
												.blogImage("이미지1수정")
												.blogTitle("test1수정")
												.userSeq(1)
												.build()));
		
		//System.out.println("--------deleteBlog test--------");
		//System.out.println(blogDao.deleteBlog(61));
		
	}
}