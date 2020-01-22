package com.bd.service;

import java.util.List;

import com.bd.model.UserDTO;

public interface UserService {
	
	/* 전체 회원 목록 */
	public List<UserDTO> getUsers();
	
	/* 회원번호로 회원 조회 */
	public UserDTO getUserDetail(Long userNo);
	
	/* 회원등록 */
	public int registUser(UserDTO userDTO);

}
