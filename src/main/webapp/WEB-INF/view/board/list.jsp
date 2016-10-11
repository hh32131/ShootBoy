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
				<td>${boards.boardId}</td>
				<td>
					<a href="/ShootBoy/board/detail?boardId=${boards.boardId}">${boards.boardSubject}</a>
				</td>
				<td>${boards.hitCount}</td>
				<td>${boards.userId}</td>
				<td>${boards.categoryId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>