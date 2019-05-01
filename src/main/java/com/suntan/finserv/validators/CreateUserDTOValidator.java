package com.suntan.finserv.validators;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.suntan.finserv.dto.CreateUserDTO;

@Component
public class CreateUserDTOValidator {
	
	public boolean createUserDtoValidators(CreateUserDTO createUserDTO) {
		
		if(createUserDTO == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DTO is null");
		}
		if(createUserDTO.getFirstName() == "")  {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "First Name is required field.");
		}
		else if(createUserDTO.getLastName() == "") {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Last Name is required field.");
		}
		else if(createUserDTO.getUserName() == "") {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Name is required field.");
		}
		else if(createUserDTO.getPassword() == "") {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required field.");
		}
		return true;
	}

}
