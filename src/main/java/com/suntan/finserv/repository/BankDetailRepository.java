package com.suntan.finserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntan.finserv.entity.BankDetails;

public interface BankDetailRepository extends JpaRepository<BankDetails, Long> {

}
