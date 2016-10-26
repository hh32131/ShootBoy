<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">

<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmThree"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>매치 신청 관리</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
	<div id="locationNavi"></div>
	</div>

<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>