package com.suntan.finserv.mapper;

import org.springframework.stereotype.Component;

import com.suntan.finserv.dto.CreateUserDTO;
import com.suntan.finserv.entity.Person;
import com.suntan.finserv.entity.UserDetail;

@Component
public class UserMapper {
	
	public UserDetail createUserDtoToUserDeatil(CreateUserDTO createUserDTO) {
		
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(createUserDTO.getUserId());
		userDetail.setUserName(createUserDTO.getUserName());
		userDetail.setUserPassword(createUserDTO.getPassword());
		
		Person person = new Person();
		person.setFirstName(createUserDTO.getFirstName());
		person.setLastName(createUserDTO.getLastName());
		userDetail.setPerson(person);
		
		return userDetail;
	}
	
	public CreateUserDTO userDetailToCreateUserDto(UserDetail userDetail) {
		CreateUserDTO createUserDto = new CreateUserDTO();
		createUserDto.setUserId(userDetail.getUserId());
		createUserDto.setFirstName(userDetail.getPerson().getFirstName());
		createUserDto.setLastName(userDetail.getPerson().getLastName());
		createUserDto.setUserName(userDetail.getUserName());
		return createUserDto;
	}
}
