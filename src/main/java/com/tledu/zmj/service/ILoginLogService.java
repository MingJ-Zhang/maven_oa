package com.tledu.zmj.service;

import com.tledu.zmj.model.LoginLog;
import com.tledu.zmj.model.User;
import com.tledu.zmj.util.OAException;
import com.tledu.zmj.util.Pager;

public interface ILoginLogService {

	public User login(User user)  throws OAException;
	
	public void add(LoginLog loginLog);
	
	public Pager<LoginLog> find(String sreach, int page, int limit);
}
