package com.tledu.zmj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.zmj.dao.INoteDao;
import com.tledu.zmj.model.Note;
import com.tledu.zmj.util.Pager;

@Repository("noteDao")
public class NoteDao extends SqlSessionDaoSupport implements INoteDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int find_count(String sreach) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(INoteDao.class).find_count(sreach);
	}

	@Override
	public Pager<Note> find(String sreach, int page, int limit) {
		Pager<Note> pager = new Pager<Note>();
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
		List<Note> notes = getSqlSession().selectList(
				"com.tledu.zmj.dao.INoteDao.find", map);
		pager.setData(notes);
		System.out.println(notes);
		return pager;
	}

	@Override
	public List<Note> list() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(INoteDao.class).list();
	}

	@Override
	public void add(Note note) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(INoteDao.class).add(note);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(INoteDao.class).delete(id);
	}

	@Override
	public void update(Note note) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(INoteDao.class).update(note);
	}

	@Override
	public void edit(Note note) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(INoteDao.class).edit(note);
	}

	@Override
	public Note load(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(INoteDao.class).load(id);
	}

}
