package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.CofogMain;
import com.spring.model.SectorDivision;

public interface SectorDivisionRepository extends JpaRepository<SectorDivision, Long> {

}
