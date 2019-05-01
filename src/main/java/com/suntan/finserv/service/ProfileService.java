package com.suntan.finserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntan.finserv.dto.CreateInvestorProfileDTO;
import com.suntan.finserv.entity.Person;
import com.suntan.finserv.entity.UserDetail;
import com.suntan.finserv.mapper.InvestorProfileMapper;

@Service
public class ProfileService {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InvestorProfileMapper investorProfileMapper;
	
	public CreateInvestorProfileDTO getInvestorProfile(Long userId) {
		UserDetail userDetail = userService.getUserDetail(userId);
		Person person = userDetail.getPerson();
		return investorProfileMapper.personToCreateInvestorProfileDTO(person);
	}
	
	public CreateInvestorProfileDTO saveInvestorProfile(CreateInvestorProfileDTO createInvestorProfileDTO) {
		Person person = investorProfileMapper.createInvestorProfileToPerson(createInvestorProfileDTO);
		person = personService.savePerson(person);
		return investorProfileMapper.personToCreateInvestorProfileDTO(person);
	}
	
	

}
