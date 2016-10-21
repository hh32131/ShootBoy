<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include> 

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$().ready(function() {
		$("#searchType").change(function() {
			alert($("#searchType option:selected").text());
		});
	});

</script>
<body>
<div id="boardWrapper">
	<div id="myPageLeftMenu">
		<div class="mplmTitle">Community</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><c:if test="${categoryId eq 11}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=11">공지사항</a></div>
			<div class="mplmTwo"><c:if test="${categoryId eq 12}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=12">가입인사</a></div>
			<div class="mplmThree"><c:if test="${categoryId eq 13}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=13">자유게시판</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 14}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=14">국내축구소식</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 15}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=15">해외축구소식</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 16}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=16">축구동영상</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 17}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=17">축구갤러리</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 18}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=18">매치경기후기</a></div>
			<div class="mplmFour"><c:if test="${categoryId eq 19}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=19">모집게시판</a></div>
		</div>
	</div>
	<div class="boardText" style="margin-top: 20px;">
		<c:choose >
			<c:when test="${categoryId == '0'}">
				<h1>Community</h1>
			</c:when>
			<c:when test="${categoryId == '11'}">
				<h1>공지사항</h1>
			</c:when>
			<c:when test="${categoryId == '12'}">
				<h1>가입인사</h1>
			</c:when>
			<c:when test="${categoryId == '13'}">
				<h1>자유게시판</h1>
			</c:when>
			<c:when test="${categoryId == '14'}">
				<h1>국내축구소식</h1>
			</c:when>
			<c:when test="${categoryId == '15'}">
				<h1>해외축구소식</h1>
			</c:when>
			<c:when test="${categoryId == '16'}">
				<h1>축구동영상</h1>
			</c:when>
			<c:when test="${categoryId == '17'}">
				<h1>축구갤러리</h1>
			</c:when>
			<c:when test="${categoryId == '18'}">
				<h1>매치경기후기</h1>
			</c:when>
			<c:when test="${categoryId == '19'}">
				<h1>모집게시판</h1>
				</c:when>
			</c:choose>
		<hr style="border: 1px solid;"/>

		<div id="boardList">
			<table class="boardGrid">
				<tr>
					<th class="boardSubject">번호</th>
					<th class="boardSubject">제목</th>
					<th class="boardSubject">작성자</th>
					<th class="boardSubject">작성일</th>
					<th class="boardSubject">조회수</th>
				</tr>
				<c:if test="${empty boards}">
					<tr>
						<td colspan="6">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:forEach items="${boards}" var="boards">
				<div class="boardContentSum">
					<tr>
						<c:set var="number" value="${fn:split(boards.boardId,'-')[2]}"/>
                        <fmt:parseNumber var="number" type="number" value="${number}" />
<<<<<<< HEAD
                        <th class="boardContent">${number}</th>
						<th class="boardContent"><a href="/ShootBoy/board/detail?boardId=${boards.boardId} && categoryId=${categoryId}">
							${boards.boardSubject} [${boards.replayHitCount}]
						</a></th>
						<th class="boardContent">${boards.userVO.userName}</th>
						<th class="boardContent">${boards.createDate}</th>
						<th class="boardContent">${boards.hitCount}</th>
=======
                        <td>${number}</td>
						<td>
							<a href="/ShootBoy/board/detail?boardId=${boards.boardId}"> ${boards.boardSubject} [${boards.replayHitCount}] </a>
						</td>
						<td>${boards.userVO.userName}</td>
						<td>${boards.createDate}</td>
						<td>${boards.hitCount}</td>
>>>>>>> b34437332f5ad1ad4f51359766415c85008a329e
					</tr>
				</div>
				</c:forEach>
			</table>
			
			<form id="searchForm" name="searchForm">
				${paging}
				<div style="padding-top: 5px;">
					<div class="boardRight">
						<c:if test="${categoryId ne '0' and !empty sessionScope._USER_INFO_.userId
										and categoryId ne '11'}">
							<a href="/ShootBoy/write?categoryId=${categoryId}" style="color:#fff; font-size: 15px;">글쓰기</a>
						</c:if>
					</div>
					<div class="boardLeft">
						<select id="searchType" name="searchType">
							<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
							<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
							<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
							<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" value="${searchBoard.searchKeyword}"/>
						<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
						<a href="/ShootBoy/list?categoryId=${categoryId}" style="font-size: 15px;"><c:remove var="_SEARCH_BOARD_INFO_" scope="session" />목록보기</a>		
					</div>
				</div>
			</form>
		</div>	
	</div>
</div>
	
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>