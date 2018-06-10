package com.gaoyan.ssh.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaoyan.ssh.dao.BaseDao;
import com.gaoyan.ssh.entity.User;
import com.gaoyan.ssh.service.UserService;

@Service("userSerivce")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource(name="userDao")
	@Override
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	public User validateUserInfo(String username, String password) {
		String hql="from User where name=? and password=?";
		List<User> users = this.findEntityByHQL(hql, username,password);		
		return users!=null&&users.size()>0?users.get(0):null;
	}

	
	public User findById(String id) {
		User user = this.getEntity(id);
		return user;
	}

	public List<User> findAllUser() {
		List<User> users = this.findAll();
		return users!=null&&users.size()>0?users:null;
	}

	public void deleteUser(String id) {
		String hql ="delete from User where id=?";
		this.executeUpdateByHQL(hql, id);
	}

	public void updateUser(User user) {
		
	}
}
