package com.lms.library_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundExceeption extends RuntimeException {
	private String message;
}
