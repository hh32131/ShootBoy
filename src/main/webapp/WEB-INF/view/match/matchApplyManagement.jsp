<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">
<script type="text/javascript">
	$().ready(function(){
		$(".matchBtn").click(function(){
			if(confirm("경기를 성사하시겠습니까?")){
				var matchId = $(this).data("matchid");
				var awayTeamId = $(this).data("awayteamid");
				location.href="/ShootBoy/doMatch?matchId="+matchId+"&&awayTeamId="+awayTeamId;
			}
		});
		
	});
</script>
<body>

	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmThree"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>매치 신청 관리</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
		<c:forEach items="${matchs}" var="match">
		<div id="matchApplyManagement">
				<div class="matchApplyImg"><img class="matchApplyImg" src="/ShootBoy/showImage?teamId=${match.awayTeamId}" ></div>
				<div class="matchApplyContent">
					<div class="matchApplyTeamName">팀명 : ${match.teamVO.teamName}</div>
					<div class="matchApplyTeamCount">인원 : ${match.teamVO.teamCount}</div>
					<div class="matchApplyTeamLocation">지역 : ${match.teamVO.locationVO.locationName}-${match.teamVO.locationVO.parentLocationName}</div>
					<div class="matchApplyTeamInfo">팀 소개 : ${match.teamVO.teamInfo}</div>
					<input type="button" class="matchBtn" name="matchBtn" data-matchid="${match.matchId}" data-awayteamid="${match.awayTeamId}" value="승인" >
				</div>
		</div>
		</c:forEach>
	</div>

<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>