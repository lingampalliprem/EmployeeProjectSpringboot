package com.test.employeeData.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee_tbl")
@Setter
@Getter
@JsonIgnoreProperties
public class Employee {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	   // @Resource(path = "libraryAddress", rel="address")
	    private Address address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
