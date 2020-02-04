package com.bd.service;

import com.bd.model.req.UserLoginDTO;
import com.bd.model.res.UserDTO;

public interface LoginService {
	
	public UserDTO userLogin(UserLoginDTO userLoginDTO);

}
