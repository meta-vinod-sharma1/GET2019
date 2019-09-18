package com.metacube.EADSession11.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession11.dao.StudentDao;
import com.metacube.EADSession11.model.commands.StudentCommands;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public void addStudent(StudentCommands student) {
		 hibernateTemplate.save(student);
	}

	@Override
	public List<StudentCommands> getAll() {
		return hibernateTemplate.loadAll(StudentCommands.class);
	}

	@Override
	public List<StudentCommands> getByEmail(StudentCommands student) {		
			return (List<StudentCommands>) hibernateTemplate.findByExample(student);		
	}
}
