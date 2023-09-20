package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
		/*
		 * connection conn =jdbctemplate.getconnection();
		 * int result = new MemberDao().insertMEMBER(conn,m)
		 * 
		 * 
		 * if (result>0){
		 * 		jdbcTemplate.commit(conn);
		 * }else{
		 * 	jdbcTemplate.rollback(conn);
		 * }
		 * 
		 * jdbctemplate.close(conn)
		 * return result
		 * */
		
		SqlSession sqlSession = Template.getSqlSession();
		//이때 mybatis-config.xml 문서 읽어들임
		//등록시킨 mapper.xml 문서들도 다 읽어들여짐
		
		int result = mDao.insertMember(sqlSession,m);
		
		if(result>0){
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
	
	}

	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlsession = Template.getSqlSession();
		
		Member loginMember = mDao.loginMember(sqlsession,m);
		
		sqlsession.close();
		return loginMember;
		
		
	}

	@Override
	public int updateMember(Member m) {
		
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		
		return 0;
	}
	

}
