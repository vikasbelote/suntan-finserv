package com.suntan.finserv.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "suntan_person")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "")
	private Long personId;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private UserDetail userDetail;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<BankDetails> bankDetails;
	
	@Column(name = "person_first_name")
	private String firstName;
	
	@Column(name = "person_middle_name")
	private String middleName;
	
	@Column(name = "person_last_name")
	private String lastName;
	
	@Column(name = "person_mobile_number")
	private Long mobileNumber;
	
	@Column(name = "person_email_address")
	private String emailAddress;
	
	@Column(name = "person_pan_number")
	private String panNumber;
	
	@Column(name = "person_adhar_number")
	private Long adharNumber;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
