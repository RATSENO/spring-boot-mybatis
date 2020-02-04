package com.bd.service;

import com.bd.model.common.CommonResponse;
import com.bd.model.res.UserDTO;

public interface UserService {
	
	/* 전체 회원 목록 */
	public CommonResponse getUsers();
	
	/* 회원번호로 회원 조회 */
	public CommonResponse getUserDetail(Long userNo);
	
	/* 회원등록 */
	public CommonResponse registUser(UserDTO userDTO);
	
}
