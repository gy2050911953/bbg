package com.gaoyan.ssh.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gaoyan.ssh.dao.BaseDao;
import com.gaoyan.ssh.service.BaseService;

@Transactional(readOnly=true)
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private Class<T> clazz;	
	
	public BaseServiceImpl() {
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();//得到了泛型的父类BaseDaoImpl<T>
	    this.clazz=(Class<T>) type.getActualTypeArguments()[0];//得到User对象
	}

	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Transactional(readOnly=false)
	public void saveEntity(T t) {
		this.baseDao.saveEntity(t);
	}
	
	@Transactional(readOnly=false)
	public void deleteEntity(T t) {
		this.baseDao.deleteEntity(t);
	}

	@Transactional(readOnly=false)
	public void updateEntity(T t) {
		this.baseDao.updateEntity(t);
	}

	public T getEntity(Serializable id) {
		return this.baseDao.getEntity(id);
	}

	public T loadEntity(Serializable id) {
		return this.baseDao.loadEntity(id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		return this.baseDao.findEntityByHQL(hql, objects);
	}

	@Transactional(readOnly=false)
	public void executeUpdateByHQL(String hql, Object... objects) {
		 this.baseDao.executeUpdateByHQL(hql, objects);
	}

	public List<T> findAll() {
		String hql = "from  "+this.clazz.getSimpleName();
		return this.baseDao.findEntityByHQL(hql);
	}

}
