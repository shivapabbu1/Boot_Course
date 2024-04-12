package com.EMS.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLOYEEMANAGMENT")
public class Employee {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	  
	private String name;
	private String dept;
	private int salary;
	private String gender;
	
}
