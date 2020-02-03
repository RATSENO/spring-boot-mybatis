package com.bd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.dao.UserMapper;
import com.bd.model.common.CommonHeader;
import com.bd.model.common.CommonResponse;
import com.bd.model.res.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public CommonResponse getUsers() {
		// header 영역
		CommonHeader header = new CommonHeader("200", "ok", "");

		List<UserDTO> userList = userMapper.selectUserList();

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("list", userList);

		return new CommonResponse(header, body);
	}

	@Override
	public CommonResponse getUserDetail(Long userNo) {
		// header 영역
		CommonHeader header = new CommonHeader("200", "ok", "");

		// response 영역
		UserDTO userDTO = userMapper.selectUserByUserNo(userNo);

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("value", userDTO);

		return new CommonResponse(header, body);
	}

	@Override
	public CommonResponse registUser(UserDTO userDTO) {
		return null;
	}

}
