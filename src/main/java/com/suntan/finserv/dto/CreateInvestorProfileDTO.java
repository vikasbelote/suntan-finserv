package com.suntan.finserv.dto;

import lombok.Data;

@Data
public class CreateInvestorProfileDTO {
	private Long personId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private Long mobileNumber;
    private String panCard;
    private Long adharNumber;
    private Long bankId;
    private Long accountNumber;
    private String accountType;
    private String ifscCode;
    private String branch;
    private Long addressId;
    private String addressText;
    private String city;
    private String state;
    private Integer pincode;
}
