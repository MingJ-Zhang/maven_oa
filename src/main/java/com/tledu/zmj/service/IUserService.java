package com.tledu.zmj.service;

import java.util.List;

import com.tledu.zmj.model.User;
import com.tledu.zmj.util.AjaxObj;
import com.tledu.zmj.util.OAException;
import com.tledu.zmj.util.Pager;

public interface IUserService {
	public Pager<User> find(String sreach, int page, int limit);

	public AjaxObj updateRole(int id, int role_id);

	public List<User> list();

	public User load(int id);

	public void add(User user);

	/**
	 * 用户还是部门负责人的时候 不能删除
	 * @param id
	 * @throws OAException
	 */
	public void delete(int id) throws  OAException;

	/**
	 * 不更新关联对象列
	 * 
	 * @param user
	 */
	public void edit(User user);

	/**
	 * 更改员工状态
	 * 
	 * @param user
	 */
	public AjaxObj updateStatus(int id , int status);
	
	public void update(User user);
}
