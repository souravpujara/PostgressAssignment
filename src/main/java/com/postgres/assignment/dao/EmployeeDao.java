package com.postgres.assignment.dao;

import java.util.List;

import com.postgres.assignment.model.Employee;

public interface EmployeeDao {


	List<Employee> findAll();
	void insertEmployee(Employee emp);
	void updateEmployee(Employee emp);
	public void deleteEmployee(Integer empId);
}

