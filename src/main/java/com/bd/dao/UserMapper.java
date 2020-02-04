package com.bd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bd.model.req.UserLoginDTO;
import com.bd.model.res.UserDTO;

@Mapper
public interface UserMapper {
	
	public UserDTO selectUserByUserNo(Long userNo);
	
	public List<UserDTO> selectUserList();
	
	public int insertUser(UserDTO userDTO);
	
	public UserDTO checkLoginUser(UserLoginDTO userLoginDTO);
	
}
