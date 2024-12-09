package com.lms.library_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private int houseNumber;
	private String area;
	private String city;
	private String state;
	private String country;
	private long pincode;
}
