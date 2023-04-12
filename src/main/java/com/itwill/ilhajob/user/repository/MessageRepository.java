package com.itwill.ilhajob.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.dto.MessageDto;
import com.itwill.ilhajob.user.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	/*
	 * 유저 알림 list 
	 */
	
}
