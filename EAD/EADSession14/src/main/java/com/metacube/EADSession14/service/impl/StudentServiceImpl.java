/**
 * 
 */
package com.metacube.EADSession14.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession14.model.commands.StudentCommands;
import com.metacube.EADSession14.model.commands.User;
import com.metacube.EADSession14.repository.StudentCommandsRepository;
import com.metacube.EADSession14.repository.UserRepository;
import com.metacube.EADSession14.service.StudentService;

/**
 * This is class used to implement all the methods of StudentService interface
 * @author Vinod
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentCommandsRepository repository;
	
	@Autowired
	UserRepository userRepository;

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

	@Override
	public User findUserByName(String username) {
		
		List<User> userList = userRepository.findByUsernameContainingIgnoreCase(username);
		
		if(userList.size()==0){
			return null;
		}else{
			return userList.get(0);
		}
	}
	
	
	
}
