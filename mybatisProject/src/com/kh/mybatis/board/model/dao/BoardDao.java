package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
		
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){

		//sqlSession.selectList("boardMapper.selectList");
	
		//마이바티스에서는 페이징 처리를 위해 RowBounds 라는 클래스 제공
	
		//*offset : 몇개의 게시글 건너뛰고 조회할건지에 대한 값
	
		/*
		 * ex) boardLimit :5
		 * 						offset(건너뛸 숫자) limit(조회할숫자)
		 * 
		 * currentPage : 1 1~5       0               5
		 * currentPage : 2  6        5               5
		 * currentPage : 3 11~15    10               5 
		 * */
	
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		//sqlSession.selectList("매퍼별명.쿼리아이디", 쿼리가 불완전채워줄 무언가, rowBounds)
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList",null, rowBounds);
		return  list;
				
	}
}
