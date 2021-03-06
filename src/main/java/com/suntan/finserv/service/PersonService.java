package com.suntan.finserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntan.finserv.entity.Person;
import com.suntan.finserv.entity.UserDetail;
import com.suntan.finserv.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonByPersonId(Long personId) {
		return personRepository.findByPersonId(personId);
	}
	
	public Person getPersonByUserDeatil(UserDetail userDetail) {
		return personRepository.findByUserDetail(userDetail);
	}
}
