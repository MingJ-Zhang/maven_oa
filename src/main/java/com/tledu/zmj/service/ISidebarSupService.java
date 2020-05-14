package com.tledu.zmj.service;

import java.util.List;

import com.tledu.zmj.model.SidebarSup;
import com.tledu.zmj.model.User;

public interface ISidebarSupService {
	public List<SidebarSup> list(User user);
}
