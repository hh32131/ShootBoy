<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$().ready(function(){
		$("#teamJoinBtn").click(function(){
			
			$.post("/ShootBoy/doCheckTeamJoin","", function(data){
				if(data=="false"){
					if(confirm("팀에 가입하시겠습니까?")){
						location.href="/ShootBoy/teamJoin?teamId=${team.teamId}"
					}
				}
				else{
					alert("이미 가입신청을 하셨습니다.");
				}
				
			});			
			
		});
		
	});
</script>
</head>
<body>
	<div>
		<div class="teamName" style="font-size: 30px; padding-bottom:10px; margin:0 auto;
							font-weight: bold; color: #30b5ed;">${team.teamName}</div>
		<div><img class="teamPhoto" src="/ShootBoy/showImage?teamId=${team.teamId}" 
					style="width: 400px; height: 250px; padding-bottom: 10px; padding-left:15px;"/></div>
		<div style="padding-bottom: 10px;">인원수 : ${team.teamCount} 명</div>
		<div style="padding-bottom: 10px;">팀 포인트 : ${team.teamPoint} 점</div>  
		<div style="padding-bottom: 10px;">팀 생성일 : ${team.createDate}</div> 
		<div style="padding-bottom: 10px;">팀 지역 : ${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</div>
		<div style="padding-bottom: 10px;">팀 소개글 :</div>
		<div>${team.teamInfo}</div>
		<c:if test="${!empty sessionScope._USER_INFO_.userId and empty sessionScope._USER_INFO_.teamId}">
		<input type="button" id="teamJoinBtn" name="teamJoinBtn" value="팀 가입">
		<input type="hidden" id="teamId" name="teamId" value="${team.teamId}">
		</c:if>
	</div> 
</body>
</html>