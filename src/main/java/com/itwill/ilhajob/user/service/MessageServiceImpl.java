package com.itwill.ilhajob.user.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.user.dto.MessageDto;
import com.itwill.ilhajob.user.entity.Message;
import com.itwill.ilhajob.user.repository.MessageRepository;


@Service
@Transactional
public class MessageServiceImpl implements MessageService{
	
	private final MessageRepository messageRepository;
	private final ModelMapper modelMapper;
	
	public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
		this.messageRepository = messageRepository;
		this.modelMapper = modelMapper;
	}
	
	/*
	@Override
	public int createMessage(MessageDto messageDto) {
		Message message = modelMapper.map(messageDto, Message.class);
		message = messageRepository.save(message);
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
	*/
}
