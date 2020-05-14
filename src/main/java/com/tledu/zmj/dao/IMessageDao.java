package com.tledu.zmj.dao;

import java.util.List;

import com.tledu.zmj.model.MessType;
import com.tledu.zmj.model.Message;
import com.tledu.zmj.util.Pager;

public interface IMessageDao {
	public Message load(int id);

	public int find_count(String sreach);

	public Pager<Message> find(String sreach, int page, int limit);

	public List<Message> list();

	public void add(Message message);

	public void delete(int id);

	/**
	 * 创建时间和创建者 不可以更改
	 * 
	 * @param Message
	 */
	public void update(Message message);

	/**
	 * 不更新关联对象列,时间相关的也不更改
	 * 
	 * @param user
	 */
	public void edit(Message message);

	/**
	 * 查询所有的消息类型,添加和更新 会用到
	 * 
	 * @return
	 */
	public List<MessType> listMessType();

	public int find_count2();
	public Pager<Message> find2( int page, int limit);
	
	public List<Message> ann();
	
}
