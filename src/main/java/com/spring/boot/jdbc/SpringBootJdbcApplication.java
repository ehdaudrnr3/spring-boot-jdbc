package com.spring.boot.jdbc;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.boot.jdbc.dao.UserDao;
import com.spring.boot.jdbc.model.User;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	
	@Bean
	InitializingBean commandLineRunner(UserDao userDao) {
		return ()-> {
			User user = new User("meuk", "111", 29);
			userDao.insert(user);
			
			List<User> list = userDao.findAll();
			list.forEach(t->{ 
				System.out.println("Insert User : "+t.getUsername());
			});
			
			list = userDao.findByName("meuk");
			list.forEach(t->{ 
				System.out.println("Find User : "+t.getUsername());
			});
			
			user.setPasswrod("222");
			user.setAge(30);
			userDao.update(user);
			
			list = userDao.findByName("meuk");
			list.forEach(t->{ 
				System.out.println("Update User : "+t.getUsername()+", update Age : "+t.getAge());
			});
			
		};
	}

}
