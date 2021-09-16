package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.model.Project;
import com.spring.repository.ProjectRepository;
import com.spring.response.HttpResponse;
import com.spring.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;

	@Override
	public ResponseEntity<?> projectInsert(Project project) {
		project = projectRepository.save(project);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("Project insert Successfull");
		return new ResponseEntity<>(project, CREATED);

	}

	@Override
	public ResponseEntity<?> projectList() {
		List<Project> projectList = projectRepository.findAll();
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("Project retrived Successfull");
		return new ResponseEntity<>(projectList, OK);

	}

}
