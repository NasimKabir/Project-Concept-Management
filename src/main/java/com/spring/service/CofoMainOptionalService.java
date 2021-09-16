package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainOptional;

public interface CofoMainOptionalService {
	public  ResponseEntity<?> CofoMainOptionalInsert(CofogMainOptional cofogMainOptional);
	public  ResponseEntity<?> cofoMainOptionalList();
}
