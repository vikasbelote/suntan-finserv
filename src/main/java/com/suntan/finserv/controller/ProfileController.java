package com.suntan.finserv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suntan.finserv.dto.CreateInvestorProfileDTO;
import com.suntan.finserv.exception.RestException;
import com.suntan.finserv.service.ProfileService;
import com.suntan.finserv.validators.CreateInvestorProfileDTOValidator;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private CreateInvestorProfileDTOValidator createInvestorProfileDTOValidator;
	
	@GetMapping(value = "investor/{userId}/profile")
	public ResponseEntity<CreateInvestorProfileDTO> getInvestorProfile(@PathVariable Long userId) {
		CreateInvestorProfileDTO createInvestorProfile = profileService.getInvestorProfile(userId);
		return Optional.ofNullable(createInvestorProfile)
				.map(res -> new ResponseEntity<>(createInvestorProfile, HttpStatus.OK))
				.orElseThrow(RestException::new);
	}
	
	@PostMapping(value="investor/profile")
	public ResponseEntity<CreateInvestorProfileDTO> postInvestorProfile(@RequestBody CreateInvestorProfileDTO createInvestorProfileDTO) {
		createInvestorProfileDTOValidator.validate(createInvestorProfileDTO);
		CreateInvestorProfileDTO createInvestorProfile = profileService.saveInvestorProfile(createInvestorProfileDTO);
		return Optional.ofNullable(createInvestorProfile)
				.map(res -> new ResponseEntity<>(createInvestorProfile, HttpStatus.OK))
				.orElseThrow(RestException::new);
	}

}
