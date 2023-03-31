package com.itwill.ilhajob.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.message.mapper.MessageMapper;

@Repository
public class MessageDaoImpl implements MessageDao{
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public Message findMessage(int messageSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createMessage(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMessage(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMessageBySeq(int messageSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMessageByUserSeq(int userSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Message> findMessageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findMessageOfUser(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}

}
