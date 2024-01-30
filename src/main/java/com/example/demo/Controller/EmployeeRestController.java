package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;

	// 1. Get All Employees
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> allEmployee = service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);// 200
	}

	// 2. Get One Employee
	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id) {
		Employee e = service.getOneEmployee(id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);// 200
	}

	// 3. create one employee
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee e) {
		Integer id = service.saveEmployee(e);
		String message = "Employee   ' " + id + " '  Created !..";
		return new ResponseEntity<String>(message, HttpStatus.CREATED); // 201
	}

}
