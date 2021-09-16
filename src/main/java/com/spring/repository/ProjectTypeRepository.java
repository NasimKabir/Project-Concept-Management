package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

}
