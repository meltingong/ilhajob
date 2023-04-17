package com.itwill.ilhajob.common.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TagServiceImplTest {

	@Autowired
	TagService tagService;
	@Autowired
	CorpTagService corpTagService;
	
	@Test
	@Disabled
	void test1() {
		System.out.println(tagService.selectAll());
		
	}
	@Test
	@Transactional
	void test2() {
		System.out.println(corpTagService.selectAll());
		
	}

}
