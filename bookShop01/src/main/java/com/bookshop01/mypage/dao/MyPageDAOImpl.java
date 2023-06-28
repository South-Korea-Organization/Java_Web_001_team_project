package com.bookshop01.mypage.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.common.log.LoggingAdvice ;
import com.bookshop01.member.vo.MemberVO;
import com.bookshop01.order.vo.OrderVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	// dean
	private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException{
		List<OrderVO> orderGoodsList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderGoodsList",member_id);
		return orderGoodsList;
	}
	
	// (2023.06.19 by Dean)
	public List<OrderVO> listChangeMyOrderStatus(String member_id) throws DataAccessException{
		List<OrderVO> orderGoodsList=(List)sqlSession.selectList("mapper.mypage.listChangeMyOrderStatus",member_id);
		return orderGoodsList;
	}
	
	public List selectMyOrderInfo(String order_id) throws DataAccessException{
		
		String sql = "select * from t_shopping_order where order_id=" + order_id;
		logger.info("SQL :" + sql);
		
		List myOrderList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderInfo",order_id);
		
		logger.info("myOrderList :" + myOrderList.toString());
		return myOrderList;
	}	

	public List<OrderVO> selectMyOrderHistoryList(Map dateMap) throws DataAccessException{
		List<OrderVO> myOrderHistList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderHistoryList",dateMap);
		return myOrderHistList;
	}
	
	public void updateMyInfo(Map memberMap) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMyInfo",memberMap);
	}
	
	public MemberVO selectMyDetailInfo(String member_id) throws DataAccessException{
		MemberVO memberVO=(MemberVO)sqlSession.selectOne("mapper.mypage.selectMyDetailInfo",member_id);
		return memberVO;
		
	}
	
	public void updateMyOrderCancel(String order_id) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMyOrderCancel",order_id);
	}
	
	// 마이페이지 추가
	public void delNewMember(String member_id) throws DataAccessException{
		sqlSession.update("mapper.mypage.delNewMember",member_id);
	}
}
