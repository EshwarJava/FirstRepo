package com.tesla.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tesla.employee.entity.Employee;
import com.tesla.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public Optional<Employee> getEmployee(int id) {

		return eRepository.findById(id);
	}

	@Override
	public void deleteEmployee(int id) {

		eRepository.deleteById(id);
	}

	@Override
	public Employee addEmployee(Employee employee) {

		return eRepository.save(employee);

	}

	@Override
	public List<Employee> getallEmployee(int pageNumber, int pageSize) {

		Pageable pages = PageRequest.of(pageNumber, pageSize);
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return eRepository.save(employee);

	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByAddress(String address) {
		// TODO Auto-generated method stub
		return eRepository.findByAddress(address);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return eRepository.findByNameContaining(name,sort);
	}

}
