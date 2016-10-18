<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/checkbox.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$().ready(function() {
		$("#searchType").change(function() {
			alert($("#searchType option:selected").text());
		});
	});
	
</script>
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			회원 관리 
		</div>
		<div class="listAll">
				<a class="textAll">전체 목록 | 총회원수 00명</a>
		</div>
			<div class=line></div>
			<div class=notice>
				<p id="notice-text">회원자료 삭제 시 다른 회원이 기존 회원아이디를 사용하지 못하도록 회원아이디는 삭제하지 않고 영구 보관합니다.</p>
			</div>
			<div class="alldata-table">
				<table>
					<thead>
						<tr>
							<th></th>
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
			<form id="searchForm" name="searchForm">
				${paging}
				<div style="padding-top: 5px;">
				<select id="searchType" name="searchType">
					<option value="1" ${ searchUser.searchType eq 1 ? 'selected' : '' }>이메일</option>
					<option value="2" ${ searchUser.searchType eq 2 ? 'selected' : '' }>이름</option>
					<option value="3" ${ searchUser.searchType eq 3 ? 'selected' : '' }>연락처</option>
					<option value="4" ${ searchUser.searchType eq 4 ? 'selected' : '' }>나이</option>
				</select>
				<input type="text" id="searchKeyword" name="searchKeyword" value="${searchUser.searchKeyword}"/>
				<input type="button" id="searchBtn" value="검색" onclick="movePage(0)"/>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>