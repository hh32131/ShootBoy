<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(
			function() {
				$(".imgBtn").click(
						function() {
							var teamid = $(this).data("teamid");
							window.open(
									"/ShootBoy/teamDetail?teamId=" + teamid,
									"", "width=450, height= 700");
						});

			});

	function openWin() {
		window.open("/ShootBoy/createTeam", "", "width=750, height= 600");
	}
	
</script>

<div id="allTeamLeftMenu">
	<div class="allTeamTitle">Team</div>
	<div id="allTeamLeftMenuTwo">
		<div class="allTeamOne">
			<img src="/ShootBoy/img/화살표.jpg" class="arrow"><a
				href="/ShootBoy/remove">전체 팀 보기</a>
		</div>
	</div>
</div>	

<div class="allTeamText" style="width:700px;"><h1>All TEAM</h1>
	<hr class="teamline" style="width: 680px; margin-right: 100px;">
</div>

<div id="allTeamWrapper" style="width: 700px; margin-left: 255px;">

	<table>
		<tr>
			<c:forEach items="${team}" var="team" varStatus="j" >
<<<<<<< HEAD
				<c:if test="${ j.index gt 0 && j.index % 5 eq 0 }">
=======
				<c:if test="${j.index gt 0 && j.index % 5 eq 0}">
>>>>>>> 352b9f60c86e702ecf7097492920b1121fef193a
					</tr><tr>
				</c:if>

				<td align="center" class="teamtd">
					<div class="teamPhoto double">
						<input type="hidden" class="url" name="url" value="${team.teamId}">
						<span><a href="javascript:void(0);" class="imgBtn"
							data-teamid="${team.teamId}"><img class="teamPhoto"
								src="/ShootBoy/showImage?teamId=${team.teamId}" /></a></span>
					</div>
					<div>${team.teamName}</div>
					<div>${team.teamCount}</div>
					<div>${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</div>
				</td>
			</c:forEach>
		</tr>
	</table>
	<c:if test="${empty sessionScope._USER_INFO_.teamId && !empty sessionScope._USER_INFO_}">
	<button id="teamCreateBtn" onclick="openWin()" style="margin-left: 200px; width: 300px;">팀 생성</button>
	</c:if>
			<form id="searchForm" name="searchForm" style="margin-top: 20px;">
			<div style="margin-left: 330px;">${paging}</div>
			<div style="margin-top: 20px;">
				<div class="right" style="margin-left: 20px;">
					<select id="searchType" name="searchType" style="font-size: 15px;">
						<option value="1"
							${ searchTeam.searchType eq 1 ? 'selected' : '' }>팀 이름+소개내용</option>
						<option value="2"
							${ searchTeam.searchType eq 2 ? 'selected' : '' }>팀 이름</option>
						<option value="3"
							${ searchTeam.searchType eq 3 ? 'selected' : '' }>소개내용</option>
					</select> 
						
					<input type="text" id="searchKeyword" name="searchKeyword"
						value="${searchTeam.searchKeyword}" style="font-size: 15px;"/> 
					<input type="button" id="searchBtn" value="검색" onclick="movePage(0)" style="font-size: 15px;"/> 
					<a href="/ShootBoy/team" style="font-size: 15px;"><c:remove var="_SEARCH_TEAM_INFO_" scope="session" />
					목록보기</a>
				</div>
				<div class="clear"></div>
			</div>
		</form>
</div>

<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>