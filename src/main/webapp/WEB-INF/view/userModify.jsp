<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<form id="userModifyForm" name="userModifyForm" >
				<input type="password"	id="password" name="password" value="${userInfo.password}"> <br/>
				 <input type="text"	id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}"><br/>
				<select id="age" name="age">
					<option selected="selected" >${userInfo.age}</option>
					<option>10대</option>
					<option>20대</option>
					<option>30대</option>
					<option>40대</option>
					<option>50대</option>
				</select><br/>
				 <select id="position" name="position">
					<option selected="selected">${userInfo.position}</option>
					<option>골키퍼</option>
					<option>왼쪽 풀백</option>
					<option>오른쪽 풀백</option>
					<option>센터백</option>
					<option>스위퍼/리베로</option>
					<option>중앙 미드필더</option>
					<option>수비형 미드필더</option>
					<option>공격형 미드필더</option>
					<option>왼쪽 윙어</option>
					<option>오른쪽 윙어</option>
					<option>중앙 공격수</option>
					<option>세컨드 스트라이커</option>
				</select> <br/>

		<select id="locationId" name="locationId">
			<option>${userInfo.locationVO.parentLocationName}</option>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
	 	</select>
		<select name="leafCategory" id="leafCategory">
			<option> ${userInfo.locationVO.locationName} </option>
		</select><br/>
				<input type="button" id="signBtn" value="수정">
				<input type="button" id="cancelBtn" value="취소">
		</form>
	</div>
</body>
</html>