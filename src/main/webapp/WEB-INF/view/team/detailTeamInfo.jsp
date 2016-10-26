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

				
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						window.open("/ShootBoy/teamModify","","width=700, height=800")
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
			});
		});
		
		$("#deleteTeam").click(function () {
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						if ( confirm("정말로 팀을 해체 하시겠습니까?") ) {
							location.href="/ShootBoy/doDeleteTeam?teamId=${teamInfo.teamId}";
							alert("정상적으로 처리 되었습니다.");
						}
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
				
			});
		});
		
		$("#dropTeam").click(function () {
			$("#password").show();
			$("#passwordConfirm").show();
			
			$("#passwordConfirm").click(function(){
				$.post("/ShootBoy/doCheckPassword", {"password" : $("#password").val()} ,function(data){
					if(data == "true"){
						if ( confirm("정말로 팀을 탈퇴 하시겠습니까?") ) {
							alert("정상적으로 처리 되었습니다.");
							location.href="/ShootBoy/doDrop?teamId=${teamInfo.teamId}";
						}
					}
					else{
						alert("비밀번호가 틀렸습니다.")
					}
				});
				
			});
		});
		
		$("#joinAdmit").click(function(){
			if(confirm("가입을 승인하시겠습니까?")){
				$.post("/ShootBoy/doAdmitJoinId",{"joinIds": $(".joinApplyId:checked").val(), "teamId":"${userInfo.teamId}"},function(data){
					$("#join").html(data);
				});
			}
			
		});
		
		$("#joinRefuse").click(function(){
			if(confirm("가입을 거절하시겠습니까?")){
				$.post("/ShootBoy/doJoinRefuse",{"joinIds": $(".joinApplyId:checked").val(), "teamId":"${userInfo.teamId}"},function(data){
					$("#join").html(data);
				});
			}
		});
		
	});	
</script>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
		</div>
	</div>

	<div class="myInfoText" style="display: inline-block; width: 700px;"><h1>팀 정보</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
		<div id="teamDetailwrapper" style="padding-top: 20px; width: 700px; margin-left: 30px;">
			<c:if test="${!empty userInfo.teamId}">
			<div id="teamImg" style="display: inline-block; margin-right: 100px;">
				<img src="/ShootBoy/showImage?teamId=${userInfo.teamId}" 
						style="width: 200px; height: 200px;
						border-radius: 150px; margin-top: 10px;">
			<div class="teamPhoto" style="font-size: 25px; width: 150px; margin-left: 45px; padding-top: 20px;">팀 앰블럼</div>	
			</div>
			<div id="teamDetailContainer" style="display: inline-block; width: 350px; 
					vertical-align: top; padding-top: 20px; margin-right: 30px;">
				<div class="teamName" style="font-size: 20px; padding-bottom: 10px">팀명 : ${userInfo.teamVO.teamName}</div>
				<div class="teamCount" style="font-size: 20px; padding-bottom: 10px">팀원수 : ${userInfo.teamVO.teamCount}</div>
				<div class="teamPoints" style="font-size: 20px; padding-bottom: 10px">팀 포인트 : ${userInfo.teamVO.teamPoint}</div>
				<div class="teamCreatedDate" style="font-size: 20px; padding-bottom: 10px">팀 생성일 :<br/>${userInfo.teamVO.createDate}</div>
				<div class="teamLocation" style="font-size: 20px; padding-bottom: 10px">팀 지역 : ${teamInfo.locationVO.parentLocationName} - ${teamInfo.locationVO.locationName}</div>
				<div class="teamInfo" style="font-size: 20px; padding-bottom: 10px">팀 설명 : ${userInfo.teamVO.teamInfo}</div>
			</div>
			<div id="teamModify" style=" float: right; margin-right:190px; width: 200px;">
				<input type="button" id="modifyBtn" name="modifyBtn" value="수정" 
						style="margin-top: 20px; width: 50px; display: inline-block;" />
					<c:choose>
						<c:when test="${userInfo.levelId eq '3'}">
							<div id="deleteTeam"> <input type="button" id="deleteTeam" name="deleteTeam" value="팀 해체" /> </div>
						</c:when>
						<c:otherwise>
							<div id="dropTeam"> <input type="button" id="dropTeam" name="dropTeam" value="팀 탈퇴" /> </div>
						</c:otherwise>
					</c:choose>
				<div>
					<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
					<input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인" style="margin-right:40px;">
				</div>
			</div>
		</c:if>
		</div>
		<c:if test="${empty userInfo.teamId}">
		<p style="font-size: 20px; color: red;">팀에 가입하지 않았습니다!</p>
		</c:if>
	</div>
	
		<c:if test="${sessionScope._USER_INFO_.levelId eq 3 and !empty joins}">
			<div id="joinContainer">
			<hr/>
				<p style="font-size: 20px; margin-bottom: 20px; color: #000;">팀원</p>
				<c:forEach items="${joins}" var="join" >
					<div id="join">
						<input type="checkbox" class="joinApplyId" name="joinApplyId" value="${join.userVO.userId}" >
						이름 : ${join.getUserVO().userName} |
						아이디 : ${join.getUserVO().email} |
						전화번호 : ${join.getUserVO().phoneNumber} |
						나이 : ${join.getUserVO().age} |
						포지션 : ${join.getUserVO().position} |
						지역 : ${join.getUserVO().getLocationVO ().locationName}
					</div>
					<div class="joinRightBtn">
						<input type="button" id="joinAdmit" name="joinAdmit" value="승인" >
						<input type="button" id="joinRefuse" name="joinRefuse" value="거절" >
					</div>
					<div class="clear"></div>
				</c:forEach>
			</div>
		</c:if>

	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>