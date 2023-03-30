package com.itwill.ilhajob.cv;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.ilhajob.edu.Edu;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.cv.mapper")
public class SpringBootCvDaoMain_하은 {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCvDaoMain_하은.class, args);
		CvDao_하은 cvDao=(CvDao_하은)appicationContext.getBean(CvDao_하은.class);
		//System.out.println(">> cvSeq로 이력서 찾기");
		//System.out.println(cvDao.findCv(2));
		//System.out.println(">>userSeq로 이력서 리스트얻기");
		//System.out.println(cvDao.findCvListByUserSeq(2));
		//System.out.println(">>userSeq , cvSeq로 이력서 얻기");
		//System.out.println(cvDao.detailCv(2, 2));
		//System.out.println(">> cv seq 로 이력서 찾기");
		//System.out.println(cvDao.selectByCv(2));
		
		 System.out.println(">> createCv"); 
		 
		//System.out.println(">> cv update");
		
	}

}
