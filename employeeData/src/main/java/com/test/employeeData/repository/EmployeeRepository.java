package com.test.employeeData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.employeeData.model.Address;
import com.test.employeeData.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//List<Employee> fin(List<Address> adress);

	List<Employee> findAllByAddressIn(List<Address> adress);
	List<Employee> findByNameStartsWith(String name);
}
