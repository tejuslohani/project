package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee e);

	void updateEmployee(Employee e);

	void deleteEmployee(Integer id);

	Employee getOneEmployee(Integer id);

	List<Employee> getAllEmployee();

}
