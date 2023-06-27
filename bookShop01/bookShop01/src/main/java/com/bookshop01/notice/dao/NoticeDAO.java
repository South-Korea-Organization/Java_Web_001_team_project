package com.bookshop01.notice.dao;

import com.bookshop01.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	//작성
	public void write(NoticeVO vo) throws Exception;
	
	//조회
	public NoticeVO read(int n_bno) throws Exception;
	
	// 수정
	 public void update(NoticeVO vo) throws Exception;
	 
	// 삭제
	public void delete(int n_bno) throws Exception;
}
