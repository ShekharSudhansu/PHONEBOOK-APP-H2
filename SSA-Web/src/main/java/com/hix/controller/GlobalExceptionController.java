package com.hix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hix.exception.SSNoNotFound;
import com.hix.exception.getExCode;

@ControllerAdvice
public class GlobalExceptionController {
	
	
	@ExceptionHandler(SSNoNotFound.class)
	public ResponseEntity raiseException() {
		return new ResponseEntity((MultiValueMap<String, String>) new getExCode(), HttpStatus.OK);
	}
	
}
