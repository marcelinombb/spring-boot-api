package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Repository("fakedao")
public class FakePersonDataAccessService implements CrudUser{
	
	private static List<User> DB = new ArrayList<>();
	
	@Override
	public int insert(User user) {
		DB.add(user);
		return 0;
	}

	@Override
	public List<User> findAll() {
		return DB;
	}

	@Override
	public Optional<User> findById(int id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	
	public Optional<User> selectUserById(int id){
		return DB.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst();
	}

	@Override
	public int delete(int id) {
		Optional<User> person = selectUserById(id);
		if(!person.isPresent()) {
			return 0;
		} 
		DB.remove(person.get());
		return 1;
	}

	@Override
	public int update(int id, User user) {
		return selectUserById(id)
				.map(p -> {
					int indexOfPersonToDelete = DB.indexOf(p); 
					if(indexOfPersonToDelete >= 0) {
						DB.set(indexOfPersonToDelete,user);
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}

}
