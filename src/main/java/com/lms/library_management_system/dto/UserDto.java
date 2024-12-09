package com.lms.library_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int userId;
	private String name;
	private long phoneNumber;
	private String email;
}