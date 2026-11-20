package com.nabinTech.employe_management_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private List<Employee> employeeList = new ArrayList<>();
	// method to add an employee
	//@RequestBody is needed so that the data sent from postman
	// will be accepted here
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee newEmployee){
		// add an employee to a list
		employeeList.add(newEmployee);
	}
	
	
	// method to get an employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeList;
	}
	
	// step3: Now go to the postman and create an employee
	/*
	 * Use POST http method and provide complete url which is
	 * http://localhost:8080/employee
	 * {
    "id": 1,
    "name": "Nabin",
    "department": "Software Engineer",
    "salary": 8000.67
	}
	 */
	
	//retrieve an employee with an id
	//NOTE: {id} is a pathVariable and so you must use it before
	// int id to grap an id from postman and put it as a value to id
	@GetMapping("/employee/{id}") 
	public Employee getEmployeeById(@PathVariable int id) {
		// use employeeList
		for(Employee emp: employeeList) {
			if(emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
	
	//update employee info
	@PutMapping("/employee/{id}")
	public void updateEmployee(@PathVariable int id, 
			@RequestBody Employee employeeFromPostman) {
		for(Employee emp: employeeList) {
			if(emp.getId() == employeeFromPostman.getId()) {
				emp.setName(employeeFromPostman.getName());
				emp.setDepartment(employeeFromPostman.getDepartment());
				emp.setSalary(employeeFromPostman.getSalary());
			}
		}
	}
	
	//delete an employee
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable int id){
		employeeList.removeIf(emp -> emp.getId() == id);
	}
	
	// use @RequestParam in parameter if you need to take input from the query string(url) in postman
	// http method is PUT in postman
	// In postman, for query params, key is percentage(comes from parameter with @RequestParam) and 
	// value is a number you provide
	@PutMapping("/employee/salary/{id}")
	public void incrementSalaryByPercent(@PathVariable int id,
			@RequestParam int percentage) {
		for(Employee emp: employeeList) {
			double currentSalary = emp.getSalary();
			double increment = currentSalary * percentage/100;
			emp.setSalary(currentSalary + increment);
		}
		
	}
	
	/*
	 * To take mulitple input values use @RequestBody
	 * To take one input from query string, use @RequestParam
	 * To identify a resource(like a user), use @PathVariable
	 */

}
