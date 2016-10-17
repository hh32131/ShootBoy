<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" >
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#password").hide();
		
		$("#modifyBtn").click(function(){
			$("#password").show();
			
			if($("#password").val()==${userInfo.password}){
				location.href="/ShootBoy/userModify";
			}
			else{
			$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>").slideDown();
			}
			
		});
	});
</script>
</head>
<body>
	<div id="wrapper" >
		이름 : ${userInfo.userName}
		전화번호 : ${userInfo.phoneNumber}
		나이 : ${userInfo.age}
		포지션 : ${userInfo.position}
		가입일: ${userInfo.createDate}
		지역 : ${userInfo.locationVO.parentLocationName}-${userInfo.locationVO.locationName}
		<c:if test="${!empty userInfo.teamId}">
		팀 : ${userInfo.teamVO.teamName}
		</c:if>
		<input type="button" id="modifyBtn" name="modifyBtn" value="수정" >
		<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
		<div class="warning"></div>
	</div>
	

</body>
</html>