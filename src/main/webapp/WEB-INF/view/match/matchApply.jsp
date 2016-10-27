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
	
	$("#locationId").change(function() {
		$.post("/ShootBoy/checkLocation", {
			"locationId" : $("#locationId").val()
		}, function(data) {
			$("#leafCategory option").remove();
			$("#leafCategory").html(data);
		});
	});

	$("#matchBtn").click(function(){
		
		if( $("#playingField").val() == "" ) {
			alert("경기장 이름을 입력해주세요.");
			return;
		}
		
		else if ( $("#locationId").val() == "경기지역을 선택하세요" ) {
			alert("경기 지역을 선택해주세요.");
			return;
		}
		
		$("#matchForm").attr({
			"method":"post",
			"action":"/ShootBoy/doMatchApply"
		}).submit();
		
	});
	
	
});

</script>
<title>Shoot Boy</title>
</head>
<body style="width: 500px;">
	<div id="matchApplywrapper">
		<h1 style="margin-left: 150px; color: #987d2e;">매치 신청</h1>
		<form id="matchForm" name="matchForm">
		<div class="matchLocation" style="font-size: 15px; margin-left: 30px;">경기 지역 :<select id="locationId" name="locationId">
					<option>경기지역을 선택하세요</option>
					<c:forEach items="${location}" var="location">
						<option value="${location.locationId}">${location.locationName}</option>
					</c:forEach>
				</select></div>
		 <div class="matchLeafCategory" style="margin-left: 104px;"><select name="leafCategory" id="leafCategory"></select></div>
		<div class="matchPlayField" style="font-size: 15px; margin-left: 30px; margin-top: 20px;">경기장 이름 : 
			<input type="text" id="playingField" name="playingField" placeholder="경기장 이름을 입력해주세요" style="margin-left: 18px;"></div>
		<div class="matchDate" style="font-size: 15px; margin-left: 30px; 
				margin-top: 20px; width:100;">날짜 : <input type="date" id="schedule" name="schedule" style="margin-left: 70px;">
		<input type="button" id="matchBtn" value="매치등록" style="margin-left: 60px;
			background-color: #987d2e; color: #fff;">
		</div>
		</form>
	</div>
	
	
	
</body>
</html>