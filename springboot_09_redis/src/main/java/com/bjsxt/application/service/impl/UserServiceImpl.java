package com.bjsxt.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bjsxt.application.pojo.User;
import com.bjsxt.application.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	/***
	 * 缓存方法的返回值
	 */
	//org.springframework.cache.CacheManager
	@Cacheable(cacheNames= {"users"},key="#root.method.name")
	@Override
	public List<User> loadUserListService() {
		// TODO Auto-generated method stub
		System.out.println("------------loadUserListService");
		
		List<User> list=new ArrayList<User>();
		
		User user=new User();
		user.setId(100);
		user.setUname("李四");
		user.setAddress("beijing");
		
		User user1=new User();
		user1.setId(101);
		user1.setUname("zhangsan");
		user1.setAddress("shanghai");
		
		User user2=new User();
		user2.setId(102);
		user2.setUname("李四");
		user2.setAddress("tianjing");
		
		
		list.add(user);
		list.add(user1);
		list.add(user2);
		
		
		return list;
	}

}
