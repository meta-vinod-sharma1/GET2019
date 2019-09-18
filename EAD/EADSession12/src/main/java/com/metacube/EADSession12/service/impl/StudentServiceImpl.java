/**
 * 
 */
package com.metacube.EADSession12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession12.model.commands.StudentCommands;
import com.metacube.EADSession12.repository.StudentCommandsRepository;
import com.metacube.EADSession12.service.StudentService;

/**
 * This is class used to implement all the methods of StudentService interface
 * @author Vinod
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentCommandsRepository repository;

	@Override
	public boolean addStudent(StudentCommands student) {
		repository.save(student);
		return true;
	}

	@Override
	public List<StudentCommands> getAll() {
		
		return repository.findAll();
	}

	@Override
	public StudentCommands getByEmail(String email) {
		List<StudentCommands> list = repository.findByEmailContainingIgnoreCase(email);
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean isEmailExist(String email) {
		if(getByEmail(email)==null){
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
