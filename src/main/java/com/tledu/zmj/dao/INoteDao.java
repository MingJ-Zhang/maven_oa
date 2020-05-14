package com.tledu.zmj.dao;

import java.util.List;

import com.tledu.zmj.model.Note;
import com.tledu.zmj.util.Pager;

public interface INoteDao {

	public Note load(int id);
	
	public int find_count(String sreach);

	public Pager<Note> find(String sreach, int page, int limit);

	public List<Note> list();

	public void add(Note note);

	public void delete(int id);

	/**
	 * 创建时间和创建者 不可以更改
	 * 
	 * @param mySchedule
	 */
	public void update(Note note);

	/**
	 * 不更新关联对象列,时间相关的也不更改
	 * 
	 * @param user
	 */
	public void edit(Note note);
}
