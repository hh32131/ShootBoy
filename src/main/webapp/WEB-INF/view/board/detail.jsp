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
	});
</script>
</head>
<body>
	
	${board.boardId} 
	${board.boardSubject}
	${board.boardContent} 	
	${board.hitCount} 
	${board.userId} 
	${board.categoryId}
	${board.createDate}
	
	
	<a href="javascript:void(0);" id="deleteBtn">삭제</a> 
	<a href="/ShootBoy/board/modify?boardId=${board.boardId}">수정</a> 
	<a href="/ShootBoy/list">목록보기</a>

</body>
</html>