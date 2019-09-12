package com.alacriti.jpa.service;

import java.util.List;
import java.util.Optional;

import com.alacriti.jpa.model.Student;

public interface StudentService {
	public void createStudent(Student user);
    public List<Student> getStudent();
    public Optional<Student> findById(long id);
    public Student updateById(Student user, long l);
    public void deleteStudentById(long id);
}
