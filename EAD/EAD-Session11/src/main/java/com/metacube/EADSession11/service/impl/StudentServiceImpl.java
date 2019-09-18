/**
 * 
 */
package com.metacube.EADSession11.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession11.dao.StudentDao;
import com.metacube.EADSession11.model.commands.StudentCommands;
import com.metacube.EADSession11.service.StudentService;

/**
 * This is class used to implement all the methods of StudentService interface
 * @author Vinod
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao dao;

	/* (non-Javadoc)
	 * @see com.metacube.EADSession11.service.StudentService#addStudent(com.metacube.EADSession11.model.commands.StudentCommands)
	 */
	@Override
	public boolean addStudent(StudentCommands student) {
		boolean flag = true;
		dao.addStudent(student);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession11.service.StudentService#getAll()
	 */
	@Override
	public List<StudentCommands> getAll() {
		return dao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession11.service.StudentService#getBySearch(java.lang.String, java.lang.String)
	 */
	@Override
	public StudentCommands getByEmail(String email) {
		StudentCommands student = new StudentCommands();
		student.setEmail(email);
		List<StudentCommands> list = dao.getByEmail(student);
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
