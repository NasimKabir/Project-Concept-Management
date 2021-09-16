package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.model.Sector;
import com.spring.model.SectorDivision;
import com.spring.model.SubSector;
import com.spring.repository.SectorRepository;
import com.spring.repository.SubSectorRepository;
import com.spring.response.HttpResponse;
import com.spring.service.SectorDivisionService;
import com.spring.service.SectorService;
import com.spring.service.SubSectorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubSectorServiceImpl implements SubSectorService {
private final SubSectorRepository subSectorRepository;

	@Override
	public ResponseEntity<?> subSectorInsert(SubSector subSector) {
		subSector= subSectorRepository.save(subSector);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("subSector  insert Successfull");
		return new ResponseEntity<>(subSector, CREATED);
	}

	@Override
	public ResponseEntity<?> subSectorList() {
		List<SubSector> subSector = subSectorRepository.findAll();
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("subSector insert Successfull");
		return new ResponseEntity<>(subSector, OK);
		
	}


}
