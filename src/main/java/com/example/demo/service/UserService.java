package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.dao.CrudUser;

@Service
public class UserService {
	
	private final CrudUser crudUser;

	@Autowired
	public UserService(@Qualifier("mysql") CrudUser userDao) {
		this.crudUser = userDao;
	}
	
	public void newUser(User user) {
		crudUser.insert(user);
	}
	
	public List<User> selectAll(){ 
		return crudUser.findAll();
	}
	
	public Optional<User> getOne(int id) {
		return crudUser.findById(id);
	}
	
	public int delete(int id) {
		return crudUser.delete(id);
	}
	
	public int update(int id,User user) {
		return crudUser.update(id, user);
	}

}
