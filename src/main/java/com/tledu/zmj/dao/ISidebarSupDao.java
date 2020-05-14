package com.tledu.zmj.dao;

import java.util.List;

import com.tledu.zmj.model.SidebarSup;

public interface ISidebarSupDao {
	public List<SidebarSup> list(int isAdmin);
}
