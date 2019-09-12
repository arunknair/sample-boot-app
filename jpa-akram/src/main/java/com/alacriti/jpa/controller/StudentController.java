package com.alacriti.jpa.controller;

import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.jpa.model.Student;
import com.alacriti.jpa.service.StudentService;

@RestController
@RequestMapping
public class StudentController {
	private static final Logger log = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping("/get_details")
	public List<Student> getStudentDetails() {
		List<Student> list = null;
		try {
			log.info("Running in the getStudentDetails(-) method");
			list = studentService.getStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@PostMapping("/add_details")
	public ResponseEntity<Student> setStudentDetails(@RequestBody Student student) {
		try {
			log.info("Running in the setStudentDetails(-) method .");
			studentService.createStudent(student);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/get_details/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id")long id) {
		Optional<Student> student = null;
		try {
			log.info("Running in the getStudentById(-) method of StudentController class.");			
			student = studentService.findById(id);
			if (student == null) {
				log.error("Id " + id + " is not existed");
				ResponseEntity.badRequest().build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
	}

	/*
	 * @PutMapping("/update_details/{id}") public ResponseEntity<Student>
	 * updateStudentDetails(@Valid @RequestBody Student student, @PathVariable("id")
	 * String empId) { try {
	 * log.info("Running in the updateStudentDetails(-,-) method ."); int id =
	 * Integer.parseInt(empId.substring(2)); studentService.updatePartially(student,
	 * id); return new ResponseEntity<Student>(student, HttpStatus.OK); } catch
	 * (Exception e) { e.printStackTrace(); } return new
	 * ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */

	@DeleteMapping("/delete_details/{id}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable("id") long id) {
		Optional<Student> message = null;
		try {
			log.info("Running in the deleteStudentDetails(-) method .");
			studentService.deleteStudentById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") long id) {
		Optional<Student> student = null;
		try {
			log.info("Running in the findStudentById(-) method .");
			log.info("Searching by ID  : " + id);
			student = studentService.findById(id);
			if (student == null) {
				log.error("Id " + id + " is not existed");
				ResponseEntity.badRequest().build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
	}

}
