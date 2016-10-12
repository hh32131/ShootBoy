<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	moveToCenter();
});

 	function moveToCenter() {
 		
 		var windowHeight = $(window).height();
 		var wrapperHeight = $("#wrapper").height();
 		var middlePosition = (parseInt(windowHeight) / 2) 
 								- (parseInt(wrapperHeight) / 2);
 		
 		$("#wrapper").css({
 			"position": "relative"
 			, "top": middlePosition + "px"
 		});
 		};

	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "",
				"width=900, height= 600");

	}
</script>
</head>

<body>

	<button onclick="openWin()">팀생성하기</button>
	<div  id="wrapper" style="width: 700px;">
		<table>
			<c:forEach begin="1" end="5" step="1">
				<tr>
					<c:forEach items="${teams}" var="teams"  begin="0" end="4" step="1">
					
						<td align="center" class="teamtd">
							<div class="teamPhoto double">사진</div>
							<div>${teams.teamName}</div>
							<div>${teams.teamCount}</div>
					 		<div>${teams.locationVO.locationName}-${teams.locationVO.parentLocationName}</div>
						
						</td>
						
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>