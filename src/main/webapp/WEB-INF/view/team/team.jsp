<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$().ready(function(){
		$(".imgBtn").click(function(){
			window.open("/ShootBoy/teamDetail?teamId="+$(".url").val(),"","width=400, height= 400");
		});	
	});

	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "",
				"width=500px, height= 600");
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
				<c:forEach items="${teams}" var="teams" varStatus="j">
					<c:if test="${ j.index gt 0 && j.index % 5 eq 0 }"><tr></tr></c:if>
			
					<td align="center" class="teamtd">
						<div class="teamPhoto double">
							<input type="hidden" class="url" name="url" value="${teams.teamId}" >
							<span><a href="javascript:void(0);" class="imgBtn"><img class="teamPhoto" src="/ShootBoy/showImage?teamId=${teams.teamId}" /></a></span>
						</div>
						<div>${teams.teamName}</div>
						<div>${teams.teamCount}</div>
						<div>${teams.locationVO.parentLocationName}-${teams.locationVO.locationName}</div>
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
		<button id="teamCreateBtn"  onclick="openWin()" style="float: right;">팀생성하기</button>
	</div>
	<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>