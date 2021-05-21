package com.cassandra.demo.model;

import java.util.Date;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(value="students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	@PrimaryKeyColumn(name = "registrationnumber", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String registrationNumber;

	@PrimaryKeyColumn(name = "firstname", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private String firstName;

	private String branch;

	private Date dateofbirth;

}
