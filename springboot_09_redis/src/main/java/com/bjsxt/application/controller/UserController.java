package com.bjsxt.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjsxt.application.pojo.User;
import com.bjsxt.application.service.UserService;

/**
 * @author Administrator
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/***
	 * 处理加载用户列表的请求
	 */
	@GetMapping("/users")
	public List<User> loadUserList(){
		return userService.loadUserListService();
	}
	
}
