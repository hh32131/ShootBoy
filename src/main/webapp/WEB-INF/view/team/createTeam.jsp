<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#locationId").change(function(){
			$.post("/ShootBoy/checkLocation",{"locationId": $("#locationId").val()}, function(data) {
				$("#leafLocation option").remove();
				$("#leafLocation").html(data); 
			});
		});
		
		$("#backBtn").click(function() {
			if (confirm("정말 취소하시겠습니까?")) {
				closeWin();
			}
		});
		
		$("#teamCreateBtn").click(function() {
			if (confirm("생성하시겠습니까?")) {
				$("#craeteTeamForm").attr({
					"method" : "post",
					"action" : "/ShootBoy/doCreateTeam"
				}).submit(); 
				
			}
		});

	});
	
	function closeWin() {
		close();
	}
</script>
</head>
<body>
	<div id="createTeamWrapper" style= "margin: 0 auto; width: 600px">
		<div class="createTeamText" style="color: #518cf0;">
		<h1>CREATE TEAM</h1></div>
		<form id="craeteTeamForm" name="createTeamForm"	enctype="multipart/form-data" >
			<div>
				<div class="inline-block" style="border-radius: 8px;">
					<input type="text"
						style=" width: 255px; height: 25px; border-radius: 8px;"
						id="teamName" name="teamName" placeholder="팀명" />
				</div>
	
				<div class="inline-block">
					<input type="text"
						style=" width: 75px; height: 30px; border-radius: 8px;"
						id="teamCount" name="teamCount" placeholder="팀원 수" />
				</div>
			</div>
		<select id="locationId" name="locationId" style="border-radius: 5px">
			<option>거주 지역을 선택하세요</option>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
	 	</select>
		<select name="leafLocation" id="leafLocation" style="border-radius: 5px">
			<option> 상세 지역을 선택하세요 </option>
		</select>
			<div style="height: 8px;"></div>
			<div>
				<textarea id="teamInfo" name="teamInfo"
					style="width: 350px; height: 250px; border-radius: 10px; font-size: 15px;"
					placeholder="소개글을 입력하세요."></textarea>
			</div>
			<input type="file" id="file" name="file" style="width: 220px; back" /> 
			<input type="button" id="teamCreateBtn" name="teamCreateBtn" value="팀 생성"/>			  
			<input type="button" id="backBtn" name="backBtn" value="취소"/>
		</form>
	</div>
</body>
</html>