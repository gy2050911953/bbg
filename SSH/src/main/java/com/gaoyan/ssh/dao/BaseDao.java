package com.gaoyan.ssh.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	void saveEntity(T t);
	
	void deleteEntity(T t);
	
	void updateEntity(T t);
	//根据Id查询 int或String类型
	T getEntity(Serializable id);
	
	T loadEntity(Serializable id);
	//三个点为可变参数
	List<T> findEntityByHQL(String hql,Object...objects);
	
	void executeUpdateByHQL(String hql,Object...objects);
}
