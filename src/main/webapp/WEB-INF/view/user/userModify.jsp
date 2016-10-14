<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#locationId").on("change", function() {
			$.post("/ShootBoy/checkLocation", {
				"locationId" : $("#locationId").val()
			}, function(data) {
				$("#leafCategory option").remove();
				$("#leafCategory").html(data);
			});
		});
		
		$("#locationId").val("${userInfo.locationVO.parentLocationId}")
		$("#locationId").change();
		
		
		$("#position").val("${userInfo.position}")
		$("#position").change();
				
		
		$("#age").val("${userInfo.age}")
		$("#age").change();
		
		$("#leafCategory").val("${userInfo.locationId}")
		$("#leafCategory").change();
		
		$("#userName").keyup(function() {
			if ($(this).val() == "") {
				alert("이름을 입력해주세요");
				return;
			} 
		});
		
		$("#password").keyup(function() {
			if ($(this).val() == "") {
				alert("비밀번호를 입력해주세요");
				return;
			} 
		});
		
		$("#phoneNumber").keyup(function() {
			if ($(this).val() == "") {
				alert("전화번호를 입력해주세요");
				return;
			} 
		});
		
		$("#modifyBtn").click(function(){
			$("#userModifyForm").attr({
				"method": "post",
				"action": "/ShootBoy/doUserModify"
			}).submit();
		});
		
		
		
	});

</script>
</head>
<body>
	<div id="wrapper">
		<form id="userModifyForm" name="userModifyForm">
			이름 <input type="text" id="userName" name="userName" value="${userInfo.userName}"> <br />
			비밀번호 <input type="text" id="password" name="password" value="${userInfo.password}"> <br />
			전화번호 <input type="text" id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}"><br /> 
			나이 <select id="age" name="age">
				<%-- <option selected="selected" >${userInfo.age}</option> --%>
				<option>10대</option>
				<option>20대</option>
				<option>30대</option>
				<option>40대</option>
				<option>50대</option>
			</select><br /> 
			포지션 <select id="position" name="position">
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
			</select> <br /> 
			거주 지역 <select id="locationId" name="locationId">
					<c:forEach items="${location}" var="location">
						<option value="${location.locationId}">${location.locationName}</option>
					</c:forEach>
			</select><br/>
			상세 지역 <select name="leafCategory" id="leafCategory">
					</select>
			<div id="btn">
				<input type="button" id="modifyBtn" value="수정"> 
				<input type="button" id="cancelBtn" value="취소" onclick="location.href='/ShootBoy/detailUserInfo'" >
			</div>
		</form>
	</div>

</body>
</html>