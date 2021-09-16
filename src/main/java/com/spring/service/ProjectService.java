package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.Project;

public interface ProjectService {
	public  ResponseEntity<?> projectInsert(Project project);
	public  ResponseEntity<?> projectList();
}
