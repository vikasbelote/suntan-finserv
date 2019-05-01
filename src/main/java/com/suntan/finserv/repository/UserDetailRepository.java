package com.suntan.finserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suntan.finserv.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
	
	UserDetail findByUserNameAndUserPassword(String userName, String userPassword);
	UserDetail findByUserId(Long userId);

}
