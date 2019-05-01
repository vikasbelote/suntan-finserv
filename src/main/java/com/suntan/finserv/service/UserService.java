package com.suntan.finserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntan.finserv.dto.CreateUserDTO;
import com.suntan.finserv.entity.UserDetail;
import com.suntan.finserv.mapper.UserMapper;
import com.suntan.finserv.repository.UserDetailRepository;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	public CreateUserDTO saveUser(CreateUserDTO createUserDTO) {
		UserDetail user = userMapper.createUserDtoToUserDeatil(createUserDTO);
		user = userDetailRepository.save(user);
		return userMapper.userDetailToCreateUserDto(user);
	}
	
	public CreateUserDTO getUserByNameAndPassword(CreateUserDTO createUserDTO) {
		UserDetail userDetail = userDetailRepository.findByUserNameAndUserPassword(createUserDTO.getUserName(), 
				createUserDTO.getPassword());
		return userMapper.userDetailToCreateUserDto(userDetail);
	}
	
	public UserDetail getUserDetail(Long userId) {
		return userDetailRepository.findByUserId(userId);
	}

}
