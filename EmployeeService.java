package com.tesla.employee.service;

import java.util.List;
import java.util.Optional;

import com.tesla.employee.entity.Employee;

public interface EmployeeService {

	public Optional<Employee> getEmployee(int id);

	public void deleteEmployee(int id);

	public Employee addEmployee(Employee employee);

	public List<Employee> getallEmployee(int pageNumber, int pageSize);

	public Employee updateEmployee(Employee employee);

	public List<Employee> getEmployeesByName(String name);

	public List<Employee> getEmployeesByAddress(String address);
	
	public List<Employee> getEmployeesByKeyword(String name);

}
