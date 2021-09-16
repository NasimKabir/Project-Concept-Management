package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.Sector;

public interface SectorService {
	public  ResponseEntity<?> SectorInsert(Sector sector);
	public  ResponseEntity<?> SectorList();
}
