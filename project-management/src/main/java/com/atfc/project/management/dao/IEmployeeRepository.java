package com.atfc.project.management.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atfc.project.management.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	

}
