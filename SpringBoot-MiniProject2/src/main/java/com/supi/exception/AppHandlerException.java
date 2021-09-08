package com.supi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppHandlerException {
	
	
	@ExceptionHandler(value=NoDataFoundException.class)
	public ResponseEntity<String> handleExpection(NoDataFoundException ndfe){
	
	String exMsg=ndfe.getMessage();
       return  new ResponseEntity<> (exMsg, HttpStatus.BAD_REQUEST);
	}
}
