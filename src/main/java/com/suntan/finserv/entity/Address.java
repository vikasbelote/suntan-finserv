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
@Table(name = "suntan_address")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private Long addressId;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Column(name = "address_text")
	private String addressText;
	
	@Column(name = "address_city")
	private String addressCity;
	
	@Column(name = "address_state")
	private String addressState;
	
	@Column(name = "address_pincode")
	private Integer addressPinCode;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
}
