package com.metacube.EADSession12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession12.model.commands.StudentCommands;

@Repository
public interface StudentCommandsRepository extends JpaRepository<StudentCommands,Long>{
	
	public List<StudentCommands> findByEmailContainingIgnoreCase(String searchString);

}
