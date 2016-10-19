<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/Calendar.js"></script>
<body>
	
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/teamInfo">팀 정보</a></div>
			<div class="mplmThree"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
		</div>
	</div>
	
	<div class="myInfoText"><h1>팀 매치 정보</h1>
		<hr class="myPageline">
	</div>
	<input type="text" id="txtDate" onclick="fnPopUpCalendar(txtDate,txtDate,'dd/mm/yyyy')"/>
	
	<iframe src="https://calendar.google.com/calendar/embed?src=hsubin119%40gmail.com&ctz=Asia/Seoul" 
	style="border: 0" width="800" height="600"></iframe>
</body>
</html>