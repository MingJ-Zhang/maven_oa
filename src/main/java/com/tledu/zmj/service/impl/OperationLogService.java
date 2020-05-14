package com.tledu.zmj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zmj.dao.IOperationLogDao;
import com.tledu.zmj.model.OperationLog;
import com.tledu.zmj.service.IOperationLogService;
import com.tledu.zmj.util.Pager;

@Service("operationLogService")
public class OperationLogService implements IOperationLogService {
	private IOperationLogDao operationLogDao;

	public IOperationLogDao getOperationLogDao() {
		return operationLogDao;
	}

	@Autowired
	public void setOperationLogDao(IOperationLogDao operationLogDao) {
		this.operationLogDao = operationLogDao;
	}

	@Override
	public void add(OperationLog operationLog) {
		operationLogDao.add(operationLog);
	}

	@Override
	public Pager<OperationLog> find(String sreach, int page, int limit) {
		sreach = "%" + sreach + "%";
		return operationLogDao.find(sreach, page, limit);
	}

}
