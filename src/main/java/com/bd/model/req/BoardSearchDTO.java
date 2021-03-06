package com.bd.model.req;

import com.bd.model.common.req.CommonReqDTO;

public class BoardSearchDTO extends CommonReqDTO{

	private Long boardNo;

	private String title;
	
	private String userId;

	public Long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
