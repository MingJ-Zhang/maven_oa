package com.tledu.zmj.dao;

import com.tledu.zmj.model.OperationLog;
import com.tledu.zmj.util.Pager;

public interface IOperationLogDao {
	public void add(OperationLog operationLog);
	
	public int find_count(String sreach);

	public Pager<OperationLog> find(String sreach, int page, int limit);
	
}
