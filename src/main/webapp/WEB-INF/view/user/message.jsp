<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<body>
	
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/teamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/message">메시지함</a></div>
		</div>
	</div>
	
	<div class="myInfoText" style="width:700px;"><h1>메시지함</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
	</div>
	
</body>
</html>