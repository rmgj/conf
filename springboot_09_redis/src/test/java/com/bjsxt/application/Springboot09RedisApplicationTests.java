package com.bjsxt.application;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.keyvalue.core.query.KeyValueQuery;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjsxt.application.pojo.User;
import com.jayway.jsonpath.Criteria;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09RedisApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private RedisKeyValueTemplate keyValue;
	/***
	 * 保存用户数据
	 * 保存的对象对应的实体类中必须有id属性。
	 */
	@Test
	public void addUser() {
		User user=new User();
		user.setId(12779);
		user.setUname("小强");
		user.setAddress("北京");
		user.setAge(19);
		keyValue.insert(user);
		//keyValue.insert(id, objectToInsert)
	}
	
	/****
	 * 查询用户信息
	 */
	@Test
	public void loadUser() {
		//查询指定类型的数据   
		/*Iterable<User> it = keyValue.findAll(User.class);
		Iterator<User> iterator = it.iterator();
		*/
		//创建Sort对象
		Sort sort = new Sort(Sort.Direction.DESC, "age");
		/*Iterable<User> it = keyValue.findAll(sort, User.class);*/
		
		//进行分页查询
		/*Iterable<User> it = keyValue.findInRange(0, 2, User.class);
		Iterator<User> iterator = it.iterator();
		*/
		
		KeyValueQuery<Criteria> query=new KeyValueQuery<Criteria>();
		query.setSort(sort);
		Criteria criteria = query.getCriteria();
		criteria.where("id").eq(12779);
		
		Iterable<User> it = keyValue.find(query, User.class);
		
		/*List<User> it = keyValue.find(new RedisCallback(){

			@Override
			public Object doInRedis(RedisConnection 
					connection) throws DataAccessException {
				//原始的jedis提供的对象
				String skey="com.bjsxt.application.pojo.User";
				Set<byte[]> sMembers = connection.sMembers(skey.getBytes());
				for(byte[] bs:sMembers) {
					System.out.println(new String(bs));
				}
				return sMembers;
			}
			
			
		}, User.class);*/
		Iterator<User> iterator = it.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user.getId()+"\t"+user.getUname());
		}
	}
	
	/***
	 * 更新用户信息
	 */
	@Test
	public void updateUser() {
		User user=new User();
		user.setId(12779);
		user.setUname("旺财");
		user.setAddress("上海");
		user.setAge(22);
		keyValue.update(user);
	}
	
	/****
	 * 删除用户信息
	 */
	@Test
	public void deleteUser() {
		keyValue.delete(12779, User.class);
	}
	

}
