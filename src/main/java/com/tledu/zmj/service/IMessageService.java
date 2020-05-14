package com.tledu.zmj.service;

import java.util.List;

import com.tledu.zmj.dto.MessageDto;
import com.tledu.zmj.model.MessType;
import com.tledu.zmj.model.Message;
import com.tledu.zmj.util.Pager;

public interface IMessageService {
	public Message load(int id);

	public Pager<Message> find(String sreach, int page, int limit);

	public List<Message> list();

	public void add(Message message);

	public void delete(int id);

	/**
	 * 创建时间和创建者 不可以更改
	 * 
	 * @param mySchedule
	 */
	public void update(Message message);

	/**
	 * 不更新关联对象列,时间相关的也不更改
	 * 
	 * @param user
	 */
	public void edit(Message message);

	/**
	 * 查询所有的公告类型,添加和更新 会用到
	 * 
	 * @return
	 */
	public List<MessType> listMessType();
	public int find_count2();
	public Pager<Message> find2( int page, int limit);
	
	public List<Message> ann();
}
