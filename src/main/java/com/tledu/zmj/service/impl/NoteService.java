package com.tledu.zmj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zmj.dao.INoteDao;
import com.tledu.zmj.model.Note;
import com.tledu.zmj.service.INoteService;
import com.tledu.zmj.util.Pager;

@Service("noteService")
public class NoteService implements INoteService {

	private INoteDao noteDao;
	
	public INoteDao getNoteDao() {
		return noteDao;
	}

	@Autowired
	public void setNoteDao(INoteDao noteDao) {
		this.noteDao = noteDao;
	}

	@Override
	public Note load(int id) {
		// TODO Auto-generated method stub
		return noteDao.load(id);
	}

	@Override
	public Pager<Note> find(String sreach, int page, int limit) {
		// TODO Auto-generated method stub
		sreach = "%" + sreach + "%";
		return noteDao.find(sreach, page, limit);
	}

	@Override
	public List<Note> list() {
		// TODO Auto-generated method stub
		return noteDao.list();
	}

	@Override
	public void add(Note note) {
		// TODO Auto-generated method stub
		noteDao.add(note);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		noteDao.delete(id);
	}

	@Override
	public void update(Note note) {
		// TODO Auto-generated method stub
		noteDao.update(note);
	}

	@Override
	public void edit(Note note) {
		// TODO Auto-generated method stub
		noteDao.edit(note);
	}

}
