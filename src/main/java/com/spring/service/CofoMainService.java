package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.CofogMain;

public interface CofoMainService {
	public  ResponseEntity<?> CofoMainInsert(CofogMain cofogMain);
	public  ResponseEntity<?> cofoMainList();
}
