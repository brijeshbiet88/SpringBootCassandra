package com.cassandra.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.demo.model.Student;
import com.cassandra.demo.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getAllStudents() {
		try {
			List<Student> students = studentRepository.findAll();
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error("Error Occured :" + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getall/{registrationnumber}")
	public ResponseEntity<Student> getAllStudentsWithId(@PathVariable String registrationnumber) {
		try {
			Optional<Student> students = studentRepository.findById(registrationnumber);
			return new ResponseEntity<Student>(students.get(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error("Error Occured :" + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
