package com.metacube.EADSession9.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession9.dao.ApplicationDAO;
import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.ProfileCommands;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND_USER = "select * from user where id = ?";
private final String SQL_DELETE_USER = "delete from user where id = ?";
private final String SQL_UPDATE_USER = "update user set name = ?, email = ?, password  = ? where id = ?";
private final String SQL_GET_ALL = "select * from user";
private final String SQL_INSERT_USER = "INSERT INTO employeedetails(name, gender,email,password, phoneNumber, organization) values(?,?,?,?,?,?)";


	@Autowired
	public ApplicationDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*@Override
	public boolean add(EmployeeCommands emp) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER,
                		new String[] { "id"}); 
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getEmail());
                ps.setString(3, emp.getPassword());
                return ps;
            }
        }, keyHolder);
		user.setId(keyHolder.getKey().intValue());	 
		return row > 0 ?true : false;
	}

	@Override
	public User get(Integer id) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { id }, new UserMapper());
	}

	@Override
	public boolean update(User user) {
		return jdbcTemplate.update(SQL_UPDATE_USER, user.getName(), user.getEmail(), user.getPassword(),
				user.getId()) > 0;
	}

	@Override
	public List<User> getAll() {
		return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
	}
*/

	@Override
	public boolean addEmployee(EmployeeCommands emp) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER); 
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getGender());
                ps.setString(3, emp.getEmail());
                ps.setString(4, emp.getPassword());
                ps.setString(5, emp.getPhoneNumber());
                ps.setString(6, emp.getOrganization());
                return ps;
            }
        });
		
		return row > 0 ?true : false;
	}

	@Override
	public ProfileCommands get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(EmployeeCommands emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeCommands> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVehicle(int empId, String name, String type,
			String vehicleNumber, String identification) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPlan(int empId, String vehicleNumber, String plan,
			double price) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
