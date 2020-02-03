package com.bd.model.req;

public class BoardUpdateDTO {

	private Long boardNo;

	private String title;

	private String content;

	private Long userNo;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

}
