/**
 * 
 */
package com.metacube.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * @author Vinod
 *
 */
public class FriendsExtractor implements ResultSetExtractor<List<String>> {

	@Override
	public List<String> extractData(ResultSet result) throws SQLException,
			DataAccessException {
		List<String> friends = new ArrayList<String>();
		
		
		while(result.next()){
			friends.add(result.getString("email"));
		}
		return friends;
	}

}
