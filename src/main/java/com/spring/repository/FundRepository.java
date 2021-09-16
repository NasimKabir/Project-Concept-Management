package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Fund;

public interface FundRepository extends JpaRepository<Fund, Long> {

}
