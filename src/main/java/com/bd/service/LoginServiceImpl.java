package com.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.dao.UserMapper;
import com.bd.model.req.UserLoginDTO;
import com.bd.model.res.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDTO userLogin(UserLoginDTO userLoginDTO) {
		return userMapper.checkLoginUser(userLoginDTO);
	}

}
