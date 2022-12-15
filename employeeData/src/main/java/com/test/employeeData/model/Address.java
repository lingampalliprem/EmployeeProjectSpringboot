package com.test.employeeData.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address_tbl")
@Setter
@Getter
@JsonIgnoreProperties
public class Address {
	@Id
	@GeneratedValue
  private   Long address_id;
private	String area_name;
private	String flatNum;
private	int pincode;
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Employee employee;

}
