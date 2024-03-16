package com.codegnan.exection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(invalidPatientIdExection.class)
	public ResponseEntity<ErrorResponse> meth1(invalidPatientIdExection e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
	
	@ExceptionHandler(invalidDoctorIdExection.class)
	public ResponseEntity<ErrorResponse> meth1(invalidDoctorIdExection e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> meth2(Exception e){
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String message = e.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
	
	

}
