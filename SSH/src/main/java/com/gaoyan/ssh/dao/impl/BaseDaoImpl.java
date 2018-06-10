package com.gaoyan.ssh.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.gaoyan.ssh.dao.BaseDao;
//抽象类不能直接被实例化，抽象类的目的就是为实现多态中的共同点,抽象类的构造器会在子类实例化时调用,因此它也是用来实现多态中的共同点构造
@SuppressWarnings("all")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	//hibernate操作数据库通过sessionFactory 注入sessionFactory
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();//得到了泛型的父类BaseDaoImpl<T>
	    this.clazz=(Class<T>) type.getActualTypeArguments()[0];//得到User对象
	}

	public void saveEntity(T t) {
		//当前线程所得到的session对象
		sessionFactory.getCurrentSession().save(t);		
	}

	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public T getEntity(Serializable id) {
		//clazz封装的实体类对象
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public T loadEntity(Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		 Query query =sessionFactory.getCurrentSession().createQuery(hql);
		 for(int i=0;i<objects.length;i++) {
			 query.setParameter(i, objects[i]);
		 }
		 return query.list();
	}

	public void executeUpdateByHQL(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++) {
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}
}
