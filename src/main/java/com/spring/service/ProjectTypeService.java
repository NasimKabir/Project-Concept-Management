package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.model.ProjectType;

public interface ProjectTypeService {
	public  ResponseEntity<?> projectTypeinsert(ProjectType projectType);
	public  ResponseEntity<?> projectTypeList();
}
