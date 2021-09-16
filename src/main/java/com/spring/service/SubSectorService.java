package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.SectorDivision;
import com.spring.model.SubSector;

public interface SubSectorService {
	public  ResponseEntity<?> subSectorInsert(SubSector subSector);
	public  ResponseEntity<?> subSectorList();
}
