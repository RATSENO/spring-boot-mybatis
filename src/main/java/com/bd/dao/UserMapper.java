package com.bd.dao;

import java.util.List;

import com.bd.model.UserDTO;

public interface UserMapper {
	public UserDTO selectUserByUserNo(Long userNo);
	public List<UserDTO> selectUserList();
	public int insertUser(UserDTO userDTO);
}
