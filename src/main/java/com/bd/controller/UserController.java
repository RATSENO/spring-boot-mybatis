package com.bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.dao.UserMapper;
import com.bd.model.common.CommonResponse;
import com.bd.model.res.UserDTO;
import com.bd.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public CommonResponse getUsers() {
		return userService.getUsers();
	}

	@GetMapping(value = "/users/{userNo}")
	public CommonResponse getUserDetail(@PathVariable(name = "userNo") Long userNo) {
		return userService.getUserDetail(userNo);
	}

	@PostMapping(value = "/user/regist")
	public CommonResponse registUser(@RequestBody UserDTO userDTO) {
		return userService.registUser(userDTO);
	}

}
