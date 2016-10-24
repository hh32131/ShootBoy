<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/grid.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signUp.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/board.css">
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">
<script type="text/javascript">
$().ready(function(){
	
<<<<<<< HEAD
	<div class="myInfoText" style="width:700px;"><h1>매치 신청</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
	<div id="locationNavi">
		<ul>
		  <li><a class="active" href="#">전체</a></li>
		  <li><a href="#">서울</a></li>
		  <li><a href="#">경기</a></li>
		  <li><a href="#">강원</a></li>
		  <li><a href="#">충청</a></li>
		  <li><a href="#">전라</a></li>
		  <li><a href="#">경상</a></li>
		  <li><a href="#">제주</a></li>
		</ul>
	</div>
	</div>
=======
	$("#locationId").change(function() {
		$.post("/ShootBoy/checkLocation", {
			"locationId" : $("#locationId").val()
		}, function(data) {
			$("#leafCategory option").remove();
			$("#leafCategory").html(data);
		});
	});
>>>>>>> 75c35b8b0fe6d3b41537782094fba2607809d8e7
	
	$("#matchBtn").click(function(){
		$("#matchForm").attr({
			"method":"post",
			"action":"/ShootBoy/doMatchApply"
		}).submit();
		
	});
	
	
});

</script>
<title>Shoot Boy</title>
</head>
<body>
	<div id="wrapper">
		<form id="matchForm" name="matchForm">
		<select id="locationId" name="locationId">
			<option>경기지역을 선택하세요</option>
			<c:forEach items="${location}" var="location">
			<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
		</select><br/>
		 <select name="leafCategory" id="leafCategory">
		</select><br/>
		<input type="text" id="playingField" name="playingField" placeholder="경기장 이름을 입력해주세요"><br/>
		<input type="date" id="schedule" name="schedule">
		<input type="button" id="matchBtn" value="매치등록">
		</form>
	</div>
	
	
	
</body>
</html>