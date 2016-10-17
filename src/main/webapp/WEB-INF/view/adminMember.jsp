<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/checkbox.css" />
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			회원 관리 
		</div>

		<div class="listAll">
				<a class="textAll">전체 목록 | 총회원수 00명</a>
		</div>
		
		<div class="container">
			<div class="search-tool"> 
				<form id="search-select" name="search-select" method="post">
					<select id="search-target" name="search-target">
						<option value="mb_id"> 회원 아이디 </option>
						<option value="mb_email"> E-Mail </option>
						<option value="mb_name"> 이름 </option>
						<option value="mb_phone"> 휴대폰 </option>
						<option value="mb_age"> 나이 </option>
						<option value="mb_team"> 팀 </option>
						<option value="mb_grade"> 등급 </option>
						<option value="mb_date"> 가입일 </option>
					</select>
					<input type="text" id="search-input" name="search-input" value id ="search-word"/>
					<button id="sbtn" name="sbtn" onclick="" >검색 </button> 
				</div>
			</form>
		
			<div class=line>
			</div>
			
			<div class=notice>
				<p id="notice-text">회원자료 삭제 시 다른 회원이 기존 회원아이디를 사용하지 못하도록 회원아이디는 삭제하지 않고 영구 보관합니다.</p>
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
							<th>회원 이메일</th>
							<th>이름 </th>
							<th>휴대폰</th>
							<th>나이</th>
							<th>포지션</th>
							<th>지역</th>
							<th>팀</th>
							<th>등급</th> 
							<th>가입일</th>
						</tr>	
					</thead>
					<c:forEach var="users" items="${users}">
						<tbody>
							<tr>	
								<td class="td_check">
									<div class="checks">
										<input type="checkbox" id="select-check">
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_userEmail"> ${users.email } </td>
								<td class="td_userName"> ${users.userName } </td>
								<td class="td_userPhone"> ${users.phoneNumber } </td>
								<td class="td_userAge"> ${users.age } </td>
								<td class="td_userPosition"> ${users.position } </td>
								<td class="td_userLocation"> ${users.locationId } </td>
								<td class="td_userTeam"> ${users.teamId } </td>
								<td class="td_userGrade"> ${users.levelId } </td>
								<td class="td_userJoindate"> ${users.createDate } </td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
			
		</div>
	</div>
	
</body>
</html>