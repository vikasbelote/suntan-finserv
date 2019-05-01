package com.suntan.finserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntan.finserv.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
