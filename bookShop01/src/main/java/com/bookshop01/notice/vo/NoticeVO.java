package com.bookshop01.notice.vo;

import java.util.Date;

public class NoticeVO {
	
	/*
	  bno		number				not null,
	  title		varchar2(30)		not null,
	  content	varchar2(200)		not null,
	  writer	varchar2(300)		not null,
	  regDate	date				default sysdate,
	  viewCnt	number				default 0,	  
	 */
	
	private int n_bno;
	private String n_title;
	private String n_content;
	private String n_writer;
	private Date n_regDate;
	private int n_viewCnt;
	public int getN_bno() {
		return n_bno;
	}
	public void setN_bno(int n_bno) {
		this.n_bno = n_bno;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_writer() {
		return n_writer;
	}
	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}
	public Date getN_regDate() {
		return n_regDate;
	}
	public void setN_regDate(Date n_regDate) {
		this.n_regDate = n_regDate;
	}
	public int getN_viewCnt() {
		return n_viewCnt;
	}
	public void setN_viewCnt(int n_viewCnt) {
		this.n_viewCnt = n_viewCnt;
	}

}
