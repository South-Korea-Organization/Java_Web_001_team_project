package com.bookshop01.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop01.goods.dao.GoodsDAO;
import com.bookshop01.goods.vo.GoodsVO;
import com.bookshop01.goods.vo.ImageFileVO;

@Service("goodsService")
@Transactional(propagation=Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO goodsDAO;
	
	// 메인페이지 검색기능(goods_status 통해 검색)
	public Map<String,List<GoodsVO>> listGoods() throws Exception {
		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
		goodsMap.put("bestseller",goodsList);
		goodsList=goodsDAO.selectGoodsList("newbook");
		goodsMap.put("newbook",goodsList);
		
		goodsList=goodsDAO.selectGoodsList("steadyseller");
		goodsMap.put("steadyseller",goodsList);
		return goodsMap;
	}
	
	// 일반적인 검색기능(goods_sort 통해 검색)
	public Map<String,List<GoodsVO>> listGoods_bysort() throws Exception {
		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
		List<GoodsVO> goodsList=goodsDAO.selectGoodsList_bysort("fruit_tree");
		goodsMap.put("fruit_tree",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("air_purifying");
		goodsMap.put("air_purifying",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("bouquet");
		goodsMap.put("bouquet",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("condolences_wreath");
		goodsMap.put("condolences_wreath",goodsList);		
		goodsList=goodsDAO.selectGoodsList_bysort("western_orchid");
		goodsMap.put("western_orchid",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("congratulatory_wreath");
		goodsMap.put("congratulatory_wreath",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("flower_box");
		goodsMap.put("flower_box",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("foliage_plant");
		goodsMap.put("foliage_plant",goodsList);		
		goodsList=goodsDAO.selectGoodsList_bysort("oriental_orchid");
		goodsMap.put("oriental_orchid",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("potted_plant");
		goodsMap.put("potted_plant",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("succulents");
		goodsMap.put("succulents",goodsList);
		goodsList=goodsDAO.selectGoodsList_bysort("ornamental_tree");
		goodsMap.put("ornamental_tree",goodsList);
		
		return goodsMap;
	}
	
	public Map goodsDetail(String _goods_id) throws Exception {
		Map goodsMap=new HashMap();
		GoodsVO goodsVO = goodsDAO.selectGoodsDetail(_goods_id);
		goodsMap.put("goodsVO", goodsVO);
		List<ImageFileVO> imageList =goodsDAO.selectGoodsDetailImage(_goods_id);
		goodsMap.put("imageList", imageList);
		return goodsMap;
	}
	
	public List<String> keywordSearch(String keyword) throws Exception {
		List<String> list=goodsDAO.selectKeywordSearch(keyword);
		return list;
	}
	
	public List<GoodsVO> searchGoods(String searchWord) throws Exception{
		List goodsList=goodsDAO.selectGoodsBySearchWord(searchWord);
		return goodsList;
	}
	
	
}
