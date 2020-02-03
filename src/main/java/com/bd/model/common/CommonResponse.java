package com.bd.model.common;

import java.util.HashMap;
import java.util.Map;

public class CommonResponse {

	private CommonHeader header;

	private Map<String, Object> body;

	public CommonResponse() {
		super();
	}
	
	public CommonResponse(CommonHeader header, Map<String, Object> body) {
		this.header = header;
		this.body = body;
	}

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public Map<String, Object> getBody() {
		if (body == null) {
			body = new HashMap<>();
		}
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

}
