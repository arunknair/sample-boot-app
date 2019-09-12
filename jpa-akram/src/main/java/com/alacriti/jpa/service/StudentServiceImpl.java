package com.alacriti.jpa.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alacriti.jpa.dao.StudentDAO;
import com.alacriti.jpa.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private static final Logger log = LogManager.getLogger(StudentServiceImpl.class);
		
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void createStudent(Student student) {
		log.info("Running on createStudent() method in StudentServiceImpl class.");
		studentDAO.save(student);
	}

	@Override
	public List<Student> getStudent() {
		return (List<Student>) studentDAO.findAll();
	}

	@Override
	public Optional<Student> findById(long id) {
		  return studentDAO.findById(id);
	}

	@Override
	public Student updateById(Student student, long id) {
	    return studentDAO.save(student);
	}


	@Override
	public void deleteStudentById(long id) {		
		studentDAO.deleteById(id);;
	}
	
}
