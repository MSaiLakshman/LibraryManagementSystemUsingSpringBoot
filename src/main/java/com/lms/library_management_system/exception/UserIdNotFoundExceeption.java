package com.lms.library_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserIdNotFoundExceeption extends RuntimeException {
	private String message;
}