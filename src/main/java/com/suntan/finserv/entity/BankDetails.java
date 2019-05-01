package com.suntan.finserv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "suntan_person_bank_details")
@EntityListeners(AuditingEntityListener.class)
@Data
public class BankDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "bank_id")
	private Long bankId;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Column(name = "bank_account_type")
	private String bankAccountType;
	
	@Column(name = "bank_account_number")
	private Long bankAccountNumber;
	
	@Column(name = "bank_branch_name")
	private String bankBranchName;
	
	@Column(name = "bank_ifsc_code")
	private String bankIfscCode;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
