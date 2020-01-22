package com.bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.dao.UserMapper;
import com.bd.model.UserDTO;
import com.bd.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService; 
	
	@GetMapping(value = "/users")
	public List<UserDTO> getUserList(){
		return userService.getUsers();
	}
	
	@GetMapping(value = "/users/{userNo}")
	public UserDTO getUserByUserNo(@PathVariable(name = "userNo") Long userNo) {
		return userService.getUserDetail(userNo);
	}
	
	@PostMapping(value = "/user/regist")
	public void registUser(@RequestBody UserDTO userDTO) {
		userService.registUser(userDTO);
	}
	
}
