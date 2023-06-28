package com.bookshop01.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.member.vo.MemberVO;

@Repository("adminMemberDao")
public class AdminMemberDAOImpl  implements AdminMemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException{
<<<<<<< Updated upstream:bookShop01/bookShop01/src/main/java/com/bookshop01/admin/member/dao/AdminMemberDAOImpl.java
		ArrayList<MemberVO>  memberList = (ArrayList)sqlSession.selectList("mapper.admin.member.listMember",condMap);
=======
		ArrayList<MemberVO>  memberList=(ArrayList)sqlSession.selectList("mapper.admin.member.listMember",condMap);
>>>>>>> Stashed changes:bookShop01/src/main/java/com/bookshop01/admin/member/dao/AdminMemberDAOImpl.java
		return memberList;
	}
	
	public MemberVO memberDetail(String member_id) throws DataAccessException{
		MemberVO memberBean=(MemberVO)sqlSession.selectOne("mapper.admin.member.memberDetail",member_id);
		return memberBean;
	}
	
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException{
		sqlSession.update("mapper.admin.member.modifyMemberInfo",memberMap);
	}
	
	

}
