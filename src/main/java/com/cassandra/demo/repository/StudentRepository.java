package com.cassandra.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.cassandra.demo.model.Student;

@Repository
public interface StudentRepository extends CassandraRepository<Student , String>{

}
