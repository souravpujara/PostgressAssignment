package com.postgres.assignment.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.postgres.assignment.model.Employee;
import com.postgres.assignment.utils.EmployeeRowMapper;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	
	public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}  
	
	NamedParameterJdbcTemplate template;  
	
	@Override
	public List<Employee> findAll() {
		return template.query("select * from employee", new EmployeeRowMapper());
	}

	@Override
	public void insertEmployee(Employee emp) {

		 final String sql = "insert into employee(first_name , last_name,email_id) values(:firstName,:lastName,:emailId)";
		        KeyHolder holder = new GeneratedKeyHolder();
		        SqlParameterSource param = new MapSqlParameterSource()
		.addValue("firstName", emp.getFirstName())
		.addValue("lastName", emp.getLastName())
		.addValue("emailId", emp.getEmail());
		        template.update(sql,param, holder);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		 final String sql = "update  employee set first_name=:firstName,last_name=:lastName,email_id=:emailId where emp_id=:employeeId";
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	.addValue("employeeId", emp.getId())
	.addValue("firstName", emp.getFirstName())
	.addValue("lastName", emp.getLastName())
	.addValue("emailId", emp.getEmail());
	        template.update(sql,param, holder);
		
	}

	@Override
	public void deleteEmployee(Integer empId) {
		 final String sql = "Delete from employee where emp_id=:employeeId";

		 Map<String,Integer> map=new HashMap<String,Integer>();  
		 map.put("employeeId", empId);
	        
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	}
}
