package com.nabinTech.employe_management_service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello Spring Boot 4.2";
	}
}
