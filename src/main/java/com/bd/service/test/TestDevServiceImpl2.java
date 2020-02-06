package com.bd.service.test;

import org.springframework.stereotype.Service;

@Service
public class TestDevServiceImpl2 implements TestService{

	@Override
	public String run() {
		return "dev2의 서비스입니다.";
	}

}
