package com.bd.service.test;

import org.springframework.stereotype.Service;

@Service
public class TestDevServiceImpl implements TestService{

	@Override
	public String run() {
		return "dev의 서비스입니다.";
	}

}
