package com.rakesh.crudwithhibernate.repository;

import java.util.List;

import com.rakesh.crudwithhibernate.entity.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();
	Employee findById(Integer id);
	Integer save(Employee employee);
	Employee update(Employee employee);
	void delete(Integer id);
}
