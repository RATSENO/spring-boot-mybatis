package com.bd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.dao.UserMapper;
import com.bd.model.res.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDTO> getUsers() {
		return userMapper.selectUserList();
	}

	@Override
	public UserDTO getUserDetail(Long userNo) {
		return userMapper.selectUserByUserNo(userNo);
	}

	@Override
	public int registUser(UserDTO userDTO) {
		return userMapper.insertUser(userDTO);
	}
	
	
	
}
