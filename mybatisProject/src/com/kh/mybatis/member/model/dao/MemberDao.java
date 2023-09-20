package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession , Member m ) {
		/*
	       * int result = 0;
	       * PreparedStatement pstmt = null;
	       * String sql = prop.getProperty("insertMember");
	       * 
	       * try{
	       *       pstmt = conn.prepareStatement(sql);
	       *        pstmt.setString(1, m.getUserId());
	       *        pstmt.setString(2, m.getUserPwd());
	       *       .....
	       * 
	       *       result = pstmt.executeUpdate();
	       * 
	       * } catch(xxx){
	       * 
	       * } finally{
	       *     close(pstmt);
	       * }
	       * 
	       */
		
		/*
		 * sqlsession에서 제공하는 메서드를 통해서 sql문 찾아서 실행하고 바로 결과받음 
		 * 
		 * 결과 = sqlsession.sql문종류에 맞는 메서드("매퍼의별칭.sql문 고유한아이디", [그 sql문을 완성시킬 객체])
		 * 
		 * 
		 * */
		
		int result = sqlSession.insert("memberMapper.insertMember",m);
		return result; 
		
//		return sqlSession.insert("memberMapper.insertMember",m);
	}
	
	public Member loginMember(SqlSession sqlsession , Member m) {
		
		//selectOne메서드 : 조회결과가 만일 없으면 null반환
		Member loginMember = sqlsession.selectOne("memberMapper.loginMember",m);
		return loginMember;
		
	}
	

}
