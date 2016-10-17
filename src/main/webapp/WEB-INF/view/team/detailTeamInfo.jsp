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
		$("#passwordConfirm").hide();
		
		$("#modifyBtn").click(function(){ 
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
				
			if($("#password").val()=="${userInfo.password}"){
				location.href="/ShootBoy/teamModify";
			}
			else{
				$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>")
			}

			});
		});
	});
		
</script>
</head>
<body>
	<div id="teamDetailwrapper" >
		<c:if test="${!empty userInfo.teamId}">

		<img src="/ShootBoy/showImage?teamId=${userInfo.teamId}">
			팀명 : ${userInfo.teamVO.teamName}
			팀원수 : ${userInfo.teamVO.teamCount}
			팀 포인트 : ${userInfo.teamVO.teamPoint}
			팀 생성일 : ${userInfo.teamVO.createDate}
			팀 지역 : ${teamInfo.locationVO.parentLocationName}-${teamInfo.locationVO.locationName}
			팀 설명 : ${userInfo.teamVO.teamInfo}
		<input type="button" id="modifyBtn" name="modifyBtn" value="수정" >
		<input type="password" id="password" name="password" placeholder=" 회원 비밀번호를 입력해주세요">
		<input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인">
		<div class="warning"></div>
		</c:if>
	</div>

</body>
</html>