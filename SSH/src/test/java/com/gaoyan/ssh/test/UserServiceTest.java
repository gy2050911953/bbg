package com.gaoyan.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gaoyan.ssh.entity.User;
import com.gaoyan.ssh.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional
public class UserServiceTest {

	@Resource(name="userSerivce")
	private UserService userService;
	
	@Test
	public void query() {
		User user = userService.validateUserInfo("jj", "12356");
	    System.out.println("user->"+user);
	}
	
	@Test
	public void findById() {
		User user = userService.findById("1");
		System.out.println("------------");
		System.out.println(user.getAddress());
	}
	
	@Test
	public void findAll() {
		List<User> users = userService.findAll();
		for(User u:users) {
			System.out.println(u.getName());
		}
	}
	
	@Test
	public void delete() {
	 userService.deleteUser("2");		
	}	
}
