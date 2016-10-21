<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="userModifyWrapper">
		<div id="userModifyHeader"><h2>회원정보 수정</h2></div>
		<form id="userModifyForm" name="userModifyForm">
			<input type="hidden" id="email" name="email" value="${userInfo.email}">
			이름 <input type="text" id="userName" name="userName" value="${userInfo.userName}" style="font-size: 15px;"> <br /><br/>
			비밀번호 <input type="text" id="password" name="password" value="${userInfo.password}" style="font-size: 15px;"> <br /><br/>
			전화번호 <input type="text" id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}" style="font-size: 15px;"><br /> <br/>
			나이 <select id="age" name="age" style="font-size: 15px;">
				<%-- <option selected="selected" >${userInfo.age}</option> --%>
				<option>10대</option>
				<option>20대</option>
				<option>30대</option>
				<option>40대</option>
				<option>50대</option>
			</select><br /> <br/>
			포지션 <select id="position" name="position" style="font-size: 15px;" >
				<%-- <option selected="selected">${userInfo.position}</option> --%>
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
			</select> <br /><br/>
			거주 지역 <select id="locationId" name="locationId" style="font-size: 15px;">
					<c:forEach items="${location}" var="location">
						<option value="${location.locationId}">${location.locationName}</option>
					</c:forEach>
			</select><br/><br/>
			상세 지역 <select name="leafCategory" id="leafCategory" style="font-size: 15px;">
					</select><br/><br/>
			<div id="btn">
				<input type="button" id="modifyBtn" value="수정"> 
				<input type="button" id="cancelBtn" value="취소" onclick="location.href='/ShootBoy/detailUserInfo'" >
			</div>
		</form>
	</div>

</body>
</html>