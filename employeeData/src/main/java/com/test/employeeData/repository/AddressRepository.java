package com.test.employeeData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.employeeData.model.Address;
import com.test.employeeData.model.Employee;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByPincode(Integer pincode);

	

}
