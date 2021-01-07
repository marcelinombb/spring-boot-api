package com.example.demo.api;

import java.util.List;

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
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public int addPerson(@RequestBody User person) {
		return personService.addPerson(person);
	}
	
	@GetMapping
	public List<User> getAllPeople() {
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public User getPersonById(@PathVariable("id") int id){
		return personService.getPersonById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePerson(@PathVariable("id") int id,@RequestBody User person) {
		personService.updatePerson(id, person);
	}	
}
