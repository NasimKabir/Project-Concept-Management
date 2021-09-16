package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainOptional;
import com.spring.model.ProjectType;
import com.spring.repository.CofoMainOptionalRepository;
import com.spring.repository.CofoMainRepository;
import com.spring.response.HttpResponse;
import com.spring.service.CofoMainOptionalService;
import com.spring.service.CofoMainService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CofoMainOptionalServiceImpl implements CofoMainOptionalService{
private final CofoMainOptionalRepository cofoMainOpCofoMainRepository;

@Override
public ResponseEntity<?> CofoMainOptionalInsert(CofogMainOptional cofogMainOptional) {
	cofogMainOptional= cofoMainOpCofoMainRepository.save(cofogMainOptional);
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(CREATED.value());
	response.setHttpStatus(CREATED);
	response.setMessage("cofogMainOptional insert Successfull");
	return new ResponseEntity<>(cofogMainOptional, CREATED);
}

@Override
public ResponseEntity<?> cofoMainOptionalList() {
	List<CofogMainOptional> cofogMainOptional = cofoMainOpCofoMainRepository.findAll();
	HttpResponse response = new HttpResponse();
	response.setHttpStatusCode(OK.value());
	response.setHttpStatus(OK);
	response.setMessage("cofogMainOptional insert Successfull");
	return new ResponseEntity<>(cofogMainOptional, OK);
}


}
