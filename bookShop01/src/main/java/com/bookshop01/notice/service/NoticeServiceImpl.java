package com.bookshop01.notice.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.bookshop01.notice.dao.NoticeDAO;
import com.bookshop01.notice.vo.NoticeVO;

@Component
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	private NoticeDAO dao;
	
	@Override
	public void write(NoticeVO vo) throws Exception{
		dao.write(vo);
	}
	
	@Override
	public NoticeVO read(int n_bno) throws Exception{
		return dao.read(n_bno);
	}
	
	@Override
	public void update(NoticeVO vo) throws Exception{
		dao.update(vo);
	}
	
	@Override
	public void delete(int n_bno) throws Exception{
		dao.delete(n_bno);
	}

}
