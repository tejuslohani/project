package com.example.demo.utility;

import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class UtilityClass {
	public void calculateData(Employee e) {
		double sal = e.getEmpSal();
		double hra = sal * 20 / 100.0;
		double ta = sal * 12 / 100.0;
		e.setEmpHra(hra);
		e.setEmpTa(ta);
	}

}
