
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#deleteBtn").click(function() {
		if (confirm("\"${teamBoards.teamBoardSubject}\"를 삭제하시겠습니까?")) {
			location.href="/ShootBoy/doDeleteTeamBoard?teamBoardId=${teamBoards.teamBoardId}";
		}
	});
	
	$("#modyBtn").click(function() {
		if (confirm("\"${teamBoards.teamBoardSubject}\"를 수정하시겠습니까?")) {
			location.href="/ShootBoy/teamBoardModify?teamBoardId=${teamBoards.teamBoardId}";
		}
	});
});
	console.log("${teamBoards.teamId}");
</script>

	<div id="listDetailWrapper">
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
	
	<div id="boardDetail">
	<div class="boardTitle">${teamBoards.teamBoardSubject} | </div>
	<div class="boardListText">
		<a href="/ShootBoy/teamBoard">팀 게시판</a>
			<div class="listUserName" style="display: inline-block; font-size: 15px;">( ${teamBoards.userVO.userName} )</div>
	</div>
	
	<div class="boardCreateDate">${teamBoards.createDate}</div>
	<hr/>
	<a href="/ShootBoy/doDownloadFile?teamBoards=${teamBoards.teamBoardId}" style="float: right;">${teamBoards.fileName}</a>
	${teamBoards.teamBoardContent}
	<br/><br/>
	<hr/>
	조회수 ${teamBoards.teamBoardRecommendCount}
		<a href="javascript:void(0);" id="deleteBtn" style="color:#000;">삭제</a> |
		<a href="/ShootBoy/teamBoardModify?teamBoardId=${teamBoards.teamBoardId}" style="color:#000;">수정 </a> 
		<input type="hidden" id="teamBoards" name="teamBoards" value="${teamBoards.teamBoardId}" />
	</div>
</div>
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>