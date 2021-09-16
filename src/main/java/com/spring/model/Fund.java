package com.spring.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fund extends BaseModel{
private boolean fundType;
private int agrementNumber;
private String agrementFile;
}
