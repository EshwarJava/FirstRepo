package com.tesla.employee.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tesla.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

	List<Employee> findByName(String name);

	// SELECT * FROM table WHERE address = "Hyderabad"
	List<Employee> findByAddress(String address);

	// SELECT * FROM table WHERE name LIKE "%ram%"
	List<Employee> findByNameContaining(String name, Sort sort);
}
