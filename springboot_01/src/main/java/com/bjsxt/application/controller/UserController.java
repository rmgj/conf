package com.bjsxt.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Controller必须放入启动类所在子包中
 * @author Administrator
 *
 */
//@Controller
@RestController //组合注解，Controller纳入spring容器，完成异步响应
public class UserController {

	
	@RequestMapping("/loadUser")
	//@ResponseBody
	public String loadUser() {
		return "这是用户信息";
	}
}
