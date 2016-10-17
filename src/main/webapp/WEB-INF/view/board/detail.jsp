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
		$("#deleteBtn").click(function() {
			if (confirm("\"${board.boardSubject }\"를 삭제하시겠습니까?")) {
				location.href="/ShootBoy/board/doDelete?boardId=${board.boardId}";
			}
		});
		
		$(".replayDeleteBtn").click(function() {
			var replyId = $(this).data("replyid");
			if (confirm("정말로  삭제하시겠습니까?")) {
				location.href="/ShootBoy/replayDelete?replayId=" + replyId;
			}
		});
		
		$(".replayModifyBtn").click(function() {
			var modify = $(this).data("modify");
			window.open("/ShootBoy/modifyReply?replyId="+modify, "",
						"width=900, height= 600");
			
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
	${board.hitCount}
	${board.userVO.userName} 
	${board.categoryId}
	${board.createDate}
	<hr/>
	${board.boardContent} 
	

	
	<a href="/ShootBoy/board/doDownload?boardId=${board.boardId}">${board.fileName}</a>
	<br/>
	<a href="javascript:void(0);" id="deleteBtn">삭제</a> 
	<a href="/ShootBoy/board/modify?boardId=${board.boardId}">수정</a> 
	<a href="/ShootBoy/list">목록보기</a>
	<div></div>	<hr/>
	<c:forEach items="${replays}" var="replay" >
		<div></div>
			<div style="display: inline-block; width: 400px;">${replay.replayContent}</div>
			<div style="display: inline-block;">${replay.userVO.userName}</div>
			<div style="display: inline-block;">${replay.createDate}</div>
				<c:if test="${sessionScope._USER_INFO_.userId eq replay.userVO.userId}">
			<a href="javascript:void(0);" class="replayDeleteBtn" data-replyid="${replay.replayId}" style="font-size: 11px;" >삭제</a>
			<a href="javascript:void(0);" class="replayModifyBtn" data-modify="${replay.replayId}" style="font-size: 11px;" >수정</a>
			</c:if>
	</c:forEach>
	<form id="replayId">
		<input type="hidden" id="boardId" name="boardId" value="${board.boardId}" >
		<textarea id="replayContent" name="replayContent" style="width: 600px; height: 25px;" placeholder="댓글을 입력해 주세요..."></textarea>
		<input type="button" id="replayWriteBtn" name="replayWriteBtn" style="height: 25px;" value="작성하기" />
	</form>
	

</body>
</html>