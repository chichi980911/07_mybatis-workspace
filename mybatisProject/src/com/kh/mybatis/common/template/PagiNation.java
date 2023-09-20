package com.kh.mybatis.common.template;

import com.kh.mybatis.common.model.vo.PageInfo;

public class PagiNation {
	public static PageInfo getPageInfo(int listCount ,int currentPage , int pageLimit, int boardLimit){
		int maxPage  = (int)Math.ceil((double)listCount / boardLimit);  //가장 마지막페이지 (총 페이지 수)
		int startPage = (currentPage -1) / pageLimit * pageLimit +1;
		int endPage = startPage + pageLimit -1;  //페이징 바의 끝수
		 
		
//		startPage가 11이면 endPage 20으로 됨(근데 maxPage가 고작 13밖에 안되면)
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		return pi;
		
	}
}
