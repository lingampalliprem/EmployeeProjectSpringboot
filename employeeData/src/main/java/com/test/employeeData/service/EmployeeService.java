package com.test.employeeData.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.employeeData.model.Address;
import com.test.employeeData.model.Employee;
import com.test.employeeData.repository.AddressRepository;
import com.test.employeeData.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AddressRepository addressRepository;
	public Employee saveEmp(Employee emp) {
		
		 employeeRepository.save(emp);
		 Address address=emp.getAddress();
	
		 addressRepository.save(address);	
		 return emp;
	}
	public List<Employee> getEmployeesByPinCode(Integer pincode) {
		List<Address> adress=addressRepository.findByPincode(pincode);
		
		List<Employee> list=employeeRepository.findAllByAddressIn(adress);
		
		return list;
	}

	public Optional<Employee> findById(long id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		return emp;
	}

	public List<Employee> findByStartsWithName(String name){
		List<Employee> list=employeeRepository.findByNameStartsWith(name);
		return list;
	}
	
	public List<Employee> saveAllEnities(List<Employee> emps){
		 employeeRepository.saveAll(emps);
		 List<Address> addressList=new ArrayList<Address>();
	for(Employee emp:emps) {
		addressList.add(emp.getAddress());
	}
		addressRepository.saveAll(addressList);	
		return emps;
	}
}
