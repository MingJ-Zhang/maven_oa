package com.tledu.zmj.dao;

import com.tledu.zmj.model.LoginLog;
import com.tledu.zmj.model.User;
import com.tledu.zmj.util.Pager;

public interface ILoginLogDao {
	public User login(String name);
	
	public void add(LoginLog loginLog);
	
	public int find_count(String sreach);

	public Pager<LoginLog> find(String sreach, int page, int limit);
}
