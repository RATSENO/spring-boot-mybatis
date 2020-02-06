package com.bd.controller.test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bd.service.test.TestService;

@RestController
public class TestController {
	
	@Resource(name = "${test.service.name}")
	private TestService testService; 
	
	@GetMapping(value = "/test")
	public String test() {
		return testService.run();
	}

}
