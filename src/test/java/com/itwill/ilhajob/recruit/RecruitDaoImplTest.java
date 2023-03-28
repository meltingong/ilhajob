package com.itwill.ilhajob.recruit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

@SpringBootTest
class RecruitDaoImplTest {

	@Autowired
	private RecruitMapper recruitMapper;
	
	@Disabled
	@Test
	void testInsertRecruit() {
		Corp corp = new Corp();
		Recruit recruit = new Recruit(0, "테스트", "테스트", "테스트", "테스트", 0, new Date(), new Date(), 0, "DBtest6",corp);
		
		recruitMapper.insertRecruit(recruit);
	}

	//@Disabled
	@Test
	void testFindByCorpId() {
		System.out.println(recruitMapper.findByCorpId("DBtest6"));
		
	}

	@Disabled
	@Test
	void testFindByJob() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testFindBySeq() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testUpdateBySeq() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testDeleteBySeq() {
		fail("Not yet implemented");
	}

}
