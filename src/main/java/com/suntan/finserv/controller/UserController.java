package com.suntan.finserv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suntan.finserv.dto.CreateUserDTO;
import com.suntan.finserv.exception.RestException;
import com.suntan.finserv.service.UserService;
import com.suntan.finserv.validators.CreateUserDTOValidator;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CreateUserDTOValidator requestValidator;
	
	@PostMapping(value = "postUser")
	public ResponseEntity<CreateUserDTO> postUser(@RequestBody CreateUserDTO createUserDTO) {	
		requestValidator.createUserDtoValidators(createUserDTO);
		CreateUserDTO user = userService.saveUser(createUserDTO);		
		return Optional.ofNullable(createUserDTO)
				.map(res -> new ResponseEntity<CreateUserDTO>(user, HttpStatus.OK))
				.orElseThrow(RestException::new);
	}

}
