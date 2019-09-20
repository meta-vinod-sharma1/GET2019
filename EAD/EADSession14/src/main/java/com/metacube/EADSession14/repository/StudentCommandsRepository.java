package com.metacube.EADSession14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession14.model.commands.StudentCommands;

/**
 * This interface used to retrive data from database using JpaRepository 
 * @author Vinod
 *
 */
@Repository
public interface StudentCommandsRepository extends JpaRepository<StudentCommands,Long>{
	
	/**
	 * This method used to get Students which contains email similar searchString parameter
	 * @param searchString
	 * @return list of StudentCommands objects
	 */
	public List<StudentCommands> findByEmailContainingIgnoreCase(String searchString);

}
