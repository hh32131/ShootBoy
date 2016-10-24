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
						window.open("/ShootBoy/teamModify","","width=800, height=800")
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
							alert("정상적으로 처리 되었습니다.");
							location.href="/ShootBoy/doDeleteTeam?teamId=" + "${teamInfo.teamId}";
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
							location.href="/ShootBoy/doDrop?teamId=" + "${teamInfo.teamId}";
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
<<<<<<< HEAD
					
=======
					$("#join").html(data);
>>>>>>> 63cfbb538ffc82ea49539dc54fcf70cf4a97200a
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
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
		</div>
	</div>

	<div class="myInfoText" style="display: inline-block; width: 700px;"><h1>팀 정보</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
		<div id="teamDetailwrapper" style="padding-top: 20px; width: 500px; margin-left: 100px;">
			<c:if test="${!empty userInfo.teamId}">
			<div id="teamImg" style="display: inline-block;">
				<img src="/ShootBoy/showImage?teamId=${userInfo.teamId}" 
						style="width: 200px; height: 200px;
						border-radius: 150px;">
			<div class="teamPhoto" style="font-size: 30px; width: 150px; margin-left: 35px; padding-top: 20px;">팀 앰블럼</div>	
			</div>
			<div id="teamDetailContainer" style="display: inline-block; width: 200px; 
					vertical-align: top; margin-left: 50px; padding-top: 20px;">
				<div class="teamName" style="font-size: 20px; padding-bottom: 10px">팀명 : ${userInfo.teamVO.teamName}</div>
				<div class="teamCount" style="font-size: 20px; padding-bottom: 10px">팀원수 : ${userInfo.teamVO.teamCount}</div>
				<div class="teamPoints" style="font-size: 20px; padding-bottom: 10px">팀 포인트 : ${userInfo.teamVO.teamPoint}</div>
				<div class="teamCreatedDate" style="font-size: 20px; padding-bottom: 10px">팀 생성일 : </br>${userInfo.teamVO.createDate}</div>
				<div class="teamLocation" style="font-size: 20px; padding-bottom: 10px">팀 지역 : ${teamInfo.locationVO.parentLocationName} - ${teamInfo.locationVO.locationName}</div>
				<div class="teamInfo" style="font-size: 20px; padding-bottom: 10px">팀 설명 : ${userInfo.teamVO.teamInfo}</div>
			</div>
			<div id="teamModify" style=" float: right; margin-right:40px; width: 200px;">
				<input type="button" id="modifyBtn" name="modifyBtn" value="수정" 
						style="margin-top: 20px; width: 50px;" />
					<c:choose>
						<c:when test="${userInfo.levelId eq '3'}">
							<div> <input type="button" id="deleteTeam" name="deleteTeam" value="팀 해체" /> </div>
						</c:when>
						<c:otherwise>
							<div> <input type="button" id="dropTeam" name="dropTeam" value="팀 탈퇴" /> </div>
						</c:otherwise>
					</c:choose>
					
			<div><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
				<input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인" style="margin-right:40px;">
			</div>
			</div>
		</c:if>
		<c:if test="${sessionScope._USER_INFO_.levelId eq 3 and !empty joins}">
		<input type="button" id="joinAdmit" name="joinAdmit" value="승인" >
		<input type="button" id="joinRefuse" name="joinRefuse" value="거절" >
		<div id="join"></div>
			<c:forEach items="${joins}" var="join" >
			<tr>
				<td><input type="checkbox" class="joinApplyId" name="joinApplyId" value="${join.userVO.userId}" ></td>
				<td>${join.getUserVO().userName}</td>
				<td>${join.getUserVO().email}</td>
				<td>${join.getUserVO().phoneNumber}</td>
				<td>${join.getUserVO().age}</td>
				<td>${join.getUserVO().position}</td>
				<td>${join.getUserVO().getLocationVO().locationName}</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty userInfo.teamId}">
		<p style="font-size: 20px; color: red;">팀에 가입하지 않았습니다!</p>
		</c:if>
		</div>
</div>
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>