package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.CofogMain;
import com.spring.model.ProjectType;
import com.spring.repository.CofoMainRepository;
import com.spring.response.HttpResponse;
import com.spring.service.CofoMainService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CofoMainServiceImpl implements CofoMainService{
private final CofoMainRepository cofoMainRepository;

@Override
public ResponseEntity<?> CofoMainInsert(CofogMain cofogMain) {
	cofogMain= cofoMainRepository.save(cofogMain);
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(CREATED.value());
	response.setHttpStatus(CREATED);
	response.setMessage("cofogMain insert Successfull");
	return new ResponseEntity<>(cofogMain, CREATED);
}

@Override
public ResponseEntity<?> cofoMainList() {
	List<CofogMain> cofogMain = cofoMainRepository.findAll();
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(OK.value());
	response.setHttpStatus(OK);
	response.setMessage("cofogMain insert Successfull");
	return new ResponseEntity<>(cofogMain, OK);
}
}
