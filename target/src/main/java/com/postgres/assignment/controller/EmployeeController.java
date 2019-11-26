package com.postgres.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.assignment.model.Employee;
import com.postgres.assignment.service.EmployeeService;

@RestController
@RequestMapping("/postgres")
public class EmployeeController {

	
	@Autowired EmployeeService employeeService;
	
	@GetMapping(value = "/")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}
	
	@PostMapping(value = "/createEmp")
	public void createEmployee(@RequestBody Employee emp) {
		employeeService.insertEmployee(emp);
	}
	
	@PutMapping(value = "/updateEmp")
	public void updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
	}
	
	
	@DeleteMapping(value = "/deleteEmpById/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
	 	employeeService.deleteEmployee(id);
	}
	
}
