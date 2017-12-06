package com.san.model;

public class Page {
	private int pageCount;		//总页数
	private int recordNumber;   //总记录数
	private int pageSize;		//每页记录数
	private int pageNow;		//当前页
	public int getPageCount() {
		return recordNumber%pageSize==0? recordNumber/pageSize : recordNumber/pageSize+1;
	}
	public int getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
}
