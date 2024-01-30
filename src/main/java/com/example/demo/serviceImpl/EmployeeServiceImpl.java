package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import com.example.demo.utility.UtilityClass;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private UtilityClass util;
	
	/**
	 * It will do calclulation of Hra , Ta and insert data into database table
	 */

	public Integer saveEmployee(Employee e) {
		util.calculateData(e);
		e = repo.save(e);
		return e.getEmpId();
	}

	/**
	 * Read id from given object if id not null and exixt in db then call update
	 * else throw exception
	 */

	public void updateEmployee(Employee e) {
//		util.calculateData(e);
//		repo.save(e);
		if (e.getEmpId() != null || repo.existsById(e.getEmpId())) {
			util.calculateData(e);
			repo.save(e);
		} else {
			throw new EmployeeNotFoundException("Employee  ' " + e.getEmpId() + " '  not exist  ");
		}

	}

	/**
	 * First check given id exist in database if exist then perform delete operation
	 * else trow exceptin
	 */
	public void deleteEmployee(Integer id) {
		// repo.deleteById(id);
		repo.delete(getOneEmployee(id));

	}

	/**
	 * If given id exist in database load object and return same else throw
	 * exception
	 */
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			throw new EmployeeNotFoundException("Employee  ' " + id + " '  not exist  ");
		// repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee '
		// " + id + " ' not exist "));
	}

	/**
	 * Fetch all row from database table
	 * 
	 */
	public List<Employee> getAllEmployee() {

		return repo.findAll();
	}

}
