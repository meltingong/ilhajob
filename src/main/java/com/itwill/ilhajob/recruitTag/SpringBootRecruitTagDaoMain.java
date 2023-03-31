package com.itwill.ilhajob.recruitTag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.recruitTag.mapper")
public class SpringBootRecruitTagDaoMain{
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootRecruitTagDaoMain.class, args);
		
		RecruitTag recruitTag=(RecruitTag)appicationContext.getBean(RecruitTag.class);
		
		System.out.println("---------insert------------------");
		
		System.out.println("---------selectCorpByTag------------------");
		
		System.out.println("---------existedCorpTag------------------");
	
		System.out.println("---------deleteCorpTag------------------");
	
	}

}
