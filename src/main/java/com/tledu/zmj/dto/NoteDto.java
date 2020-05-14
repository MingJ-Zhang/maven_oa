package com.tledu.zmj.dto;

import com.tledu.zmj.model.Note;

public class NoteDto {
	private int id;
	private String title;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Note getNote() {
		Note note = new Note();
		note.setId(id);
		note.setTitle(title);
		note.setContent(content);
		return note;
		
	}
}
