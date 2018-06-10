package com.gaoyan.ssh.action;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

import org.springframework.ui.Model;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T model;//注入的数据
	
	@SuppressWarnings("unchecked")
	public BaseAction() {	
		try {
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();//得到了泛型的父类BaseDaoImpl<T>
	    Class<T> clazz=(Class<T>) type.getActualTypeArguments()[0];//得到User对象    
			this.model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public T getModel() { 
		return model;
	}



}
