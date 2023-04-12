package com.itwill.ilhajob.user.service;

import java.util.List;

import com.itwill.ilhajob.user.dto.MessageDto;

public class MessageServiceImpl implements MessageService{

	@Override
	public int createMessage(MessageDto message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMessage(MessageDto message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMessageBySeq(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMessageByUserSeq(Long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MessageDto findMessageDetail(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageDto> findMessageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageDto> fineMessageOfUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
