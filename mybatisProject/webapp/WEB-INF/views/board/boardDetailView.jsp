<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>

        <table align="center" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">${ b.boardNo }</td>
            </tr>
            <tr>
                <td>제목</td>
                <td>${ b.boardTitle }</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${ b.boardWriter }</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${ b.count }</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>${ b.createDate }</td>
            </tr>
            <tr>
                <td>내용</td>
                <td height="100">
                    ${ b.boardContent }
                </td>
            </tr>
        </table>

        <br>

        <table align="center" border="1">
            <tr>
                <th width="100">댓글작성</th>
                <th width="400"><textarea name=""></textarea></th>
                <th width="100"><button>등록</button></th>
            </tr>
            <tr>
                <td colspan="3">댓글(${ list.size() })</td> <!-- fn:length(list) -->
            </tr>
           	<c:forEach var="r" items="${ list }">
	            <tr>
	                <td>${ r.replyWriter }</td>
	                <td>${ r.replyContent }</td>
	                <td>${ r.createDate }</td>
	            </tr>
            </c:forEach>
        </table>
        <c:if test="${loginMember != null &&  b.boardWriter eq loginMember.userId}">
        <div align="center">
        <button onclick="boarddelete()">삭제하기</button>
        </div>
        </c:if>
    </div>

    
		 <script>
            function boarddelete(){
                location.href='deleteboard.bo?bno=${b.boardNo}'
            }
		</script>
</body>
</html>