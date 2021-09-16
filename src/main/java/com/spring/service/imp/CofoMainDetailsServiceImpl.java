package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainDetails;
import com.spring.model.ProjectType;
import com.spring.repository.CofoMainDetailsRepository;
import com.spring.repository.CofoMainRepository;
import com.spring.response.HttpResponse;
import com.spring.service.CofoMainDetailsService;
import com.spring.service.CofoMainService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CofoMainDetailsServiceImpl implements CofoMainDetailsService{
private final CofoMainDetailsRepository cofoMainDetailsRepository;

@Override
public ResponseEntity<?> CofoInsert(CofogMainDetails cofogMainDetails) {
	cofogMainDetails= cofoMainDetailsRepository.save(cofogMainDetails);
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(CREATED.value());
	response.setHttpStatus(CREATED);
	response.setMessage("cofogMainDetails insert Successfull");
	return new ResponseEntity<>(cofogMainDetails, CREATED);
}

@Override
public ResponseEntity<?> CofoList() {
	List<CofogMainDetails> cofogMainDetails = cofoMainDetailsRepository.findAll();
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(OK.value());
	response.setHttpStatus(OK);
	response.setMessage("cofogMainDetails insert Successfull");
	return new ResponseEntity<>(cofogMainDetails, OK);
}

}
