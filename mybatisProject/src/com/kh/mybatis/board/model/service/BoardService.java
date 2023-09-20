package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	/*
	 * 게시판 리스트조회
	 * public int selectListCount(){}
	 * 
	 * public ArrayList<board> selectList(PageInfo pi){
	 * }
	 *
	 * 게시판 상세조회
	 * public int increase count(int boardNOo){}
	 * */
	
	int selectListcount();
	
	ArrayList<Board> selectList(PageInfo pi);
	
	int increaseCount(int boardNo);
	
	Board selectBoard(int boardNo);

}
