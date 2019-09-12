package com.alacriti.jpa.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alacriti.jpa.model.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Long> {

}
