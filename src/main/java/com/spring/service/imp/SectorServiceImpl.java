package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.model.Sector;
import com.spring.model.SectorDivision;
import com.spring.repository.SectorRepository;
import com.spring.response.HttpResponse;
import com.spring.service.SectorDivisionService;
import com.spring.service.SectorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {
private final SectorRepository sectorRepository;
	@Override
	public ResponseEntity<?> SectorInsert(Sector sector) {
		sector= sectorRepository.save(sector);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("sector  insert Successfull");
		return new ResponseEntity<>(sector, CREATED);
	}

	@Override
	public ResponseEntity<?> SectorList() {
		List<Sector> sector = sectorRepository.findAll();
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("ProjectPriority insert Successfull");
		return new ResponseEntity<>(sector, OK);
	}


}
