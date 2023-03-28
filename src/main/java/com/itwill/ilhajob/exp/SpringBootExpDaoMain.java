package com.itwill.ilhajob.exp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootExpDaoMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootExpDaoMain.class, args);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println();
		System.out.println();

	}

}
