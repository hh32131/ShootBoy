<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function () {
		
		$("#deleteBtn").click(function () {
			if( confirm("정말로 삭제하시겠습니까?") ) {
				$.post( "/ShootBoy/doDeleteGame", $("#checkBoxForm").serialize(), function( data ) {
					alert( "" + data );
					location.reload();
				});
			}
		})
		
	});
</script>
	<div class="wrapper">
		<div class="page-title">
			경기 관리
		</div>
		
		<div class="listAll">
				<p class="textAll">전체 목록 | 총 경기수 00개</p>
		</div>
		
		<div class="container">
			<div class="search-tool"> 
				<form id="search-select" name="search-select" method="post">
					<select id="searchType" name="searchType">
						<option value="gm_id"> 경기 아이디 </option>
						<option value="tm_name"> 팀 명 </option>
						<option value="gm_date"> 경기 날짜 </option>
						<option value="gm_location"> 지역 </option>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value id ="search-word"/>
					<button id="searchBtn" name="searchBtn" onclick="" >검색 </button> 
				</form>
			</div>
		
			<div class="line">
			</div>
			
			<div class="notice">
				<p id="notice-text">경기 리스트</p>
			</div>
			
			<div class="alldata-table">
				<table>
					<thead>
						<tr>
							<th>
								<div class="checks">
									<input type="checkbox" id="select-check">
									<label for="select-check"></label>
								</div>
							</th>
							<th>경기 아이디</th>
							<th>홈 팀명</th>
							<th>어웨이 팀명</th>
							<th>경기 날짜</th>
							<th>등록 날짜</th>
							<th>지역</th>
						</tr>	
					</thead>
					<tbody>
					<form id="checkBoxForm" name="checkBoxForm">
						<c:forEach items="${matchs}" var="matchs" >
							<tr>	
								<td class="td_check">
									<div class="checks">
										<input type="checkbox" class="select-check" data-selectid="${matchs.matchId}" name="select-check" value="${matchs.matchId}" >
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_gameId"> ${matchs.matchId} </td>
								<td class="td_homeTeam"> ${matchs.teamVO.teamName} </td>
								<td class="td_awayTeam"> ${matchs.awayTeamVO.teamName} </td>
								<td class="td_gamedate"> ${matchs.schedule} </td>
								<td class="td_registerdate"> ${matchs.createDate} </td>
								<td class="td_gameLocation"> ${matchs.locationVO.locationName}-${matchs.locationVO.parentLocationName} </td>
							</tr>
						</c:forEach>
						</form>
					</tbody>
				</table>
				<div style="padding-top: 5px;">
			<form id="pagingForm" name="pagingForm">
				${paging} 
				<input type="hidden" class="searchType" name="searchType" value="${ searchTeamMatch.searchType }" /> 
				<input type="hidden" class="searchKeyword" name="searchKeyword" value="${searchTeamMatch.searchKeyword}" />
			</form>
			<div>
				<input type="button" id="deleteBtn" name="deleteBtn" value="삭제" />
			</div>
		</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />