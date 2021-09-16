package com.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String projectCode;
	private String projectTitle;
	private String projectObjectives;
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private Date dateOfCommencement;
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private Date completetion;

	@OneToOne
	private ProjectType projectType;
	@OneToOne
	private ProjectPriority projectPriority;
	@OneToOne
	private SectorDivision sectorDivision;
	@OneToOne
	private Sector sector;
	@OneToOne
	private SubSector subSector;
	@OneToOne
	private CofogMain cofogMain;
	@OneToOne
	private CofogMainOptional cofogMainOptional;
	@OneToOne
	private CofogMainDetails cofogMainDetails;
	@OneToOne
	private Fund fund;
}
