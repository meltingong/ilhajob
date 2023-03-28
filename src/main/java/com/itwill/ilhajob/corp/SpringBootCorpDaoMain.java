package com.itwill.ilhajob.corp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan(basePackages = "com.itiwll.ilhajob.corp.mapper")
public class SpringBootCorpDaoMain {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCorpDaoMain.class, args);
		CorpDao corpDao=(CorpDao)appicationContext.getBean(CorpDao.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(corpDao.selectAll());
		System.out.println("");

	}

}
