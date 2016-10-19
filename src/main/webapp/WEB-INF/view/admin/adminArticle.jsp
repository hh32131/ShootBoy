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
		
		$("#searchBtn").click(function() {
			var searchType = $("#searchForm > .searchType").val();
			var searchKeyword = $("#searchForm > .searchKeyword").val();
			
			$("#pagingForm > .searchType").val(searchType);
			$("#pagingForm > .searchKeyword").val(searchKeyword);
			
			movePage(0);
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
		<div class="search-tool">
			<form id="searchForm" name="searchForm">
				<select class="searchType" name="searchType">
					<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
					<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
					<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
					<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
				</select>
				<input type="text" class="searchKeyword" name="searchKeyword" value="${searchBoard.searchKeyword}"/>
				<input type="button" id="searchBtn" value="검색" />
				<a href="/ShootBoy/adminList/init">검색 초기화</a>
				<div class="clear"></div>
			</form>
		</div>
		<div class=line></div>
		<div class=notice>
			<p id="notice-text">게시물 리스트</p>
		</div>
		<div class="alldata-table">
			<table>
				<thead>
					<tr>
						<th>
							<div class="checks">
								<input type="checkbox" id="select-check">
								<label for="select-check"></label>
							</div>
						</th>
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
							<c:set var="number" value="${fn:split(boards.boardId,'-')[2]}"/>
                        	<fmt:parseNumber var="number" type="number" value="${number}" />
                        	<td>${number}</td>
							<td class="td_boardSubject"> ${boards.boardSubject} </td>	
							<td class="td_boardContent"> ${boards.boardContent} </td>
							<td class="td_userId"> ${boards.userVO.userName } </td>
							<td class="td_createDate"> ${boards.createDate} </td>
							<td class="td_hitCount"> ${boards.hitCount} </td>
							<td class="td_categoryId"> ${boards.categoryId} </td>
							<td class="td_fileName"> ${boards.fileName} </td>
						</tr>
					</tbody>	
				</c:forEach>
			</table>
			<div style="padding-top: 5px;">	
				<form id="pagingForm" name="pagingForm">
					${paging}
					<input type="hidden" class="searchType" name="searchType" value="${ searchBoard.searchType }" />
					<input type="hidden" class="searchKeyword" name="searchKeyword" value="${searchBoard.searchKeyword}" />
				</form>
			</div>
			<input type="button" id="signUpBtn" value="등록" onclick="location='adminSignUp'"/>
			<a href="/ShootBoy/adminSignUp">등록</a>
		</div>
	</div>
</body>
</html>