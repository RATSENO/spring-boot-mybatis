package com.bd.model.res;

import com.bd.model.common.res.CommonResDTO;

public class UserDTO extends CommonResDTO{
	
	private Long userNo;
	
	private String name;
	
	private String password;
	
	private String id;
	
	private String sex;
	
	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String set) {
		this.sex = set;
	}
}
