<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/checkbox.css" />
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			팀 관리 
		</div>

		<div class="listAll">
				<a class="textAll">전체 목록 | 총 팀수 00개</a>
		</div>
		
		<div class="container">
			<div class="search-tool"> 
				<form id="search-select" name="search-select" method="post">
					<select id="search-target" name="search-target">
						<option value="tm_id"> 팀 아이디 </option>
						<option value="tm_name"> 팀 명 </option>
						<option value="tm_location"> 지역 </option>
					</select>
					<input type="text" id="search-input" name="search-input" value id ="search-word"/>
					<button id="sbtn" name="sbtn" onclick="" >검색 </button> 
				</form>
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
									<input type="checkbox" id="select-check">
									<label for="select-check"></label>
								</div>
							</th>
							<th>팀 아이디</th>
							<th>팀 명</th>
							<th>팀원수</th>
							<th>팀 엠블럼</th>
							<th>생성일자</th>
							<th>팀 포인트</th>
							<th>티 정보</th>
							<th>지역</th>
						</tr>	
					</thead>
					<c:forEach var="teams" items="${teams}">
						<tbody>
							<tr>	
								<td class="td_check">
									<div class="checks">
										<input type="checkbox" id="select-check">
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_teamId"> ${teams.teamId } </td>
								<td class="td_teamName"> ${teams.teamName} </td>
								<td class="td_teamInfo"> ${teams.teamInfo} </td>
								<td class="td_team-memberCnt"> ${teams.teamCount} </td>
								<td class="td_team-date"> ${teams.createDate} </td>
								<td class="td_team-date"> ${teams.createDate} </td>
								<td class="td_team-date"> ${teams.createDate} </td>
								<td class="td_team-date"> ${teams.createDate} </td>
							</tr>
						</tbody>	
					</c:forEach>
				</table>
			</div>
		</div>		
	</div>
</body>
</html>