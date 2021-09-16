package com.spring.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectType extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String projectTypeName;
	
}
