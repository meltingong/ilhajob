package com.itwill.ilhajob.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.recruit.Recruit;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.app.mapper")
public class SpringBootAppDaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootAppDaoMain.class, args);
		AppDao appDao=(AppDao)applicationContext.getBean(AppDao.class);
		System.out.println("-----test----");
		Recruit rc = new Recruit();
		rc.setRcSeq(3);
		Cv cv = new Cv();
		cv.setCvSeq(1);
		
		App app = new App(0, 'u', rc, cv, 3, "corp_03");
		//appDao.insertApp(app);
		//appDao.deleteApp(17);
		//System.out.println(appDao.findAppByCorpId("corp_03"));
		//System.out.println(appDao.findAppByUserSeq(2));
	}

}