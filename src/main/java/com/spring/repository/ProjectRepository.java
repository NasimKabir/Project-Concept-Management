package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
