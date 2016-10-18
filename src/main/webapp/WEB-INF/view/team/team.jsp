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

<<<<<<< HEAD
							window.open(
									"/ShootBoy/teamDetail?teamId=" + teamid,
									"", "width=400, height= 400");
						});

			});
=======
	$().ready(function(){
		$(".imgBtn").click(function(){
			var teamid = $(this).data("teamid");	
				window.open("/ShootBoy/teamDetail?teamId="+ teamid,"","width=500, height= 600"); 
		});
		
	});
>>>>>>> d01a58afd7e74ba268fa15852c3e3f96f02fed97

	function openWin() {

		window.open("/ShootBoy/createTeam", "", "width=900, height= 600");
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
<div class="allTeamText">
	<h1>All TEAM</h1>
	<hr class="teamline">
</div>
<div id="allTeamWrapper" style="width: 700px; margin-left: 250px;">

	<table>
		<tr>
			<c:forEach items="${team}" var="team" varStatus="j">
				<c:if test="${ j.index gt 0 && j.index % 5 eq 0 }">
					<tr></tr>
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
					<div>${team.locationVO.parentLocationName}-${team.locationVO.locationName}</div>
				</td>
			</c:forEach>
		</tr>
	</table>
	<button id="teamCreateBtn" onclick="openWin()" style="float: right;">팀생성하기</button>
			<form id="searchForm" name="searchForm">
			${paging}
			<div style="padding-top: 5px;">
				<div class="left">
					<a href="/ShootBoy/write">글쓰기</a>
				</div>
				<div class="right">
					<select id="searchType" name="searchType">
						<option value="1"
							${ searchTeam.searchType eq 1 ? 'selected' : '' }>팀 이름+소개내용</option>
						<option value="2"
							${ searchTeam.searchType eq 2 ? 'selected' : '' }>팀 이름</option>
						<option value="3"
							${ searchTeam.searchType eq 3 ? 'selected' : '' }>소개내용</option>
					
					</select> 
						
					<input type="text" id="searchKeyword" name="searchKeyword"
						value="${searchTeam.searchKeyword}" /> <input type="button"	id="searchBtn" value="검색" onclick="movePage(0)" /> 
				</div>
				<div class="clear"></div>
			</div>
		</form>
</div>
<!-- <div class="clear">
	<div style="padding-top: 50px;"> -->

<<<<<<< HEAD
=======
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
		<c:if test="${!empty sessionScope._USER_INFO_}">
		<button id="teamCreateBtn"  onclick="openWin()" style="float: right;">팀생성하기</button>
		</c:if>
	</div>
	<div class="clear">
	<div style="padding-top: 50px;">
>>>>>>> d01a58afd7e74ba268fa15852c3e3f96f02fed97
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
