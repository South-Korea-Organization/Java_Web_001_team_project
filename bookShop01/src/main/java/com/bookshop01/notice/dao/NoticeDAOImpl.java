package com.bookshop01.notice.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.bookshop01.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

 // 마이바티스 
 @Inject
 private SqlSession sql;
 
 // 매퍼
 private static String namespace = "com.bookshop01.mybatis.mappers.notice";
  
 // 작성
 @Override
 public void write(NoticeVO vo) throws Exception {
  sql.insert(namespace + ".write", vo);
 }
 // 조회

 @Override
 public NoticeVO read(int n_bno) throws Exception {
  return sql.selectOne(namespace + ".read", n_bno);
 }

 // 수정
 @Override
 public void update(NoticeVO vo) throws Exception {
  sql.update(namespace + ".update", vo);
 }

 // 삭제
 @Override
 public void delete(int n_bno) throws Exception {
  sql.delete(namespace + ".delete", n_bno);
 }

}