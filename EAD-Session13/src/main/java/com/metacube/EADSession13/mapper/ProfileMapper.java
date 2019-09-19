/**
 * 
 */
package com.metacube.EADSession13.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADSession13.mode.commands.ProfileCommands;

/**
 * This class used to set ProfileCommands class member with the comming database ResultSet using RowMapper
 * @author Vinod
 *
 */
public class ProfileMapper implements RowMapper<ProfileCommands> {

	@Override
	public ProfileCommands mapRow(ResultSet resultSet, int i) throws SQLException {
		
		ProfileCommands profile = new ProfileCommands();
		
		profile.setName(resultSet.getString("name"));
		profile.setEmail(resultSet.getString("email"));
		profile.setPhoneNumber(resultSet.getString("phoneNumber"));
		profile.setVehicleNumber(resultSet.getString("vehicleNumber"));
		profile.setOrganization(resultSet.getString("organization"));
		
		return profile;
	}

}
