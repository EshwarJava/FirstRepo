package com.tesla.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesla.employee.entity.Employee;
import com.tesla.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Employee> getEmployee(@PathVariable int id) throws Exception {

		Optional<Employee> employee = eService.getEmployee(id);

		if (employee.isPresent()) {
			return employee;
		} else {
			throw new Exception("Record not found");
		}

	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<Employee>> getallEmployee(@RequestParam int pageNumber, @RequestParam int pageSize) {

		
		return new ResponseEntity<List<Employee>>(eService.getallEmployee(pageNumber,pageSize),HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") int id) {

		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

	}

	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

		return new ResponseEntity<Employee>(eService.addEmployee(employee), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);

	}
	
	@GetMapping("/filterbyname")
	public ResponseEntity<List<Employee>> FindByName(@RequestParam String name)
	{
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
	}
	
	

	@GetMapping("/filterbyaddress")
	public ResponseEntity<List<Employee>> FindByAddress(@RequestParam String address)
	{
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByAddress(address), HttpStatus.OK);
	}
	
	@GetMapping("/filterbykeyword")
	public ResponseEntity<List<Employee>> FindByKeyword(@RequestParam String name)
	{
		
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
	}

}