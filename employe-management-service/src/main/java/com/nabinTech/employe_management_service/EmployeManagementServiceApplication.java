package com.nabinTech.employe_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeManagementServiceApplication.class, args);
		System.out.println("Hello my first project");
		//System.out.println(greet());
	}

	// write a method that prints a message
	// this method runs when the application runs, but want it to be run on a client call
	// for this create another class Controller and add this method
//	public static String greet() {
//		return "Hello Spring Boot 4.2";
//	}

}
