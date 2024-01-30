package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emptab")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto Increment
	@Column(name = "eid")
	private Integer empId;

	@Column(name = "ename")
	private String empName;

	@Column(name = "esal")
	private Double emSal;

	@Column(name = "edept")
	private String empDept;

	@Column(name = "ehra")
	private Double empHra;

	@Column(name = "eta")
	private Double empTa;

	public Employee(Integer empId, String empName, Double emSal, String empDept, Double empHra, Double empTa) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.emSal = emSal;
		this.empDept = empDept;
		this.empHra = empHra;
		this.empTa = empTa;
	}

	public Employee(String empName, Double emSal, String empDept, Double empHra, Double empTa) {
		super();

		this.empName = empName;
		this.emSal = emSal;
		this.empDept = empDept;
		this.empHra = empHra;
		this.empTa = empTa;
	}

	public Employee() {
		System.out.println("deft contr in Employee");
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmSal() {
		return emSal;
	}

	public void setEmSal(Double emSal) {
		this.emSal = emSal;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public Double getEmpHra() {
		return empHra;
	}

	public void setEmpHra(Double empHra) {
		this.empHra = empHra;
	}

	public Double getEmpTa() {
		return empTa;
	}

	public void setEmpTa(Double empTa) {
		this.empTa = empTa;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", emSal=" + emSal + ", empDept=" + empDept
				+ ", empHra=" + empHra + ", empTa=" + empTa + "]";
	}

}
