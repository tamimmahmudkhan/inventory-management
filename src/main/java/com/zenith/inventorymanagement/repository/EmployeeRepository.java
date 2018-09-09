package com.zenith.inventorymanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zenith.inventorymanagement.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
