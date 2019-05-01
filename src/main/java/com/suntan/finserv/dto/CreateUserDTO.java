package com.suntan.finserv.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
	
	private Long userId;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
}
