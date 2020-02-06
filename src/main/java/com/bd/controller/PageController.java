package com.bd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

	@GetMapping("/")
	public String depth() {
		return "login";
	}
	
	@GetMapping("/{depth1}")
	public String depth1(@PathVariable(name = "depth1")String depth1) {
		return depth1;
	}
	
	@GetMapping("/{depth1}/{depth2}")
	public String depth2(@PathVariable(name = "depth1")String depth1,
						 @PathVariable(name = "depth2")String depth2) {
		return depth1 + "/" + depth2;
	}
	
	@GetMapping("/{depth1}/{depth2}/*")
	public String error() {
		return "error";
	}
	
	
}
