package com.itwill.ilhajob.corp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.itwill.ilhajob.corp.mapper","com.itwill.ilhajob.product.mapper"})
public class SpringBootCorpDaoMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCorpDaoMain.class, args);
		CorpDao corpDao=(CorpDao)appicationContext.getBean(CorpDao.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(corpDao.selectAll());
		System.out.println("---------selectById------------------");
		System.out.println(corpDao.selectById("corp_01"));
		System.out.println("---------findCorpByIdWithCorpImage------------------");
		System.out.println(corpDao.findCorpByIdWithAll("corp_01"));
		System.out.println("---------findCorpByIdWithCorpImage------------------");
		System.out.println(corpDao.findCorpByIdWithOrders("corp_01"));
		System.out.println("---------findCorpByIdWithRecruit------------------");
		System.out.println(corpDao.findCorpByIdWithRecruit("corp_01"));
		
		System.out.println("------------insert test---------------");
//		System.out.println(corpDao.insertCorp(
//				Corp.builder()
//				.corpId("testDao@test.com")
//				.corpPassword("tttt")
//				.corpName("testDao")
//				.build())
//		);
		System.out.println("-------------existedCorp--------------");
		System.out.println(corpDao.existedCorp("corp_01"));
		
	}

}
