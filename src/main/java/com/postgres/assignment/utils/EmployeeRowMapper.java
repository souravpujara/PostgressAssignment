package com.postgres.assignment.utils;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.postgres.assignment.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setId(Integer.valueOf(rs.getInt("emp_id")));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setEmail(rs.getString("email_id"));
		return emp;
	}
}