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
</head>
<body>
<div id="boardWrapper">
	<div id="myPageLeftMenu">
		<div class="mplmTitle">Community</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="">공지사항</a></div>
			<div class="mplmTwo"><a href="">가입인사</a></div>
			<div class="mplmThree"><a href="">자유게시판</a></div>
			<div class="mplmFour"><a href="">국내축구소식</a></div>
			<div class="mplmFour"><a href="">해외축구소식</a></div>
			<div class="mplmFour"><a href="">축구동영상</a></div>
			<div class="mplmFour"><a href="">축구갤러리</a></div>
			<div class="mplmFour"><a href="">매치경기후기</a></div>
			<div class="mplmFour"><a href="">모집게시판</a></div>
		</div>
	</div>
	<div class="boardText">
			<c:choose >
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
                        <th class="boardContent">${number}</th>
						<th class="boardContent"><a href="/ShootBoy/board/detail?boardId=${boards.boardId}">
							${boards.boardSubject} [${boards.replayHitCount}]
						</a></th>
						<th class="boardContent">${boards.userVO.userName}</th>
						<th class="boardContent">${boards.createDate}</th>
						<th class="boardContent">${boards.hitCount}</th>
					</tr>
				</div>
				</c:forEach>
			</table>
			
			<form id="searchForm" name="searchForm">
			${paging}
			<div style="padding-top: 5px; ">
			<div class="boardOption">
				<div class="boardLeft">
					<c:if test="${!empty boards[0].categoryId}">
					<a href="/ShootBoy/write?categoryId=${categoryId}">글쓰기</a>
					</c:if>
				</div>
				<div class="boardRight">

					<select id="searchType" name="searchType">
						<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
						<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
						<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
						<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value="${searchBoard.searchKeyword}"/>
					<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
					<a href="/ShootBoy/list/init">처음으로</a>
			</div>
				</div>
				<div class="clear"></div>
			</div>
			</form>
		</div>
		<hr/>
		</div>
	</div>
	
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>
</body>
</html>