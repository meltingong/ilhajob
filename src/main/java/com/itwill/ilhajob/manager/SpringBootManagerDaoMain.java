package com.itwill.ilhajob.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@EntityScan(basePackages = "com.itwill.ilhajob.manager.mapper.managerMapper")
@SpringBootApplication
//@MapperScan(basePackages = "com.itwill.ilhajob.manager.mapper")
public class SpringBootManagerDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootManagerDaoMain.class, args);
		ManagerDao managerDao=(ManagerDao)appicationContext.getBean(ManagerDao.class);
		System.out.println("---------ManagerTest 시작------------------");
		System.out.println("--insert--");
		System.out.println();
		System.out.println("--update--");
		System.out.println("--delete--");
		System.out.println("--findManagerByEmail--");
		System.out.println("--existedManager--");
		System.out.println("--selectListByCorpId--");

	}

}
