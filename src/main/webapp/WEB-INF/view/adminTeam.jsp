<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>	
<script type="text/javascript">
	$().ready(function() {
				$(".teamCode").click(
						function() {
							var teamid = $(this).data("teamid");
							window.open(
									"/ShootBoy/teamDetail?teamId=" + teamid,
									"", "width=500, height= 500");
				});

				$("#teamDeleteBtn").click(
						function() {
						$.post( "/ShootBoy/deleteTeamAdmin", $("#searchForm").serialize(), function( data ) {
						alert( "" + data );
						location.reload();
						});
				});
				
				 $("#checkAll").click(function(){
				        //클릭되었으면
				        var chk = $(this).is(":checked");
				        if (chk) $(".check input").prop('checked', true);
				            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
				            //클릭이 안되있으면
				        else
				            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
				        	 $(".check input").prop('checked', false);
				        
				}); 
				 
				$("#teamModifyBtn").click(function() {
					
							 $.post( "/ShootBoy/adminTeamModify", $("#searchForm").serialize(),function(data){
								
							}); 
				});		
				 
	});
	function openWin() {

		window.open("/ShootBoy/createTeam", "", "width=900, height= 600");
	}
</script>
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	<div class="wrapper">
		<div class="page-title">
			팀 관리 
		</div>

		<div class="listAll">
				<a class="textAll">전체 목록 | 총 팀수 00개</a>
		</div>
		<form id="searchForm" name="searchForm">
		<div class="container">
			<div class="search-tool"> 
				<div id="search-select" name="search-select">
					<select id="searchType" name="searchType">
						<option value="1" ${ searchTeam.searchType eq 1 ? 'selected' : '' }>팀 이름+ 팀소개</option>
						<option value="2" ${ searchTeam.searchType eq 2 ? 'selected' : '' }>팀 이름</option>
						<option value="3" ${ searchTeam.searchType eq 3 ? 'selected' : '' }>팀 소개</option>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value="${searchTeam.searchKeyword}" /> 
					<input type="button" id="sbtn" value="검색" onclick="movePage(0)" /> 
					<input type="button" id="makeTeamBtn" value="생성" onclick="openWin()"/>
					<input type="button" id="teamModifyBtn" value="수정" />
					<input type="button" id="teamDeleteBtn" value="삭제" />
				</div>
			</div>
		
			<div class=line>
			</div>
			
			<div class=notice>
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
					<c:forEach var="team" items="${team}">
						<tbody>
							<tr>	
								<td class="td_check">
									<div class="checks check" id = "checkTeam" name= "checkTeam">
										
										<input type="checkbox" id="select-check" name="select-check" value="${team.teamId}">
										
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_teamId">
								<input type="hidden" value="${team.teamId}">
								<span><a href="javascript:void(0);" class="teamCode" data-teamid="${team.teamId}"> ${team.teamId }</a></span></td>
								<td class="td_teamName"> ${team.teamName} </td>
								<td class="td_team-memberCnt"> ${team.teamCount} </td>
								<td class="td_teamPhoto"> ${team.teamPhoto} </td>
								<td class="td_team-date"> ${team.createDate} </td>
								<td class="td_team-date"> ${team.teamPoint} </td>
								<td class="td_teamInfo"> ${team.teamInfo} </td>
								<td class="td_team-date"> ${team.locationVO.parentLocationName} - ${team.locationVO.locationName}</td>
							</tr>
						</tbody>	
					</c:forEach>
				</table>
			
			 ${paging}
		
			</div>
		</form>
		</div>		
	</div>
	</div>
</body>
</html>