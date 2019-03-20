package com.bjsxt.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration  //Configs在springboot启动的时候加载
public class Configs {

	//获得springboot框架实例化的链接工程
	@Autowired
	private RedisConnectionFactory connectionFactory;	 
	/***
	 * @Bean注解实例化一个类的对象，在spring容器的id是方法名
	 *  <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
	 	</bean>
	 * @return
	 */
	@Primary  //@Primary 指定在spring容器中那个对象优先注入
	@Bean
	public RedisTemplate<String, String> redisTemplate(){
		 System.out.println("==========实例化RedisTemplate");
		 RedisTemplate<String, String> redisTemplate=new RedisTemplate<String, String>();
		 //覆盖默认的key序列化方式
		 redisTemplate.setKeySerializer(new GenericToStringSerializer<String>(String.class));
		 //覆盖默认的value序列化方式
		 redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<String>(String.class));
		 //redis.clients.jedis.JedisPoolConfig
		 
		 //注入redis集群链接
		 redisTemplate.setConnectionFactory(connectionFactory);
		 
		 return redisTemplate;
	}
}
