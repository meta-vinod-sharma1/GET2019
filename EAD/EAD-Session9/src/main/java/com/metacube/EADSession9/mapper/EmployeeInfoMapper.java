/**
 * 
 */
package com.metacube.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADSession9.mode.commands.EmployeeInfo;

/**
 * This is mapper class with jdbc Template of EmployeeInfo class
 * @author Vinod
 *
 */
public class EmployeeInfoMapper implements RowMapper<EmployeeInfo> {
	
	
	
	@Override
	public EmployeeInfo mapRow(ResultSet result, int i) throws SQLException,EmptyResultDataAccessException {
		
		EmployeeInfo info = new EmployeeInfo();
		
		info.setEmail(result.getString("email"));
		info.setEmpId(result.getString("empId"));
		info.setPassword(result.getString("password"));
		info.setVehicleNumber(result.getString("vehicleNumber"));
		info.setImage(result.getString("name"));
		return info;
	}

}
