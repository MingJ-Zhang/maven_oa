package com.tledu.zmj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.zmj.dao.IMessageDao;
import com.tledu.zmj.model.MessType;
import com.tledu.zmj.model.Message;
import com.tledu.zmj.util.Pager;

@Repository("messageDao")
public class MessageDao extends SqlSessionDaoSupport implements IMessageDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public Message load(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).load(id);
	}

	@Override
	public int find_count(String sreach) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).find_count(sreach);
	}

	@Override
	public Pager<Message> find(String sreach, int page, int limit) {
		Pager<Message> pager = new Pager<Message>();
		// 查询总条数
		int count = find_count(sreach);
		pager.setCount(count);

		// 准备参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 起始值
		// limit 起始值 , 条数 , 并且 起始值 0开始
		// 起始值是 页数 -1 乘 每页的条数
		map.put("pageOffset", (page - 1) * limit);
		map.put("limit", limit);
		map.put("sreach", sreach);
		// 查询
		List<Message> messages = getSqlSession().selectList(
				"com.tledu.zmj.dao.IMessageDao.find", map);
		pager.setData(messages);
		return pager;
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).list();
	}

	@Override
	public void add(Message message) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IMessageDao.class).add(message);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IMessageDao.class).delete(id);
	}

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IMessageDao.class).update(message);
	}

	@Override
	public void edit(Message message) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IMessageDao.class).edit(message);
	}

	@Override
	public List<MessType> listMessType() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).listMessType();
	}

	@Override
	public int find_count2() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).find_count2();
	}

	@Override
	public Pager<Message> find2(int page, int limit) {
		Pager<Message> pager = new Pager<Message>();
		// 查询总条数
		int count = find_count2();
		pager.setCount(count);

		// 准备参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 起始值
		// limit 起始值 , 条数 , 并且 起始值 0开始
		// 起始值是 页数 -1 乘 每页的条数
		map.put("pageOffset", (page - 1) * limit);
		map.put("limit", limit);
		// 查询
		List<Message> messages = getSqlSession().selectList(
				"com.tledu.zmj.dao.IMessageDao.find2", map);
		System.out.println(messages);
		pager.setData(messages);
		return pager;
	}

	@Override
	public List<Message> ann() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IMessageDao.class).ann();
	}

}
