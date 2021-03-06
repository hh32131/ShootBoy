<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>	
<script type="text/javascript">
	$().ready(function() {
		$(".teamCode").click(function() {
			var teamid = $(this).data("teamid");
			window.open("/ShootBoy/teamDetail?teamId=" + teamid, "", "width=500, height= 500");
		});

		$("#deleteBtn").click(function() {
			$.post( "/ShootBoy/deleteTeamAdmin", $("#checkBoxForm").serialize(), function( data ) {
				alert( "" + data );
				location.reload();
			});
		});
				
		$("#checkAll").click(function(){
	        var chk = $(this).is(":checked");
	        if (chk) $(".check input").prop('checked', true);
		    else $(".check input").prop('checked', false);
		}); 
				 
		$("#searchBtn").click(function() {
			var searchType = $("#searchForm > .searchType").val();
			var searchKeyword = $("#searchForm > .searchKeyword").val();
			$("#pagingForm > .searchType").val(searchType);
			$("#pagingForm > .searchKeyword").val(searchKeyword);
			movePage(0);
		});
		
		 $("#modifyBtn").click(function() {
				
			 var select = $(".select-check:checked").val();
			 var checkTeam = $(".select-check:checked").length;
			 if(checkTeam  == 1  ) {
				window.open("/ShootBoy/adminTeamModify?teamId=" + select, "", "width=710, height= 800");
			 } 
			 else {
				 alert("수정할 팀을 한팀 선택해 주세요");
			 }
		});	 
		
	});
	
	function openWin() {
		window.open("/ShootBoy/adminTeamCreate", "", "width=600, height= 600");
	}
</script>
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	<div class="wrapper">
		<div class="page-title">
			팀 관리 
		</div>

		<div class="listAll">
			<c:set var="list" value="teams"/>
			<p class="textAll">전체 목록 | 총 팀수 ${count}개</p>
		</div>
		
		<div class="search-tool"> 
			<form id="searchForm" name="searchForm">
				<select class="searchType" name="searchType" id="searchType">
					<option value="1" ${ searchTeam.searchType eq 1 ? 'selected' : '' }>팀 이름+ 팀소개</option>
					<option value="2" ${ searchTeam.searchType eq 2 ? 'selected' : '' }>팀 이름</option>
					<option value="3" ${ searchTeam.searchType eq 3 ? 'selected' : '' }>팀 소개</option>
				</select>
				<input type="text" class="searchKeyword" id="searchKeyword" name="searchKeyword" value="${searchTeam.searchKeyword}" /> 
				<input type="button" id="searchBtn" value="검색"/> 
				
				<div class="clear"></div>
			</form>
		</div>
			
		<div class="line"></div>
			
		<div class="notice">
			<p id="notice-text">팀 리스트</p>
		</div>
		<div class="alldata-table">
			<table>
				<thead>
					<tr>
						<th>
							<div class="checks">
								<input type="checkbox" id="checkAll" name="checkAll" value="checkall">
								<label for="select-check"></label>
							</div>
						</th>
						<th>팀 아이디</th>
						<th>팀 명</th>
						<th>팀원수</th>
						<th>팀 엠블럼</th>
						<th>생성일자</th>
						<th>팀 포인트</th>
						<th>팀 정보</th>
						<th>지역</th>
					</tr>	
				</thead>
				<form id="checkBoxForm" name="checkBoxForm">
					<c:forEach var="team" items="${team}">
						<tbody>
							<tr>	
								<td class="td_check">
									<div class="checks check" id ="checkTeam" name="checkTeam">
										<input type="checkbox" class="select-check" data-selectid="${team.teamId}" name="select-check" value="${team.teamId}">
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_teamId">
									<c:set var="number" value="${fn:split(team.teamId,'-')[2]}" />
									<fmt:parseNumber var="number" type="number" value="${number}" />
									${number }
								</td>
								<td class="td_teamName"> 
									<input type="hidden" value="${team.teamId}">
									<span><a href="javascript:void(0);" class="teamCode" data-teamid="${team.teamId}"> ${team.teamName}</a></span>
								</td>
								<td class="td_team-memberCnt"> ${team.teamCount} </td>
								<td class="td_teamPhoto"> ${team.teamPhoto} </td>
								<td class="td_team-date"> ${team.createDate} </td>
								<td class="td_team-date"> ${team.teamPoint} </td>
								<td class="td_teamInfo"> ${team.teamInfo} </td>
								<td class="td_team-date"> ${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</td>
							</tr>
						</tbody>	
					</c:forEach>
				</form>
			</table>
			<div style="padding-top: 5px;">
				<form id="pagingForm" name="pagingForm">
					${paging}
					<input type="hidden" class="searchType" name="searchType" value="${ searchTeam.searchType }" />
					<input type="hidden" class="searchKeyword" name="searchKeyword" value="${searchTeam.searchKeyword}" />
				</form>
			</div>
			<div class="initBtn">
				<input type="button" id="initBtn" value="전체보기" onclick="location='/ShootBoy/removeTeam'"/>
			</div>
			<div class="functionBtn">
				<input type="button" id="writeBtn" value="등 록" onclick="openWin()"/>
				<input type="button" id="modifyBtn" value="선택 수정" />
				<input type="button" id="deleteBtn" value="선택 삭제" />
			</div>
		</div>		
	</div>

<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />
