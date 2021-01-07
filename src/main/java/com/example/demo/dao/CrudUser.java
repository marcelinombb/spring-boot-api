package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.accessingdatamysql.User;

public interface CrudUser {

	int insert(User user);
	List<User> findAll();
	Optional<User> findById(int id);
	int delete(int id);
	int update(int id,User user);
	
}
