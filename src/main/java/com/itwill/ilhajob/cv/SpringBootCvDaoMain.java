package com.itwill.ilhajob.cv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwiwll.ilhajob.Awards.mapper")
public class SpringBootCvDaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootCvDaoMain.class, args);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println();
		System.out.println();

	}

}
