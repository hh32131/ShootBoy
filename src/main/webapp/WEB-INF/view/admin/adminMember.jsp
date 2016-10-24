<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/checkbox.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"href="/ShootBoy/css/adminPage.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#searchType").change(function() {
			alert($("#searchType option:selected").text());
		});
		
		$("#searchBtn").click(function() {
			var searchType = $("#searchForm > .searchType").val();
			var searchKeyword = $("#searchForm > .searchKeyword").val();
			
			$("#pagingForm > .searchType").val(searchType);
			$("#pagingForm > .searchKeyword").val(searchKeyword);
			
			movePage(0);
		});
		
		$("#deleteBtn").click(function() {
			$.post( "/ShootBoy/doDeleteUserAdmin", $("#checkBoxForm").serialize(), function( data ) {
				alert( "" + data );
				location.reload();
			});
		});
		
		 $("#modifyBtn").click(function() {
				
			 var select = $(".select-check:checked").val();
			 var checkUser = $(".select-check:checked").length;
			 if(checkUser  == 1  ) {
						window.open("/ShootBoy/adminMemberModify?userId=" + select, "", "width=500, height= 500");
			 } 
			 else {
				 alert(" 수정할 유저를 선택해 주세요");
			 }
		});	 
				
		$("#checkAll").click(function(){
	        var chk = $(this).is(":checked");
	        if (chk) $(".check input").prop('checked', true);
		    else $(".check input").prop('checked', false);
		}); 
		
		$("#writeBtn").click(function() {
			window.open("/ShootBoy/adminSignUp", "ADMINSIGNUP", "width=450, height= 600");
		});
	});
</script>
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			회원 관리 
		</div>
		
		<div class="listAll">
			<c:set var="list" value="users"/>
			<p class="textAll">전체 목록 | 총 회원수 ${fn:length(list)}개</p>
		</div>

	<div class="search-tool">
		<form id="searchForm" name="searchForm">
			<select class="searchType" name="searchType" id="searchType">
				<option value="1" ${ searchUser.searchType eq 1 ? 'selected' : '' }>이메일</option>
				<option value="2" ${ searchUser.searchType eq 2 ? 'selected' : '' }>이름</option>
				<option value="3" ${ searchUser.searchType eq 3 ? 'selected' : '' }>연락처</option>
				<option value="4" ${ searchUser.searchType eq 4 ? 'selected' : '' }>나이</option>
			</select> <input type="text" class="searchKeyword" id="searchKeyword"
				name="searchKeyword" value="${searchUser.searchKeyword}" /> <input
				type="button" class="searchBtn" id="searchBtn" value="검색" />
			
			<div class="clear"></div>
		</form>
	</div>

	<div class="line"></div>

	<div class="notice">
		<p id="notice-text">회원자료 삭제 시 다른 회원이 기존 회원아이디를 사용하지 못하도록 회원아이디는 삭제하지 않고 영구 보관합니다.</p>
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
					<th>회원 이메일</th>
					<th>이름</th>
					<th>휴대폰</th>
					<th>나이</th>
					<th>포지션</th>
					<th>지역</th>
					<th>팀</th>
					<th>등급</th>
					<th>가입일</th>
				</tr>
			</thead>
				<form id="checkBoxForm" name="checkBoxForm">	
					<c:forEach var="users" items="${users}">
						<tbody>
							<tr>
								<td class="td_check">
									<div class="checks check">
										<input type="checkbox" class="select-check" data-selectid="${users.userId}" name="select-check" value="${users.userId}">
										<label for="select-check"></label>
									</div>
								</td>
								<td class="td_userEmail"> ${users.email } </td>
								<td class="td_userName"> ${users.userName } </td>
								<td class="td_userPhone"> ${users.phoneNumber } </td>
								<td class="td_userAge"> ${users.age } </td>
								<td class="td_userPosition"> ${users.position } </td>
								<td class="td_userLocation"> ${users.locationVO.locationName } </td>
								<td class="td_userTeam"> ${users.teamVO.teamName } </td>
								<td class="td_userGrade"> ${users.levelId } </td>
								<td class="td_userJoindate"> ${users.createDate } </td>
							</tr>
						</tbody>
					</c:forEach>
				</form>
			</table>
			<div class="paging">
			<form id="pagingForm" name="pagingForm">
				${paging} 
				<input type="hidden" class="searchType" name="searchType"	value="${searchUser.searchType }" /> 
				<input type="hidden" class="searchKeyword" name="searchKeyword" value="${searchUser.searchKeyword}" />
			</form>
		</div>
		<div class="initBtn">
				<input type="button" id="initBtn" value="전체보기" onclick="location='/ShootBoy/adminUser/init'" />
		</div>
		<div class="functionBtn">
			<input type="button" id="writeBtn" value="등 록"  />
			<input type="button" id="modifyBtn" value="선택 수정"  /> 
			<input type="button" id="deleteBtn" value="선택 삭제"  />
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />