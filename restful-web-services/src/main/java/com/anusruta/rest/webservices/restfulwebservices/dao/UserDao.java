package com.anusruta.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anusruta.rest.webservices.restfulwebservices.beans.User;


@Component
public class UserDao {
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Rio", new Date()));
		users.add(new User(3, "Shai", new Date()));
	}
	
	private static int userCount = users.size();
	
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(Integer id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
