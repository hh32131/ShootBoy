<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminMain.css" />

	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />

	<div class="wrapper">
		<div class="page-title">
			관리자 메인
		</div>

		<hr/>

		<div class="container">
			
			<div class="sub-title">
			최신 회원 목록
			</div>
			
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 회원 아이디 </th>
							<th scope="col"> 이름 </th>
							<th scope="col"> 나이 </th>
							<th scope="col"> 핸드폰 번호 </th>
							
						</tr>
					</thead>
					<c:forEach var="users" items="${users}" begin="0" end="4" step="1">
						<tbody>
							<tr>
								<td class="td_userEmail"> ${users.email } </td>
								<td class="td_userName"> ${users.userName } </td>
								<td class="td_userAge"> ${users.age } </td>
								<td class="td_userPhone"> ${users.phoneNumber } </td>
							</tr>
						</tbody>	
					</c:forEach>
				</table>
				<div class="member-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminMember'">회원 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최신 팀 목록
			</div>
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 팀 아이디 </th>
							<th scope="col"> 팀 명 </th>
							<th scope="col"> 팀 정보 </th>
							<th scope="col"> 팀 인원수 </th>
							<th scope="col"> 팀 생성일자 </th>
						</tr>
					</thead>
					<c:forEach var="teams" items="${teams}" begin="0" end="4" step="1">
						<tbody>
							<tr>
								<c:set var="number" value="${fn:split(teams.teamId,'-')[2]}" />
								<fmt:parseNumber var="number" type="number" value="${number}" />
								<td class="td_teamId"> ${number}</td>
								<td class="td_teamName"> ${teams.teamName} </td>
								<td class="td_teamInfo"> ${teams.teamInfo} </td>
								<td class="td_team-memberCnt"> ${teams.teamCount} </td>
								<td class="td_team-date"> ${teams.createDate} </td>
							</tr>
						</tbody>	
					</c:forEach>
				</table>
				<div class="game-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminTeam'">팀 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최신 경기
			</div>			
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 경기 번호 </th>
							<th scope="col"> 생성 팀 </th>
							<th scope="col"> 신청 팀 </th>
							<th scope="col"> 지역 </th>
							<th scope="col"> 날짜 </th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td_gameId"> 1 </td>
							<td class="td_homeTeam"> 홈팀 </td>
							<td class="td_awayTeam"> 어웨이팀 </td>
							<td class="td_location"> 서울-강남 </td>
							<td class="td_date"> 2016-10-13 4:00 </td>
						</tr>
						<tr>
							<td class="td_gameId"> 2 </td>
							<td class="td_homeTeam"> y3 </td>
							<td class="td_awayTeam"> m2 </td>
							<td class="td_location"> 경기-이천 </td>
							<td class="td_date"> 2016-10-14 21:00 </td>
						</tr>
					</tbody>	
				</table>
				<div class="game-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminGame'">경기 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최신 게시물
			</div>
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 게시물 번호 </th>
							<th scope="col"> 제 목 </th>
							<th scope="col"> 이름 </th>
							<th scope="col"> 날짜 </th>
							
						</tr>
					</thead>
					<c:forEach var="boards" items="${boards}" begin="0" end="4" step="1">
						<tbody>
							<tr>
								<c:set var="number" value="${fn:split(boards.boardId,'-')[2]}" />
								<fmt:parseNumber var="number" type="number" value="${number}" />
								<td class="td_boardId"> ${number}</td>
								<td class="td_boardSubject"> ${boards.boardSubject} </td>
								<td class="td_username"> ${boards.userVO.userName } </td>
								<td class="td_createDate"> ${boards.createDate} </td>
							</tr>
						</tbody>	
					</c:forEach>	
				</table>
				<div class="article-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminArticle'">게시글 전체보기</button>
					<br/>
				</div>
			</div>
			<br/><br/><br/>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />