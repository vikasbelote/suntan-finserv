package com.suntan.finserv.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.suntan.finserv.dto.CreateInvestorProfileDTO;
import com.suntan.finserv.entity.Address;
import com.suntan.finserv.entity.BankDetails;
import com.suntan.finserv.entity.Person;

@Component
public class InvestorProfileMapper {
	
	public Person createInvestorProfileToPerson(CreateInvestorProfileDTO createInvestorProfileDTO) {
		
		Person person = new Person();
		person.setFirstName(createInvestorProfileDTO.getFirstName());
		person.setMiddleName(createInvestorProfileDTO.getMiddleName());
		person.setLastName(createInvestorProfileDTO.getLastName());
		person.setEmailAddress(createInvestorProfileDTO.getEmailAddress());
		person.setMobileNumber(createInvestorProfileDTO.getMobileNumber());
		person.setPanNumber(createInvestorProfileDTO.getPanCard());
		person.setAdharNumber(createInvestorProfileDTO.getAdharNumber());
		
		BankDetails bank = new BankDetails();
		bank.setPerson(person);
		bank.setBankAccountNumber(createInvestorProfileDTO.getAccountNumber());
		bank.setBankAccountType(createInvestorProfileDTO.getAccountType());
		bank.setBankIfscCode(createInvestorProfileDTO.getIfscCode());
		bank.setBankBranchName(createInvestorProfileDTO.getBranch());
		List<BankDetails> bankDetails = new ArrayList<BankDetails>();
		bankDetails.add(bank);
		person.setBankDetails(bankDetails);
		
		Address address = new Address();
		address.setPerson(person);
		address.setAddressText(createInvestorProfileDTO.getAddressText());
		address.setAddressCity(createInvestorProfileDTO.getCity());
		address.setAddressState(createInvestorProfileDTO.getState());
		address.setAddressPinCode(createInvestorProfileDTO.getPincode());
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		person.setAddresses(addresses);
		return person;
	}
	
	public CreateInvestorProfileDTO personToCreateInvestorProfileDTO(Person person) {
		CreateInvestorProfileDTO createInvestorProfileDTO = new CreateInvestorProfileDTO();
		createInvestorProfileDTO.setPersonId(person.getPersonId());
		createInvestorProfileDTO.setFirstName(person.getFirstName());
		createInvestorProfileDTO.setMiddleName(person.getMiddleName());
		createInvestorProfileDTO.setLastName(person.getLastName());
		createInvestorProfileDTO.setEmailAddress(person.getEmailAddress());
		createInvestorProfileDTO.setMobileNumber(person.getMobileNumber());
		createInvestorProfileDTO.setPanCard(person.getPanNumber());
		createInvestorProfileDTO.setAdharNumber(person.getAdharNumber());
		createInvestorProfileDTO.setBankId(person.getBankDetails().get(0).getBankId());
		createInvestorProfileDTO.setAccountNumber(person.getBankDetails().get(0).getBankAccountNumber());
		createInvestorProfileDTO.setAccountType(person.getBankDetails().get(0).getBankAccountType());
		createInvestorProfileDTO.setIfscCode(person.getBankDetails().get(0).getBankIfscCode());
		createInvestorProfileDTO.setBranch(person.getBankDetails().get(0).getBankBranchName());
		createInvestorProfileDTO.setAddressId(person.getAddresses().get(0).getAddressId());
		createInvestorProfileDTO.setAddressText(person.getAddresses().get(0).getAddressText());
		createInvestorProfileDTO.setCity(person.getAddresses().get(0).getAddressCity());
		createInvestorProfileDTO.setState(person.getAddresses().get(0).getAddressState());
		createInvestorProfileDTO.setPincode(person.getAddresses().get(0).getAddressPinCode());
		return createInvestorProfileDTO;
	}

}
