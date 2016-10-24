<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">


<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#locationId").on("change", function() {
			$.post("/ShootBoy/checkLocation", {
				"locationId" : $("#locationId").val()
			}, function(data) {
				$("#leafCategory option").remove();
				$("#leafCategory").html(data);
				
				var locationId = "${teamInfo.locationId}";
				if ( $("#leafCategory > option[value='"+locationId+"'").text() != "" ) {
					$("#leafCategory").val(locationId);
				}
			});
		});
		
		$("#locationId").val("${teamInfo.locationVO.parentLocationId}")
		$("#locationId").change();
		
		$("#modifyBtn").click(function(){
			$("#teamModifyForm").attr({
				"method": "post",
				"action": "/ShootBoy/doModifyTeamInfo"
			}).submit();
		});
	});
</script>
</head>
<body>
	<div id="teamModifyText" style="margin-left: 250px; color: #30b5ed; font-size: 30px;"><h1>팀 정보 수정</h1></div>
		<div id="teamModifyWrapper" style="width: 800px; padding: 40px;">
			<form id="teamModifyForm" name="teamModifyForm" enctype="multipart/form-data">
			<div id="teamModiryLeft" style="display: inline-block; vertical-align: top;">
				<img src="/ShootBoy/showImage?teamId=${teamInfo.teamId}" width="300px" style="border-radius: 50px;">
				<div class="teamPhoto" style="font-size: 15px; width: 150px; margin-left: 120px; padding-top: 10px;">팀 앰블럼</div>
				<div><input type="checkbox" id="fileDeleteBtn" name="fileDeleteBtn" value="delete" style="margin-top: 30px;" /></div>
				<input type="file" id="file" name="file" style="margin-top: 20px;">
			</div>
				<input type="hidden" id="teamId" name="teamId" value="${teamInfo.teamId}" >
				<input type="hidden" id="email" name="email" value="${userInfo.email}" >
			<div id="teamModifyRight" style="display: inline-block; margin-left: 50px; width: 300px;">
				<div class="teamName" style="margin-bottom: 20px; font-size: 20px;">팀 이름  <input type="text" id ="temaName" name="teamName" value="${teamInfo.teamName}"></div>
				<div class="teamCount" style="margin-bottom: 20px; font-size: 20px;">팀원 수 <input type="text" id = "teamCount" name="teamCount" value="${teamInfo.teamCount}"></div>
				<div class="teamLocation" style="margin-bottom: 20px; font-size: 20px;">거주 지역 <select id="locationId" name="locationId">
							<c:forEach items="${location}" var="location">
								<option value="${location.locationId}">${location.locationName}</option>
							</c:forEach>
					</select></div>
				<div class="teamDetailLocation" style="margin-bottom: 20px; font-size: 20px;">상세 지역 
					<select name="leafCategory" id="leafCategory"></select>
				</div>
				<div class="teamIntroduce" style="vertical-align: top; font-size: 20px;">팀 소개</div><textarea id="teamInfo" name="teamInfo" style="width: 250px; height: 200px; border-radius: 10px;">${teamInfo.teamInfo}</textarea>
				<input type="button" id="modifyBtn" value="수정" style="float: right; margin-left: 20px;"> 
			</div>
			</form>
	</div>
</body>
</html>