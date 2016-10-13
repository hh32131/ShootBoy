<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<form id="userModifyForm" name="userModifyForm" >
				<input type="password"	id="password1" name="password" placeholder="비밀번호를 입력하세요"> <br/>
				 <input type="text"	id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력해주세요"><br/>
				<select id="age" name="age">
					<option>나이를선택해주세요</option>
					<option>10대</option>
					<option>20대</option>
					<option>30대</option>
					<option>40대</option>
					<option>50대</option>
				</select><br/>
				 <select id="position" name="position">
					<option selected="selected">포지션을 선택해주세요</option>
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
			<option>거주 지역을 선택하세요</option>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
	 	</select>
		<select name="leafCategory" id="leafCategory">
			<option> 상세 지역을 선택하세요 </option>
		</select><br/>

				<input type="button" id="signBtn" value="회원가입">
				<input type="button" id="cancelBtn" value="취소">
		</form>
	</div>
</body>
</html>