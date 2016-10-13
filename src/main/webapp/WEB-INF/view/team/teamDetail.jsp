<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css">
<title>Insert title here</title>
</head>
<body>
	<div>팀명 : ${team.teamName}</div> 
	<div>인원수 : ${team.teamCount} 명</div>
	<div>팀 포인트 :${team.teamPoint} 점</div>  
	<div>팀 생성일 : ${team.createDate}</div> 
	<div>팀 지역 : ${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</div>
	<div>팀 소개글 :</div>
	<div class="double">${team.teamInfo}</div> 

</body>
</html>