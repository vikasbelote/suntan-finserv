package com.suntan.finserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntan.finserv.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
