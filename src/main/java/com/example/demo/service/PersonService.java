package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.dao.CrudUser;

@Service
public class PersonService {
	
	private final CrudUser personDao;
	
	@Autowired
	public PersonService(@Qualifier("fakedao") CrudUser personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(User person) {
		return personDao.insert(person);
	}
	
	public List<User> getAllPeople(){
		return this.personDao.findAll();
	}
	
	public Optional<User> getPersonById(int id) {
		return personDao.findById(id);
	}
	
	public int deletePerson(int id) {
		return personDao.delete(id);
	}
	
	public int updatePerson(int id, User person) {
		return personDao.update(id, person);
	}
	
}
