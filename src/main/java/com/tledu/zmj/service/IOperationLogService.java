package com.tledu.zmj.service;

import com.tledu.zmj.model.OperationLog;
import com.tledu.zmj.util.Pager;

public interface IOperationLogService {

	public void add(OperationLog operationLog);

	public Pager<OperationLog> find(String sreach, int page, int limit);

}
