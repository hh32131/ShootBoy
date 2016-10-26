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
	 
	<h1>${teamBoards.teamBoardSubject}</h1>
	작성자 : ${teamBoards.getUserVO().userName} 
	날짜 : ${teamBoards.createDate}
	<div class="file-name" style="float: right;">
		<a href="/ShootBoy/doDownloadFile?teamBoards=${teamBoards.teamBoardId}">${teamBoards.fileName}</a>
	</div>
	<hr/>
	${teamBoards.teamBoardContent} 
	
	<br/>
	<div></div>	<hr/>
</body>
</html>