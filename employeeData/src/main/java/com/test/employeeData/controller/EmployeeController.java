package com.test.employeeData.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.employeeData.model.Address;
import com.test.employeeData.model.Employee;
import com.test.employeeData.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		System.out.println(emp.getName());
		 System.out.println(emp.getAddress().getArea_name());
		Employee employee=employeeService.saveEmp(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("getByPincode/{pincode}")
	public ResponseEntity<List<Employee>> getbyAddress(@PathVariable Integer pincode){
		System.out.println("getby Address method");
		System.out.println("get method.....");
		List<Employee> list=employeeService.getEmployeesByPinCode(pincode);
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}

	@PutMapping("updateEmployeeAddress/{id}")
	public ResponseEntity<Employee> updateEmployeeAddress(@PathVariable Long id,@Valid @RequestBody Employee emp) throws Exception{	
		Employee empl=employeeService.findById(id).orElseThrow(() -> new Exception("Instructor not found :: " + emp.getId()));
		emp.setId(id);
		Employee employee=employeeService.saveEmp(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PutMapping("updateEmployeeDetailsStartsWith/{val}")
	public ResponseEntity<List<Employee>> updateEmployeeDetailsStartsWith(@PathVariable String val,@Valid @RequestBody List<Employee> emps) throws Exception{	
		List<Employee> emplist=employeeService.findByStartsWithName(val);// val=s	
		List<Employee> employeeList=employeeService.saveAllEnities(emps);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
}
