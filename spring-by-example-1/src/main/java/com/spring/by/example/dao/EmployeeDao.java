package com.spring.by.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Field;
import com.spring.by.example.domain.Position;
import com.spring.by.example.domain.Role;

@Repository
public class EmployeeDao extends JdbcDaoSupport {
	
	@Resource
	public void initDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public Employee find(Long id) {		
		final Employee result = new Employee();
		getJdbcTemplate().query("select * from test_db.employee where id = ?", new Object[] { id }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				result.setId(Long.valueOf(rs.getString("id")));
				result.setFirstName(rs.getString("firstName"));
				result.setLastName(rs.getString("lastName"));
				result.setPosition(Position.valueOf(rs.getString("company_position")));
				result.setRole(Role.valueOf(rs.getString("company_role")));
				result.setField(Field.valueOf(rs.getString("field")));
			}
				});
		return result;
	}
	
	public void save(final Employee employee) {
		getJdbcTemplate().update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				String sql = "insert into test_db.employee (firstName, lastName, field, company_position, company_role) values (?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sql); 
				ps.setString(1, employee.getFirstName());
				ps.setString(2, employee.getLastName());
				ps.setString(3, employee.getField().name());
				ps.setString(4, employee.getPosition().name());
				ps.setString(5, employee.getRole().name());
				return ps;
			}
		});
	}
	
	public void update(final Employee employee) {
		getJdbcTemplate().update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				String sql = "update test_db.employee set firstName = ?, lastName = ?, field = ?, company_position = ?, company_role = ? where id = ?";
				PreparedStatement ps = conn.prepareStatement(sql); 
				ps.setString(1, employee.getFirstName());
				ps.setString(2, employee.getLastName());
				ps.setString(3, employee.getField().name());
				ps.setString(4, employee.getPosition().name());
				ps.setString(5, employee.getRole().name());
				ps.setString(6, employee.getId().toString());
				return ps;
			}
		});
	}
	
	public void delete(Long id) {
		getJdbcTemplate().execute("delete from test_db.employee where id = " + id);
	}

}
