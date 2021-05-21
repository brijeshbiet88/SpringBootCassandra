package com.cassandra.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.demo.model.Student;
import com.cassandra.demo.repository.StudentRepository;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository; 

	@GetMapping("/getall")
	  public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String title) {
	    try {
		  List<Student> students = studentRepository.findAll();
		  return new ResponseEntity<List<Student>>(students , HttpStatus.OK);  
	    }catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	log.error("Error Occured :"+e.getMessage());
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	
}
