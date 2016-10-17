<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#password").hide();
		
		$("#modifyBtn").click(function(){
			$("#password").show();
			
			if($("#password").val() == ${userInfo.password}) {
				location.href="/ShootBoy/userModify";
			}
			else {
			$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>").slideDown();
			}
			
		});
	});
</script>

<body>
	
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/teamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
		</div>
	</div>
	
	<div class="myInfoText"><h1>내 정보</h1>
		<hr class="myPageline">
	</div>
	
	<div id="userInfo" >
		이름 : ${userInfo.userName}
		전화번호 : ${userInfo.phoneNumber}
		나이 : ${userInfo.age}
		포지션 : ${userInfo.position}
		가입일: ${userInfo.createDate}
		지역 : ${userInfo.locationVO.parentLocationName}-${userInfo.locationVO.locationName}
		<c:if test="${!empty userInfo.teamId}">
		팀 : ${userInfo.teamVO.teamName}
		</c:if>
		<input type="button" id="modifyBtn" name="modifyBtn" value="수정" >
		<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
		<div class="warning"></div>
	</div>
</body>
</html>