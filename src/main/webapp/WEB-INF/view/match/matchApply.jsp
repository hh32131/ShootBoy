<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">

<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmTwo"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchApply">매치 신청</a></div>
			<div class="mplmThree"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>매치 신청</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
	<div id="locationNavi">
		<ul>
		  <li><a class="active" href="#">전체</a></li>
		  <li><a href="#">서울</a></li>
		  <li><a href="#">경기</a></li>
		  <li><a href="#">강원</a></li>
		  <li><a href="#">충청</a></li>
		  <li><a href="#">전라</a></li>
		  <li><a href="#">경상</a></li>
		  <li><a href="#">제주</a></li>
		</ul>
	</div>
	</div>
	
	<table style="margin-left: 300px;">
		<tr>
			<td>일</td>
			<td>월</td>
			<td>화</td>
			<td>수</td>
			<td>목</td>
			<td>금</td>
			<td>토</td>
		</tr>
		<tr>
		<c:set var="day" value="${nowYearAndMonth.day-1}"></c:set>
		<c:forEach var="date" begin="1" end="${day}" step="1">
			<td>&nbsp;</td>
		</c:forEach>
		
		<c:forEach var="date" begin="1" end="${maxDate }" step="1">
			<c:set var="day" value="${day+1}"></c:set>
			
				<td>${date}</td>
				<c:if test="${ day % 7 eq 0 }">
					</tr><tr>
				</c:if>
		</c:forEach>
		</tr>
	
	</table>
	
	
	
</body>
</html>