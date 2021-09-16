package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.ProjectType;
import com.spring.repository.ProjectTypeRepository;
import com.spring.response.HttpResponse;
import com.spring.service.ProjectTypeService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectTypeServiceImpl implements ProjectTypeService{
	private final ProjectTypeRepository projectTypeRepository;

	@Override
	public ResponseEntity<?> projectTypeinsert(ProjectType projectType) {
		projectType= projectTypeRepository.save(projectType);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("ProjectType insert Successfull");
		return new ResponseEntity<>(projectType, CREATED);
	}

	@Override
	public ResponseEntity<?> projectTypeList() {
		List<ProjectType> projectType = projectTypeRepository.findAll();
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("ProjectPriority insert Successfull");
		return new ResponseEntity<>(projectType, OK);
	}

}
