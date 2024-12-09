package com.lms.library_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lms.library_management_system.util.ResponseStructure;

@ControllerAdvice
public class LMSExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAddressIdNotFoundException(AddressIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address not Found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserIdNotFoundExceeption.class)
	public ResponseEntity<ResponseStructure<String>> handleUserIdNotFoundException(UserIdNotFoundExceeption e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User Id not Found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>> (responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotFoundExceeption.class)
	public ResponseEntity<ResponseStructure<String>> handleNotFoundExceeption(NotFoundExceeption e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id not Found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>> (responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User not Found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>> (responseStructure, HttpStatus.NOT_FOUND);
	}
}
