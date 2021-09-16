package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.ProjectPriority;

public interface ProjectPriorityRepository extends JpaRepository<ProjectPriority, Long> {

}
