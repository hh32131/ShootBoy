<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#password").hide();
		$("#passwordConfirm").hide();
		
		$("#modifyBtn").click(function(){ 
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
				
			if($("#password").val()=="${userInfo.password}"){
				location.href="/ShootBoy/teamModify";
			}
			else{
				$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>")
			}

			});
		});
	});
		
</script>
</head>
<body>


<body>
	
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
		</div>
	</div>
	
	<div class="myInfoText"><h1>팀 정보</h1>
		<hr class="myPageline">
	</div>
	<div id="teamDetailwrapper" >
		<c:if test="${!empty userInfo.teamId}">

		<img src="/ShootBoy/showImage?teamId=${userInfo.teamId}">
			팀명 : ${userInfo.teamVO.teamName}
			팀원수 : ${userInfo.teamVO.teamCount}
			팀 포인트 : ${userInfo.teamVO.teamPoint}
			팀 생성일 : ${userInfo.teamVO.createDate}
			팀 지역 : ${teamInfo.locationVO.parentLocationName}-${teamInfo.locationVO.locationName}
			팀 설명 : ${userInfo.teamVO.teamInfo}
		<input type="button" id="modifyBtn" name="modifyBtn" value="수정" >
		<input type="password" id="password" name="password" placeholder=" 회원 비밀번호를 입력해주세요">
		<input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인">
		<div class="warning"></div>
		</c:if>
	</div>

</body>
</html>