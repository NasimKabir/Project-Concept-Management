package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.ProjectPriority;

public interface ProjectPriorityService {
	public ResponseEntity<?> projectPriorityinsert(ProjectPriority projectPriority);
	public ResponseEntity<?> projectPriorityTypeList();
}
