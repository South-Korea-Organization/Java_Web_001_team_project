package com.bookshop01.goods.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.goods.vo.GoodsVO;
import com.bookshop01.goods.vo.ImageFileVO;

public interface GoodsDAO {
	// 메인에서 사용했던 검색기능(goods_status 통해 검색)
	public List<GoodsVO> selectGoodsList(String goodsStatus ) throws DataAccessException;
	
	// 일반적인 검색기능(goods_sort 통해 검색)
	public List<GoodsVO> selectGoodsList_bysort(String goodsSort ) throws DataAccessException;
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException;
	public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException;
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException;
}
