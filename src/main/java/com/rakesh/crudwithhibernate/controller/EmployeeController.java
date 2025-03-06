package com.rakesh.crudwithhibernate.controller;


import java.util.List;

import com.rakesh.crudwithhibernate.entity.Employee;
import com.rakesh.crudwithhibernate.service.EmployeeService;
import com.rakesh.crudwithhibernate.service.EmployeeServiceImpl;

public class EmployeeController {
    EmployeeService employeeService;
	
	public EmployeeController() {
		this.employeeService = new EmployeeServiceImpl();
	}
	
	public void findAll(){
		List<Employee> employeeList = employeeService.findAll();
		if(employeeList==null) {
			System.out.println("Finding employees failed, try again!");
			return;
		}
        System.out.printf("%-15s%-15s%-15s%-15s%n","id", "name", "department", "salary");
		for(int i=0; i<employeeList.size(); i++) {
			Employee currentEmployee = employeeList.get(i);
			System.out.printf("%-15s%-15s%-15s%-15s%n",currentEmployee.getId(), currentEmployee.getName(), currentEmployee.getDepartment(), currentEmployee.getSalary());
		}
		
	}
	
	public void findById(Integer id) {
		Employee employeeFound = employeeService.findById(id);
		if(employeeFound==null) {
			System.out.println("Employee with given id not found, try again!");
			return;
		}
        System.out.printf("%-15s%-15s%-15s%-15s%n","id", "name", "department", "salary");
		System.out.printf("%-15s%-15s%-15s%-15s%n",employeeFound.getId(), employeeFound.getName(), employeeFound.getDepartment(), employeeFound.getSalary());
	}
	
	public void save(String name, String department, String salary) {
		Integer employeeId = employeeService.save(name, department, salary);
		if(employeeId==null) {
			System.out.println("Employee with given credentials cannot be saved, try again!");
			return;
		}
        System.out.printf("%-15s%-15s%-15s%-15s%n","id", "name", "department", "salary");
		System.out.printf("employee with give details saved successfully, employee id: "+ employeeId);
	}
	
	public void update(Integer id, String name, String department, String salary) {
		Employee employeeUpdated = employeeService.update(id, name, department, salary);
		if(employeeUpdated==null) {
			System.out.println("Employee with given id not found to update, try again!");
			return;
		}
        System.out.printf("%-15s%-15s%-15s%-15s%n","id", "name", "department", "salary");
		System.out.printf("%-15s%-15s%-15s%-15s%n",employeeUpdated.getId(), employeeUpdated.getName(), employeeUpdated.getDepartment(), employeeUpdated.getSalary());
	}
	
	public void delete(Integer id) {
		employeeService.delete(id);
		System.out.println("employee with id: " + id + "deleted successfully");
	}
	
}
