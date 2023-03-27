package com.itwill.ilhajob.blog;

import java.util.Date;

import com.itwill.ilhajob.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 
CREATE TABLE blog(
		blog_seq                      		NUMBER(20)		 NULL ,
		blog_title                    		VARCHAR2(30)		 NULL ,
		blog_content                  		VARCHAR2(200)		 NULL ,
		blog_image                    		VARCHAR2(45)		 NULL ,
		blog_date                     		DATE		 NULL ,
		blog_read_count               		NUMBER(10)		 NULL ,
		blog_like                     		NUMBER(10)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL,
		blog_cate_seq                 		NUMBER(20)		 NOT NULL
);
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Blog {
	private int blogSeq;
	private String blogTitle;
	private String blogContent;
	private String blogImage;
	private Date blogDate;
	private int blogReadCount;
	private int blogLike;
	private String userEmail;
	
	
}
