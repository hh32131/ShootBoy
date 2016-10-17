<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		moveToCenter();
		$(".imgBtn").click(function(){
			var teamid = $(this).data("teamid");
			
		window.open("/ShootBoy/teamDetail?teamId="+ teamid,"","width=400, height= 400"); 
		});
		
	});

	function moveToCenter() {

		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight) / 2)
				- (parseInt(wrapperHeight) / 2);
		$("#wrapper").css({
			"position" : "relative",
			"top" : middlePosition + "px"
		});
	};

	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "",
				"width=900, height= 600");
	}
</script>
</head>

<body>

	<div id="wrapper" style="width: 700px;">
	<div><button onclick="openWin()">팀생성하기</button></div>
		<table>
			<tr>
				<c:forEach items="${team}" var="team" varStatus="j">
					<c:if test="${ j.index gt 0 && j.index % 5 eq 0 }">
						</tr><tr>
					</c:if>
					
					<td align="center" class="teamtd">
						<div class="teamPhoto double">
							<span><a href="javascript:void(0);" class="imgBtn" data-teamid="${team.teamId}"><img class="teamPhoto"	src="/ShootBoy/showImage?teamId=${team.teamId}" /></a></span>
						</div>
						<div>${team.teamName}</div>
						<div>${team.teamCount}</div>
						<div>${team.locationVO.parentLocationName}-${team.locationVO.locationName}</div>
					</td>
				</c:forEach>
			<%-- 	<c:if test="${i % 5 gt 0}">
				<c:set var="i" value=${team.size()}/>
					<c:forEach var="number" begin="1" end="${ 5 - (i % 5)}">
						<td align="center" class="teamtd"><div class="teamPhoto double">팀 없음</div>
						<div>&nbsp;</div>
						<div>&nbsp;</div>
						<div>&nbsp; </div>
						</td>
					</c:forEach>
				</c:if> --%>
			</tr>
		</table>
	</div>

</body>
</html>