package com.alacriti.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping	
public class SampleController {
	
	@GetMapping("/message")
	public String getStudentDetails() {
		return "I am working....";
	}
}
