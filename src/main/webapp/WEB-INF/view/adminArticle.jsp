<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#searchType").change(function() {
			alert($("#searchType option:selected").text());
		});
	});
</script>
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			게시판 관리 
		</div>
		<div class="listAll">
				<p class="textAll">전체 목록 | 총 경기수 00개</p>
		</div>
			<div class="container">
				<div class=line></div>
				<div class=notice>
					<p id="notice-text">게시물 리스트</p>
				</div>
				<div class="alldata-table">
					<table>
						<thead>
							<tr>
								<th></th>
								<th>게시물 아이디</th>
								<th>제 목</th>
								<th>내 용</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>카테고리</th>
								<th>첨부파일</th>
							</tr>	
						</thead>
						<c:forEach var="boards" items="${boards}">
							<tbody>
								<tr>
									<td>
										<div class="checks">
											<input type="checkbox" id="select-check">
											<label for="select-check"></label>
										</div>
									</td>
									<td class="td_boardId"> ${boards.boardId} </td>	
									<td class="td_boardSubject"> ${boards.boardSubject} </td>	
									<td class="td_boardContent"> ${boards.boardContent} </td>
									<td class="td_userId"> ${boards.userId } </td>
									<td class="td_createDate"> ${boards.createDate} </td>
									<td class="td_hitCount"> ${boards.hitCount} </td>
									<td class="td_categoryId"> 이름 </td>
									<td class="td_fileName"> ${boards.fileName} </td>
								</tr>
							</tbody>	
						</c:forEach>
					</table>
				<form id="searchForm" name="searchForm">
					${paging}
					<div style="padding-top: 5px;">
					<select id="searchType" name="searchType">
						<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
						<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
						<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
						<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value="${searchBoard.searchKeyword}"/>
					<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
					<a href="/ShootBoy/adminList/init">처음으로</a>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>