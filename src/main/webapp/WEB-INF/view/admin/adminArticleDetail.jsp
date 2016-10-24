<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".replayDeleteBtn").click(function() {
			var replyId = $(this).data("replyid");
			if (confirm("정말로  삭제하시겠습니까?")) {
				location.href="/ShootBoy/replayDelete?replayId=" + replyId+ "&&boardId="+${board.boardId};
			}
		});
		
		$("#replayWriteBtn").click(function () {
			$("#replayId").attr({
				"mothod":	"post",
				"action":	"/ShootBoy/replayList"
			}).submit();
		})
	});
</script>
</head>
<body>
	 
	<h1>${board.boardSubject}</h1>
	조회수 : ${board.hitCount}
	작성자 : ${board.getUserVO().userName} 
	카테고리 : ${board.categoryId}
	날짜 : ${board.createDate}
	<div class="file-name" style="float: right;">
		<a href="/ShootBoy/board/doDownload?boardId=${board.boardId}">${board.fileName}</a>
	</div>
	<hr/>
	${board.boardContent} 
	
	<br/>
	<div></div>	<hr/>
		<c:forEach items="${replays}" var="replay" >
			<div></div>
			<div style="display: inline-block; width: 400px;">${replay.replayContent}</div>
			<div style="display: inline-block;">${replay.userVO.userName}</div>
			<div style="display: inline-block;">${replay.createDate}</div>
			<c:if test="${sessionScope._USER_INFO_.userId eq replay.userVO.userId}">
				<a href="javascript:void(0);" class="replayDeleteBtn" data-replyid="${replay.replayId}" style="font-size: 11px;" >삭제</a>
			</c:if>
		</c:forEach>
</body>
</html>