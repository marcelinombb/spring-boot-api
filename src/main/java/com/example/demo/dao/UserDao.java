package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.accessingdatamysql.UserRepository;

@Repository("mysql")
public class UserDao implements CrudUser{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int insert(User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		userRepository.save(newUser);
		return 1;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public int delete(int id) {
		userRepository.deleteById(id);
		return 1;
	}

	@Override
	public int update(int id, User user) {
		User userUpdate = this.findById(id).get();
		userUpdate.setEmail(user.getEmail());
		userUpdate.setName(user.getName());
		userRepository.save(userUpdate);
		return 1;
	}
}
