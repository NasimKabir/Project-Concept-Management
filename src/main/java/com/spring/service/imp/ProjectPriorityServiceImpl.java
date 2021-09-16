package com.spring.service.imp;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.model.ProjectPriority;
import com.spring.repository.ProjectPriorityRepository;
import com.spring.response.HttpResponse;
import com.spring.service.ProjectPriorityService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectPriorityServiceImpl implements ProjectPriorityService{
	private final ProjectPriorityRepository projectPriorityRepository;

	@Override
	public ResponseEntity<?> projectPriorityinsert(ProjectPriority projectPriority) {
		projectPriority=projectPriorityRepository.save(projectPriority);
		HttpResponse response=new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("ProjectPriority insert Successfull");
		return new ResponseEntity<>(projectPriority,CREATED);
	}

	@Override
	public ResponseEntity<?> projectPriorityTypeList() {
		List<ProjectPriority> projectPriority = projectPriorityRepository.findAll();
		HttpResponse response=new HttpResponse();
		response.setHttpStatusCode(OK.value());
		response.setHttpStatus(OK);
		response.setMessage("retrieved Successfull");
		return  new ResponseEntity<>(projectPriority,OK);
	}

}
