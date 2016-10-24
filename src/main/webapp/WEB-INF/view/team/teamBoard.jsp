<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">


</script>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
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
			<div style="padding-top: 5px;">
				<div class="boardLeft">
					<c:if test="${categoryId ne '0' and !empty sessionScope._USER_INFO_.userId
									and categoryId ne '11'}">
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