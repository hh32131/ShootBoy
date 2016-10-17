<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$().ready(function(){
		$(".imgBtn").click(function(){
			var teamid = $(this).data("teamid");
			
		window.open("/ShootBoy/teamDetail?teamId="+ teamid,"","width=400, height= 400"); 
		});
		
	});

	function openWin() {

		window.open("/ShootBoy/createTeam", "",
				"width=900, height= 600");
	}
	
</script>

<div id="allTeamLeftMenu">
		<div class="allTeamTitle">Team</div>
		<div id="allTeamLeftMenuTwo">
			<div class="allTeamOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/team">전체 팀 보기</a></div>
		</div>
	</div>
	<div class="allTeamText"><h1>All TEAM</h1>
		<hr class="teamline">
	</div>
	<div id="allTeamWrapper" style="width: 700px; margin-left: 250px;">

		<table>
			<tr>
				<c:forEach items="${team}" var="team" varStatus="j">
					<c:if test="${ j.index gt 0 && j.index % 5 eq 0 }"><tr></tr></c:if>
			
					<td align="center" class="teamtd">
						<div class="teamPhoto double">
							<input type="hidden" class="url" name="url" value="${team.teamId}" >
							<span><a href="javascript:void(0);" class="imgBtn" data-teamid="${team.teamId}"><img class="teamPhoto"	src="/ShootBoy/showImage?teamId=${team.teamId}" /></a></span>
						</div>
						<div>${team.teamName}</div>
						<div>${team.teamCount}</div>
						<div>${team.locationVO.parentLocationName}-${team.locationVO.locationName}</div>
					</td>
				</c:forEach>
			</tr>
		</table>
		<button id="teamCreateBtn"  onclick="openWin()" style="float: right;">팀생성하기</button>
	</div>
	<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>