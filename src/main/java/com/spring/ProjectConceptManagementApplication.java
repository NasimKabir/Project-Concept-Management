package com.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.model.CofogMain;
import com.spring.model.CofogMainDetails;
import com.spring.model.CofogMainOptional;
import com.spring.model.ProjectPriority;
import com.spring.model.ProjectType;
import com.spring.model.Role;
import com.spring.model.Sector;
import com.spring.model.SectorDivision;
import com.spring.model.SubSector;
import com.spring.model.User;
import com.spring.repository.CofoMainDetailsRepository;
import com.spring.repository.CofoMainOptionalRepository;
import com.spring.repository.CofoMainRepository;
import com.spring.repository.ProjectPriorityRepository;
import com.spring.repository.ProjectTypeRepository;
import com.spring.repository.RoleRepository;
import com.spring.repository.SectorDivisionRepository;
import com.spring.repository.SectorRepository;
import com.spring.repository.SubSectorRepository;
import com.spring.repository.UserRepository;

@SpringBootApplication
public class ProjectConceptManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectConceptManagementApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userDetailsRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProjectTypeRepository projectTypeRepository;
	@Autowired
	private ProjectPriorityRepository projectPriorityRepository;
	@Autowired
	private CofoMainDetailsRepository cofoMainDetailsRepository;
	@Autowired
	private CofoMainOptionalRepository cofoMainOptionalRepository;
	@Autowired
	private CofoMainRepository cofoMainRepository;
	@Autowired
	private SectorDivisionRepository sectorDivisionRepository;
	@Autowired
	private SectorRepository sectorRepository;
	@Autowired
	private SubSectorRepository subSectorRepository;

	@PostConstruct
	protected void init() {
// add user role
		List<Role> roleList = new ArrayList<>();
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		roleList.add(role);
		roleRepository.save(role);

// add user information
		User user = new User();
		user.setUsername("nasim");
		user.setPassword(passwordEncoder.encode("nasim"));
		user.setRoles(roleList);
		userDetailsRepository.save(user);
//add project type
		List<ProjectType> projectType = new ArrayList<>();
		projectType.add(new ProjectType("Web Application"));
		projectType.add(new ProjectType("Mobile Application"));
		projectTypeRepository.saveAll(projectType);

// add project priority
		List<ProjectPriority> projectPriority = new ArrayList<>();
		projectPriority.add(new ProjectPriority("High"));
		projectPriority.add(new ProjectPriority("Medium"));
		projectPriority.add(new ProjectPriority("Low"));
		projectPriorityRepository.saveAll(projectPriority);

// add CofogMainDetails
		List<CofogMainDetails> cofogMainDetails = new ArrayList<>();
		cofogMainDetails.add(new CofogMainDetails("CofogMainDetails1"));
		cofogMainDetails.add(new CofogMainDetails("CofogMainDetails2"));
		cofogMainDetails.add(new CofogMainDetails("CofogMainDetails3"));
		cofoMainDetailsRepository.saveAll(cofogMainDetails);

// add cofogMainOptional
		List<CofogMainOptional> cofogMainOptional = new ArrayList<>();
		cofogMainOptional.add(new CofogMainOptional("cofogMainOptional1"));
		cofogMainOptional.add(new CofogMainOptional("cofogMainOptional2"));
		cofogMainOptional.add(new CofogMainOptional("cofogMainOptional3"));
		cofoMainOptionalRepository.saveAll(cofogMainOptional);

// add cofogMain
		List<CofogMain> cofogMain = new ArrayList<>();
		cofogMain.add(new CofogMain("cofogMain1"));
		cofogMain.add(new CofogMain("cofogMain2"));
		cofogMain.add(new CofogMain("cofogMain3"));
		cofoMainRepository.saveAll(cofogMain);

// add sectorDivision
		List<SectorDivision> sectorDivision = new ArrayList<>();
		sectorDivision.add(new SectorDivision("sectorDivision1"));
		sectorDivision.add(new SectorDivision("sectorDivision2"));
		sectorDivision.add(new SectorDivision("sectorDivision3"));
		sectorDivisionRepository.saveAll(sectorDivision);

// add Sector
		List<Sector> sector = new ArrayList<>();
		sector.add(new Sector("Sector1"));
		sector.add(new Sector("Sector2"));
		sector.add(new Sector("Sector3"));
		sectorRepository.saveAll(sector);

		// add SubSector
		List<SubSector> subSector = new ArrayList<>();
		subSector.add(new SubSector("SubSector1"));
		subSector.add(new SubSector("SubSector2"));
		subSector.add(new SubSector("SubSector3"));
		subSectorRepository.saveAll(subSector);


	}

}
