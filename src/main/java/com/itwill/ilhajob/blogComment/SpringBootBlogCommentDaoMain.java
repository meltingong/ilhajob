package com.itwill.ilhajob.blogComment;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.blogComment.mapper")
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootBlogCommentDaoMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootBlogCommentDaoMain.class, args);
        //Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);		
	    BlogCommentDao blogCommentDao=(BlogCommentDao)appicationContext.getBean(BlogCommentDao.class);
	    //System.out.println("--------findBlogComment--------");
	    //System.out.println(blogCommentDao.findBlogComment(91));    
		//System.out.println("--------selectAll--------");
		//System.out.println(blogCommentDao.selectAll());
	    //System.out.println("--------selectByBlogComment--------");
	    //System.out.println(blogCommentDao.selectByBlogComment(56));
	    //System.out.println("--------insertBlogComment--------");
	    //System.out.println(blogCommentDao.insertBlogComment(new BlogComment(95, "블로그 댓글내용5", new Date(),"1",59)));
	    //System.out.println("--------updateBlogComment--------");
	    //System.out.println(blogCommentDao.updateBlogComment(new BlogComment(95, "블로그 댓글내용수정",new Date(),"1",59)));
	    //System.out.println("--------deleteBlogComment--------");
	    //System.out.println(blogCommentDao.deleteBlogComment(95));
	
	}

}