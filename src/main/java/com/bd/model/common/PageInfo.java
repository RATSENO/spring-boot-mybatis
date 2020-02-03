package com.bd.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageInfo {

	// 현재 페이지
	private Integer page;
	// 한 페이지의 출력 건 수
	private Integer size;
	// 현재 페이지의 건 수
	private Integer resultCount;
	// 전체 건 수
	private Integer totalCount;

	@JsonIgnore
	private Integer startRowNum;
	@JsonIgnore
	private Integer endRowNum;

	public PageInfo() {
		super();
	}

	public PageInfo(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public PageInfo(int page, int size, int resultCount, int totalCount) {
		this.page = page;
		this.size = size;
		this.resultCount = resultCount;
		this.totalCount = totalCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStartRowNum() {
		return ((page - 1) * size)+1;
	}

	public Integer getEndRowNum() {
		return (page) * size;
	}

	public void setStartRowNum(Integer startRowNum) {
		this.startRowNum = startRowNum;
	}

	public void setEndRowNum(Integer endRowNum) {
		this.endRowNum = endRowNum;
	}

}
