package com.codegnan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://13.50.109.26:3000/")
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "Welcome to DoctorManagementSystem REST Application";
	}

}
