package com.suntan.finserv.validators;

import org.springframework.stereotype.Component;

import com.suntan.finserv.dto.CreateInvestorProfileDTO;

@Component(value = "CreateInvestorProfileDTOValidator")
public class CreateInvestorProfileDTOValidator  {
	
	public boolean validate(CreateInvestorProfileDTO createInvestorProfileDTO) {
		return true;
	}

	
}
