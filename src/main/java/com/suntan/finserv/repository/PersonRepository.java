package com.suntan.finserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntan.finserv.entity.Person;
import com.suntan.finserv.entity.UserDetail;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByPersonId(Long personId);
	Person findByUserDetail(UserDetail userDetail);
}
