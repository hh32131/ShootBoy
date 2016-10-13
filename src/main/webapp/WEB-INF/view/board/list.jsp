<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/grid.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#searchType").change(function() {
			alert($("#searchType option:selected").text());
		});
	});
</script>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h1>Page Title</h1>
			<c:if test="${ not empty sessionScope._USER_INFO_ }">
			<div style="text-align: right;">
				${sessionScope._USER_INFO_.userName} 
				<a href="/ShootBoy/logout">로그아웃</a>
			</div>
			</c:if>
				<c:if test="${ empty sessionScope._USER_INFO_ }">
			<div style="text-align: right;" >로그인</div>
			</c:if>
			<hr/>
		</div>
		<div id="list">
			<table class="grid">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${empty boards}">
					<tr>
						<td colspan="6">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
					
				<c:forEach items="${boards}" var="boards">
					<tr>
						<c:set var="number" value="${fn:split(boards.boardId,'-')[2]}"/>
                        <fmt:parseNumber var="number" type="number" value="${number}" />
                        <td>${number}</td>
						<td><a href="/ShootBoy/board/detail?boardId=${boards.boardId}">${boards.boardSubject}[${boards.replayHitCount}]</a></td>
						<td>${boards.userVO.userName}</td>
						<td>${boards.createDate}</td>
						<td>${boards.hitCount}</td>
					</tr>
				</c:forEach>
			</table>
			
			<form id="searchForm" name="searchForm">
			${paging}
			<div style="padding-top: 5px;">
				<div class="left">
					<a href="/ShootBoy/write">글쓰기</a>
				</div>
				<div class="right">
						<select id="searchType" name="searchType">
							<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
							<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
							<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
							<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" value="${searchArticle.searchKeyword}"/>
						<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
						<a href="/ShootBoy/list/init">처음으로</a>
				</div>
				<div class="clear"></div>
			</div>
			</form>
		</div>
		<hr/>
		<div id="footer">
			<h1>Footer</h1>
		</div>
	</div>
</body>
</html>