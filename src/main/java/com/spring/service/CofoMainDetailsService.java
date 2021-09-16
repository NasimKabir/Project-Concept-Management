package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.CofogMainDetails;

public interface CofoMainDetailsService {
	public  ResponseEntity<?> CofoInsert(CofogMainDetails cofogMainDetails);
	public  ResponseEntity<?> CofoList();
}
