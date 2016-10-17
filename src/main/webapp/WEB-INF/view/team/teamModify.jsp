<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#locationId").on("change", function() {
			$.post("/ShootBoy/checkLocation", {
				"locationId" : $("#locationId").val()
			}, function(data) {
				$("#leafCategory option").remove();
				$("#leafCategory").html(data);
				
				var locationId = "${userInfo.temaVO.locationId}";
				if ( $("#leafCategory > option[value='"+locationId+"'").text() != "" ) {
					$("#leafCategory").val(locationId);
				}
			});
		});
		
		$("#locationId").val("${userInfo.temaVO.locationVO.parentLocationId}")
		$("#locationId").change();
		
		$("#modifyBtn").
	});
</script>
</head>
<body>
	<form id="teamModifyForm" name="teamModifyForm" enctype="multipart/form-data">
		<img src="/ShootBoy/showImge?teamId=${userInfo.temaId}">
		<input type="checkbox" id="fileDeleteBtn" name="fileDeleteBtn" value="delete" />
		<input type="file" id="file" name="file">
		팀 이름<input type="text" id ="temaName" name="teamName" value="${userInfo.teamVO.temaName}">
		팀원 수<input type="text" id = "teamCount" name="teamCount" value="${userInfo.teamVO.teamCount}">
		거주 지역 <select id="locationId" name="locationId">
					<c:forEach items="${location}" var="location">
						<option value="${location.locationId}">${location.locationName}</option>
					</c:forEach>
			</select><br/>
		상세 지역 <select name="leafCategory" id="leafCategory">
				</select>
		팀 소개<textarea id="teamInfo" name="teamInfo" style="width: 350px; height: 250px; border-radius: 10px;">${userInfo.teamVO.temaInfo}</textarea>
		<input type="button" id="modifyBtn" value="수정"> 
		<input type="button" id="cancelBtn" value="취소" onclick="location.href='/ShootBoy/detailTeamInfo'" >
		
	</form>

</body>
</html>