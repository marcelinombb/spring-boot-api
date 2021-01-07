package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.service.UserService;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.newUser(user);
	}
	
	@GetMapping
	public List<User> allUsers() {
		return userService.selectAll();
	}
	
	@GetMapping(path = "{id}")
	public Optional<User> getOne(@PathVariable("id") int id) {
		return userService.getOne(id);
	}
	
	@DeleteMapping(path = "{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return userService.delete(id);
	}	
	
	@PutMapping(path = "{id}")
	public int updateUser(@PathVariable("id") int id,@RequestBody User user) {
		return userService.update(id, user);
	}
}
