package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.CofogMain;
import com.spring.model.SubSector;

public interface SubSectorRepository extends JpaRepository<SubSector, Long> {

}
