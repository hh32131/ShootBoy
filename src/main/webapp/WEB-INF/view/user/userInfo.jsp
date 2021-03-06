<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						window.open("/ShootBoy/userModify","","width=600px,height=700px")
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
			});
			
		});
		
		$("#deleteUser").click(function() {
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
					
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						if( confirm("정말로 탈퇴 하시겠습니까? 팀장이 탈퇴할 경우 팀이 해체됩니다.") ) {
							alert("정상적으로 처리 되었습니다.");
							location.href="/ShootBoy/doDeleteUser?userId=${userInfo.userId}&&teamId=${userInfo.teamId}";
						}
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
			});
		});
		
		$("#deleteUserTwo").click(function() {
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
					
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						if( confirm("정말로 탈퇴 하시겠습니까?") ) {
							alert("정상적으로 처리 되었습니다.");
							location.href="/ShootBoy/doDeleteUserTwoServlet?userId=${userInfo.userId}";
						}
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
			});
		});
	});
</script>

<body>
	
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/teamBoard">팀 게시판</a></div>
			
			
		</div>
	</div>

	<div class="myInfoText" style="width:700px;"><h1>내 정보</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
			<c:if test="${!empty userInfo.userId}">
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
				<div id="userInfoBtn">
					<div style="display: inline-block;"><input type="button" id="modifyBtn" name="modifyBtn" value="수정" ></div>
					<c:choose>
						<c:when test="${sessionScope._USER_INFO_.levelId eq '3'}">
					<div style="display: inline-block;"><input type="button" id="deleteUser" name="deleteUser" value="회원탈퇴" /></div>
					</c:when>
					<c:otherwise>
					<div style="display: inline-block;"><input type="button" id="deleteUserTwo" name="deleteUserTwo" value="회원탈퇴" /></div>
					</c:otherwise>
					</c:choose>
				</div>
				<div id="inline"><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요"></div>
				<div id="inline"><input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인"></div>
				<div class="warning"></div>
			</div>
			<div id="inline" style= "width: 100px; float:right; margin-right:200px;">
				<img src="/ShootBoy/img/호날두2.jpg">
			</div>
			</c:if>
			<c:if test="${empty userInfo.userId}">
				<p style="font-size: 20px; color: red;">로그인 하지 않았습니다! 로그인 후 접근하세요!</p>
			</c:if>
	</div>
	
<div class="clear">
	<div style="padding-top: 50px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>