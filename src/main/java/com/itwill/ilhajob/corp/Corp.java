package com.itwill.ilhajob.corp;

import java.util.Date;

import com.itwill.ilhajob.blog.Blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Corp {
	String corp_id;
	String corp_password;
	String corp_name;
	String corp_phone;
	String corp_business_no;
	String corp_website;
	Date corp_est;
	String corp_size;
	String corp_sales;
	String corp_comment;
	String corp_welfare;
	String corp_address;
	String corp_status;
	int job_id;
	int role_id;
	
}
