package com.tledu.zmj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zmj.dao.IMessageDao;
import com.tledu.zmj.model.MessType;
import com.tledu.zmj.model.Message;
import com.tledu.zmj.service.IMessageService;
import com.tledu.zmj.util.Pager;

@Service("messageService")
public class MessageService implements IMessageService{
	
	private IMessageDao messageDao;
	

	public IMessageDao getMessageDao() {
		return messageDao;
	}
	@Autowired
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Message load(int id) {
		// TODO Auto-generated method stub
		return messageDao.load(id);
	}

	@Override
	public Pager<Message> find(String sreach, int page, int limit) {
		// TODO Auto-generated method stub
		sreach = "%" + sreach + "%";
		return messageDao.find(sreach, page, limit);
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		return messageDao.list();
	}

	@Override
	public void add(Message message) {
		// TODO Auto-generated method stub
		messageDao.add(message);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		messageDao.delete(id);
	}

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		messageDao.update(message);
	}

	@Override
	public void edit(Message message) {
		// TODO Auto-generated method stub
		messageDao.edit(message);
	}

	@Override
	public List<MessType> listMessType() {
		// TODO Auto-generated method stub
		return messageDao.listMessType();
	}
	@Override
	public int find_count2() {
		// TODO Auto-generated method stub
		return messageDao.find_count2();
	}
	@Override
	public Pager<Message> find2( int page, int limit) {
		return messageDao.find2( page, limit);
	}
	@Override
	public List<Message> ann() {
		// TODO Auto-generated method stub
		return messageDao.ann();
	}

}
