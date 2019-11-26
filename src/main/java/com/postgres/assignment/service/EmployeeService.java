package com.postgres.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgres.assignment.dao.EmployeeDao;
import com.postgres.assignment.model.Employee;

@Service
public class EmployeeService {

	@Autowired EmployeeDao employeeDao;
	
	
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	public void insertEmployee(Employee emp) {
	
		employeeDao.insertEmployee(emp);
	}
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
	}
	public void deleteEmployee(Integer empId) {
		
		employeeDao.deleteEmployee(empId);
	}
}
