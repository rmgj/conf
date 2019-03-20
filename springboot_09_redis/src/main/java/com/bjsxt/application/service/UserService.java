package com.bjsxt.application.service;

import java.util.List;

import com.bjsxt.application.pojo.User;

public interface UserService {

	/***
	 * 加载用户列表
	 * @return
	 */
	public List<User> loadUserListService();
}
