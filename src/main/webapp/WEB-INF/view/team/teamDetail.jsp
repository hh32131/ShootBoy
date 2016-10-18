<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<title>Insert title here</title>
</head>
<body>
	<div class="teamName" style="font-size: 30px; padding-bottom:10px; margin:0 auto;
						font-weight: bold; color: #30b5ed;">${team.teamName}</div>
	<div><img class="teamPhoto" src="/ShootBoy/showImage?teamId=${team.teamId}" 
				style="width: 400px; height: 250px; padding-bottom: 10px; padding-left:20px;"/></div>
	<div style="padding-bottom: 10px;">인원수 : ${team.teamCount} 명</div>
	<div style="padding-bottom: 10px;">팀 포인트 : ${team.teamPoint} 점</div>  
	<div style="padding-bottom: 10px;">팀 생성일 : ${team.createDate}</div> 
	<div style="padding-bottom: 10px;">팀 지역 : ${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</div>
	<div style="padding-bottom: 10px;">팀 소개글 :</div>
	<div>${team.teamInfo}</div> 
</body>
</html>