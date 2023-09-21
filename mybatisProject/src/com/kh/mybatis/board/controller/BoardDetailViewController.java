package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailViewController
 */
@WebServlet("/detail.bo")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		BoardServiceImpl bService = new BoardServiceImpl();
//		BoardService bService = new BoardServiceImpl();
		// 위의 코드가 더 정석적인 맞는 코드지만 수업시간에 메소드 확인에 편의를 위해 사용X
		
		// 1. 조회수 증가시키는 서비스
		int result = bService.increaseCount(boardNo);
		
		if(result > 0) {
			// 2. 해당 게시글 상세 조회 서비스
			Board b = bService.selectBoard(boardNo);
					
			// 3. 해당 게시글 딸린 댓글 리스트 조회 서비스
			ArrayList<Reply> list = bService.selectReplyList(boardNo);
			
			request.setAttribute("b", b);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "상세조회에 실패!");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}