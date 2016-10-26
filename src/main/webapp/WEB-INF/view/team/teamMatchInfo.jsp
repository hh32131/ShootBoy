<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type='text/javascript'>

	$().ready(function() {
		
		$(".cancelBtn").click(function() {
			if(confirm("취소하시겠습니까?")) {
				var matchId = $(this).data("matchid");
				location.href="/ShootBoy/cancelMatch?matchId="+matchId;
			}
		});
	});
</script>
<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/teamInfo">팀 정보</a></div>
			<div class="mplmThree"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>팀 매치 정보</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
			<h3 style="margin-left: 250px; font-size: 25px;">매치 승인 여부</h3>
		<div id="teamMatchInfoWrapper">
			<c:forEach items="${matchs}" var="match">
			<div class="matchInfoImg">
					<img src="/ShootBoy/showImage?teamId=${match.teamVO.teamId}" style="width: 130px; height: 130px;">
			</div>
			<div class="matchInfoText">
				<div class="matchInfoTeamName">
					팀명 : ${match.teamVO.teamName}
				</div>
				<div class="matchInfoTeamLocation">
					지역 : ${match.teamVO.locationVO.parentLocationName} - ${match.teamVO.locationVO.locationName}
				</div>
				<div class="matchField">
					경기 장소 : ${match.matchVO.playField} ( ${match.matchVO.locationVO.parentLocationName} - ${match.matchVO.locationVO.locationName} )
				</div>
				<div class="matchDate">
					경기 일시 : ${match.matchVO.schedule}
				</div>
				<div>
					<input type="button" class="cancelBtn" data-matchid="${match.matchVO.matchId}" name="cancelBtn" value="취소">
				</div>
			</div>
			</c:forEach>
		</div>
		
		<hr style="width: 600px;">
		<c:forEach items="${completeMatch}" var="completeMatch">
			${completeMatch.teamVO.teamPhoto}
			${completeMatch.awayTeamVO.teamPhoto}
		</c:forEach>
	</div>

<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>