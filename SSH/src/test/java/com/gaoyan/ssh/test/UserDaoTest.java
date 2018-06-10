package com.gaoyan.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gaoyan.ssh.dao.impl.UserDao;
import com.gaoyan.ssh.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional
public class UserDaoTest {
   
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void query() {
		String hql="from User";
		List<User> users = userDao.findEntityByHQL(hql);
		for(User u:users) {
			System.out.println(u.getAddress()+";"+u.getName());
		}
	}
}
