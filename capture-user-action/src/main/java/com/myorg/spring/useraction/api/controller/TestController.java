package com.myorg.spring.useraction.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		
		return environment.getProperty("welcome.message");
	}
}
