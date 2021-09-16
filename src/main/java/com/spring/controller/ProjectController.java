package com.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainDetails;
import com.spring.model.CofogMainOptional;
import com.spring.model.Project;
import com.spring.model.ProjectPriority;
import com.spring.model.ProjectType;
import com.spring.model.Sector;
import com.spring.model.SectorDivision;
import com.spring.model.SubSector;
import com.spring.service.CofoMainDetailsService;
import com.spring.service.CofoMainOptionalService;
import com.spring.service.CofoMainService;
import com.spring.service.ProjectPriorityService;
import com.spring.service.ProjectService;
import com.spring.service.ProjectTypeService;
import com.spring.service.SectorDivisionService;
import com.spring.service.SectorService;
import com.spring.service.SubSectorService;
import com.spring.service.imp.FundServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ProjectController {
	private final ProjectTypeService projectTypeService;
	private final ProjectPriorityService priorityService;
	private final ProjectService projectService;
	private final CofoMainDetailsService cofoMainDetailsService;
	private final CofoMainOptionalService cofoMainOptionalService;
	private final CofoMainService cofoMainService;
	private final SectorDivisionService sectorDivisionService;
	private final SectorService sectorService;
	private final SubSectorService subSectorService;
	private final FundServiceImpl fundServiceImpl;

	@PostMapping
	public  ResponseEntity<?> projectInsert(@RequestBody Project Project) {
		return projectService.projectInsert(Project);

	}
	
	@PostMapping("/fund")
	public  ResponseEntity<?> fundInsert(@RequestParam("fundType") boolean fundType,
            @RequestParam(value="agrementNumber", required = false) int agrementNumber,
            @RequestParam(value="agrementFile" ,required = false) MultipartFile agrementFile) throws Exception {
		return fundServiceImpl.FundInsert(fundType,agrementNumber,agrementFile);

	}
	
	@PostMapping("/type")
	public  ResponseEntity<?> projectTypeInsert(@RequestBody ProjectType ProjectType) {
		return projectTypeService.projectTypeinsert(ProjectType);

	}

	@GetMapping("/type")
	public  ResponseEntity<?> getAllProjectTypeList() {
		return projectTypeService.projectTypeList();
	}
	
	@PostMapping("/priority")
	public  ResponseEntity<?> projectPriorityInsert(@RequestBody ProjectPriority projectPriority) {
		return priorityService.projectPriorityinsert(projectPriority);

	}

	@GetMapping("/priority")
	public  ResponseEntity<?> getAllProjectPrioriryList() {
		return priorityService.projectPriorityTypeList();
	}
	
	@PostMapping("/cofoMainDetails")
	public ResponseEntity<?> CofoMainDetailsInsert(@RequestBody CofogMainDetails cofogMainDetails) {
		return cofoMainDetailsService.CofoInsert(cofogMainDetails);

	}

	@GetMapping("/cofoMainDetails")
	public ResponseEntity<?> getAllCofoMainDetailsList() {
		return cofoMainDetailsService.CofoList();
	}
	
	//extra
	@PostMapping("/cofoMainOptional")
	public ResponseEntity<?> cofoMainOptionalInsert(@RequestBody CofogMainOptional cofogMainOptional) {
		return cofoMainOptionalService.CofoMainOptionalInsert(cofogMainOptional);

	}

	@GetMapping("/cofoMainOptional")
	public ResponseEntity<?> getAllcofoMainOptionalList() {
		return cofoMainOptionalService.cofoMainOptionalList();
	}
	@PostMapping("/cofoMain")
	public ResponseEntity<?> projectCofoMainInsert(@RequestBody CofogMain cofogMain) {
		return cofoMainService.CofoMainInsert(cofogMain);

	}

	@GetMapping("/cofoMain")
	public ResponseEntity<?> getAllCofoMainList() {
		return cofoMainService.cofoMainList();
	}
	@PostMapping("/sectorDivision")
	public ResponseEntity<?> projectSectorDivisionInsert(@RequestBody SectorDivision sectorDivision) {
		return sectorDivisionService.SectorDivisionInsert(sectorDivision);

	}

	@GetMapping("/sectorDivision")
	public ResponseEntity<?> getAllSectorDivisionList() {
		return sectorDivisionService.SectorDivisionList();
	}
	@PostMapping("/sector")
	public ResponseEntity<?> projectSectorInsert(@RequestBody Sector sector) {
		return sectorService.SectorInsert(sector);

	}

	@GetMapping("/sector")
	public ResponseEntity<?> getAllSectorList() {
		return sectorService.SectorList();
	}
	@PostMapping("/subSector")
	public ResponseEntity<?> projectPriorityInsert(@RequestBody SubSector subSector) {
		return subSectorService.subSectorInsert(subSector);

	}

	@GetMapping("/subSector")
	public ResponseEntity<?> getAllSubSectorList() {
		return subSectorService.subSectorList();
	}


}
