<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>board id</th>
			<th>board subject</th>
			<th>hit count</th>
			<th>user id</th>
			<th>category id</th>
		</tr>
		<c:forEach items="${boards}" var="boards">
			<tr>
<<<<<<< HEAD
				<td>${board.boradId}</td>
				<td>${board.boardSubject}</td>
				<td>${board.boardContent}</td>
				<td>${board.hitCount}</td>
				<td>${board.userId}</td>
				<td>${board.categoryId}</td>
=======
				<td>${boards.boardId}</td>
				<td>
					<a href="/ShootBoy/board/detail?boardId=${boards.boardId}">${boards.boardSubject}</a>
				</td>
				<td>${boards.hitCount}</td>
				<td>${boards.userId}</td>
				<td>${boards.categoryId}</td>
>>>>>>> 3e2354bf103bbed4f6a1adcd6b26839a7d025d37
			</tr>
		</c:forEach>
	</table>
</body>
</html>