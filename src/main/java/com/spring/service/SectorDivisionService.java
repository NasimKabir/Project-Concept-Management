package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.SectorDivision;

public interface SectorDivisionService {
	public  ResponseEntity<?> SectorDivisionInsert(SectorDivision sectorDivision);
	public  ResponseEntity<?> SectorDivisionList();
}
