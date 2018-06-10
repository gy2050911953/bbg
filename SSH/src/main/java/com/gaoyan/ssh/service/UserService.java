package com.gaoyan.ssh.service;



import java.util.List;

import com.gaoyan.ssh.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * 验证用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User validateUserInfo(String username,String password);
	
	/**
	 * 通过id查找用户信息
	 */
	User findById(String id);
	
	/**
	 * 查询所有用户信息
	 */
	List<User> findAllUser();
	
	/**
	 * 删除用户
	 */
	public void deleteUser(String id);
	
	/**
	 * 修改用户信息
	 */
	public void updateUser(User user);
}
