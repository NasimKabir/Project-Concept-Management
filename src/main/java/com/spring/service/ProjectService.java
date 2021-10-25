package com.spring.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainDetails;
import com.spring.model.CofogMainOptional;
import com.spring.model.Fund;
import com.spring.model.Project;
import com.spring.model.ProjectPriority;
import com.spring.model.ProjectType;
import com.spring.model.Sector;
import com.spring.model.SectorDivision;
import com.spring.model.SubSector;

public interface ProjectService {
	public  ResponseEntity<?> projectInsert(@RequestBody Project project);
	public  ResponseEntity<?> projectList();
}
