<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/grid.css" />
<title>main</title>
</head>
<body>
	<div id="schedule">
		<table class="grid">
			<tr class="One">
				<th colspan="4">최근 성사된 경기일정</th>
			</tr>
			<tr>
				<td>팀이름</td>
				<td>지역</td>
				<td>날짜</td>
				<td>시간</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>

		</table>
	<a href="<c:url value="/signIn"/>">Login</a>
	<a href="<c:url value="/list"/>">list</a>
	<a href="<c:url value="/team"/>">team</a>
	
	</div>
</body>
</html>