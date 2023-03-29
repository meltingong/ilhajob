package com.itwill.ilhajob.corpimage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.ilhajob.corp.Corp;


@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.corpimage.mapper")
public class SpringBootCorpImageDaoMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCorpImageDaoMain.class, args);
		CorpImageDao corpImageDao=(CorpImageDao)appicationContext.getBean(CorpImageDao.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(corpImageDao.selectAll());
		System.out.println("---------insert test------------------");
	//	System.out.println(corpImageDao.insertCorpImage(CorpImage.builder().corpId(null)));
		;
	}

}
