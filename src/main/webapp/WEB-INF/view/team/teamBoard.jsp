
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$().ready(function () {
	$("#writeBtn").click(function () {
		location.href="/ShootBoy/teamBoardWrite?teamId=${teamId}";
	
	});
});

</script>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/teamBoard">팀 게시판</a></div>
			
		</div>
	</div>
	<div class="boardText">
	<div id="boardList">
			<table class="boardGrid">
				<tr>
					<th class="boardSubject">번호</th>
					<th class="boardSubject">제목</th>
					<th class="boardSubject">작성자</th>
					<th class="boardSubject">작성일</th>
					<th class="boardSubject">조회수</th>
				</tr>
				<c:if test="${empty teamBoards}">
					<tr>
						<td colspan="6">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:forEach items="${teamBoards}" var="teamBoards">
				<div class="boardContentSum">
					<tr>
						<c:set var="number" value="${fn:split(teamBoards.teamBoardId,'-')[2]}"/>
                        <fmt:parseNumber var="number" type="number" value="${number}" />
                        <th class="boardContent">${number}</th>
						<th class="boardContent"><a href="/ShootBoy/detailTeamBoard?teamBoardId=${teamBoards.teamBoardId}">
							<span id ="teamBoardId" name = teamBoardId">${teamBoards.teamBoardSubject}</span> [${teamBoards.replayHitCount}]
						</a></th>
						<th class="boardContent">${teamBoards.userVO.userName}</th>
						<th class="boardContent">${teamBoards.createDate}</th>
						<th class="boardContent">${teamBoards.teamBoardRecommendCount}</th>
					</tr>
				</div>
				</c:forEach>
			</table>
			
			<form id="searchForm" name="searchForm">
			${paging} <br/>
			<input type="hidden" id="teamId" name="teamId" value="${teamId}" />
			<input type="button" id="writeBtn" name="writeBtn" value="글쓰기" />
			
			<div style="padding-top: 5px;">
				
				<div class="boardRight">

					<select id="searchType" name="searchType">
						<option value="1" ${ searchTeam.searchType eq 1 ? 'selected' : '' }>제목/작성자</option>
						<option value="2" ${ searchTeam.searchType eq 2 ? 'selected' : '' }>제목</option>
						<option value="3" ${ searchTeam.searchType eq 3 ? 'selected' : '' }>작성자</option>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value="${searchTeam.searchKeyword}"/>
					<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
					<a href="/ShootBoy/list/init">처음으로</a>
				</div>
			</div>
			</form>
			</div>
				<div class="clear"></div>
			</div>
		<hr/>
	
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>