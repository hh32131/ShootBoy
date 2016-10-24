<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">

<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/matchApply">매치 신청</a></div>
			<div class="mplmThree"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>매치 보드</h1>
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
</body>
</html>