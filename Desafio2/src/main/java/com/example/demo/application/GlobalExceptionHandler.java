package com.example.demo.application;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGlobalError(final Exception ex, final ServletRequest req) {
		final ErrorMessage errorMessage = new ErrorMessage(ex);

		return new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	} 
 

}
