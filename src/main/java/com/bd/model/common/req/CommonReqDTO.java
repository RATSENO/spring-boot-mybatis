package com.bd.model.common.req;

import com.bd.model.common.PageInfo;

public class CommonReqDTO {

	// 현재 페이지
	private Integer page;
	// 한 페이지의 출력 건 수
	private Integer size;
	// 현재 페이지의 건 수
	private Integer resultCount;
	// 전체 건 수
	private Integer totalCount;

	private PageInfo pageInfo;

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

	public PageInfo getPageInfo() {
    	if(page != null && size != null && pageInfo == null) {
    		pageInfo = new PageInfo(page, size);
    	}
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

}
