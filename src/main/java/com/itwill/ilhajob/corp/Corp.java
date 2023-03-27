package com.itwill.ilhajob.corp;

import java.util.Date;

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
/*
	이름               널?       유형             
---------------- -------- -------------- 
CORP_ID          NOT NULL VARCHAR2(30)   
CORP_PASSWORD    NOT NULL VARCHAR2(45)   
CORP_NAME        NOT NULL VARCHAR2(50)   
CORP_PHONE                VARCHAR2(20)   
CORP_BUSINESS_NO          VARCHAR2(20)   
CORP_WEBSITE              VARCHAR2(50)   
CORP_EST                  DATE           
CORP_SIZE                 VARCHAR2(20)   
CORP_SALES                VARCHAR2(20)   
CORP_COMMENT              VARCHAR2(1000) 
CORP_WELFARE              VARCHAR2(50)   
CORP_ADDRESS              VARCHAR2(100)  
CORP_STATUS               CHAR(1)        
JOB_ID                    NUMBER(10)     
ROLE_ID                   NUMBER(20)   
*/
	private String corp_id;
	private String corp_password;
	private String corp_name;
	private String corp_phone;
	private String corp_business_no;
	private String corp_website;
	private Date corp_est;
	private String corp_size;
	private String corp_sales;
	private String corp_comment;
	private String corp_welfare;
	private String corp_address;
	private char corp_status;
	private int job_id;
	private int role_id;
	
}
