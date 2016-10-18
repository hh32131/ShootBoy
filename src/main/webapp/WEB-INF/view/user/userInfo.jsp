<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#password").hide();
		$("#passwordConfirm").hide();
		
		$("#modifyBtn").click(function(){
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
				if($("#password").val()==${userInfo.password}) {
					window.open("/ShootBoy/userModify","","width=600px,height=700px");
				}
				else{
					$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>")
				}
			});
			
		});
		$("#deleteUser").click(function() {
			if( confirm("정말로 탈퇴 하시겠습니까?") ) {
				alert("정상적으로 처리 되었습니다.");
				location.href="/ShootBoy/doDeleteUser?userId="+"${userInfo.userId}";
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
			<div id="userInfoWrapper">
				<div class="name" style="font-size: 20px; margin-bottom: 15px;">이름 : ${userInfo.userName}</div>
				<div class="phone" style="font-size: 20px; margin-bottom: 15px;">전화번호 : ${userInfo.phoneNumber}</div>
				<div class="age" style="font-size: 20px; margin-bottom: 15px;">나이 : ${userInfo.age}</div>
				<div class="position" style="font-size: 20px; margin-bottom: 15px;">포지션 : ${userInfo.position}</div>
				<div class="joinDate" style="font-size: 20px; margin-bottom: 15px;">가입일: ${userInfo.createDate}</div>
				<div class="location" style="font-size: 20px; margin-bottom: 15px;">지역 : ${userInfo.locationVO.parentLocationName} - ${userInfo.locationVO.locationName}</div>
				<c:if test="${!empty userInfo.teamId}">
				<div class="team" style="font-size: 20px; margin-bottom: 15px;">팀 : ${userInfo.teamVO.teamName}</div>
				</c:if>
				<div><input type="button" id="modifyBtn" name="modifyBtn" value="수정" ></div>
				<div><input type="button" id="deleteUser" name="deleteUser" value="회원탈퇴" /></div>
				<div id="inline"><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요"></div>
				<div id="inline"><input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인"></div>
				<div class="warning"></div>
			</div>
	</div>
	
<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>