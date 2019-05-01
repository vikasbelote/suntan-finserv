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
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CreateUserDTOValidator requestValidator;
	
	@PostMapping(value = "user/validate")
	public ResponseEntity<CreateUserDTO> postValidateUser(@RequestBody CreateUserDTO createUserDTO) {
		requestValidator.createUserDtoValidators(createUserDTO);
		CreateUserDTO userByNameAndPassword = userService.getUserByNameAndPassword(createUserDTO);
		
		return Optional.ofNullable(userByNameAndPassword)
				.map(res -> new ResponseEntity<CreateUserDTO>(userByNameAndPassword, HttpStatus.OK))
				.orElseThrow(RestException::new);
	}
}
