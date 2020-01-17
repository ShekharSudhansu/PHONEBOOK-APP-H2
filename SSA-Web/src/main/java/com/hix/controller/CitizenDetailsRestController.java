package com.hix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hix.exception.SSNoNotFound;
import com.hix.service.SsaMngtService;

@RestController
public class CitizenDetailsRestController {
	@Autowired
	 private SsaMngtService service;
	
	
		@GetMapping(value="/getCode/{ssNo}",produces = "application/json")
		public String getStateCode(@PathVariable("ssNo")String ssNo) throws SSNoNotFound {
				String stateCodeBySSN = service.getStateCodeBySSN(ssNo);
				if(stateCodeBySSN!=null) {
					return stateCodeBySSN;
				}
				else {
					throw new SSNoNotFound();
				}
		}
}
