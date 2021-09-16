package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.model.SectorDivision;
import com.spring.repository.SectorDivisionRepository;
import com.spring.response.HttpResponse;
import com.spring.service.SectorDivisionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectorDivisionServiceImpl implements SectorDivisionService {
private final SectorDivisionRepository sectorDivisionRepository;
	@Override
	public ResponseEntity<?> SectorDivisionInsert(SectorDivision sectorDivision) {
		sectorDivision= sectorDivisionRepository.save(sectorDivision);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("sectorDivision insert Successfull");
		return new ResponseEntity<>(sectorDivision, CREATED);
	}

	@Override
	public ResponseEntity<?> SectorDivisionList() {
		List<SectorDivision> sectorDivision = sectorDivisionRepository.findAll();
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("ProjectPriority insert Successfull");
		return new ResponseEntity<>(sectorDivision, OK);
	}

}
