package com.tledu.zmj.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.zmj.dao.IRoleDao;
import com.tledu.zmj.model.Role;

@Repository("roleDao")
public class RoleDao extends SqlSessionDaoSupport implements IRoleDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<Role> list() {
		return getSqlSession().getMapper(IRoleDao.class).list();
	}

}
