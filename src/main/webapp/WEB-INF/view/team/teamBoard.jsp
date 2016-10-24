<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

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
	
	<div class="myInfoText" style="display: inline-block; width: 800px;"><h1>팀 정보</h1>
		<hr class="myPageline">
		<div id="teamDetailwrapper" style="padding-top: 20px;">
		<c:if test="${!empty userInfo.teamId}">
			<div id="teamImg" style="display: inline-block;">
				<img src="/ShootBoy/showImage?teamId=${userInfo.teamId}" 
						style="width: 300px; height: 300px;
						border-radius: 150px;">
			<div class="teamPhoto" style="font-size: 30px; width: 150px; margin-left: 80px; padding-top: 20px;">팀 앰블럼</div>	
			</div>
			<div id="teamDetailContainer" style="display: inline-block; width: 400px; 
					vertical-align: top; margin-left: 50px; padding-top: 20px;">
				<div class="teamName" style="font-size: 20px; padding-bottom: 10px">팀명 : ${userInfo.teamVO.teamName}</div>
				<div class="teamCount" style="font-size: 20px; padding-bottom: 10px">팀원수 : ${userInfo.teamVO.teamCount}</div>
				<div class="teamPoints" style="font-size: 20px; padding-bottom: 10px">팀 포인트 : ${userInfo.teamVO.teamPoint}</div>
				<div class="teamCreatedDate" style="font-size: 20px; padding-bottom: 10px">팀 생성일 : ${userInfo.teamVO.createDate}</div>
				<div class="teamLocation" style="font-size: 20px; padding-bottom: 10px">팀 지역 : ${teamInfo.locationVO.parentLocationName} - ${teamInfo.locationVO.locationName}</div>
				<div class="teamInfo" style="font-size: 20px; padding-bottom: 10px">팀 설명 : ${userInfo.teamVO.teamInfo}</div>
			</div>
			<div id="teamModify" style=" float: right; margin-right: 100px;"><input type="button" id="modifyBtn" name="modifyBtn" value="수정" 
					style="margin-top: 20px; width: 200px;" >

					<c:choose>
						<c:when test="${userInfo.levelId eq '3'}">
							<div> <input type="button" id="deleteTeam" name="deleteTeam" value="팀 해체" /> </div>
						</c:when>
						<c:otherwise>
							<div> <input type="button" id="dropTeam" name="dropTeam" value="팀 탈퇴" /> </div>
						</c:otherwise>
					</c:choose>
					

			<div><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
				<input type="button" id="passwordConfirm" name="passwordConfirm" value="비밀번호 확인" style="margin-left: 30px;">
			</div>
			</div>
		</c:if>
		<c:if test="${sessionScope._USER_INFO_.levelId eq 3}">
			<c:forEach items="${joins}" var="join" >
			<tr>
				<td>${join.userVO.userName}</td>
				<td>${join.userVO.email}</td>
				<td>${join.userVO.phoneNumber}</td>
				<td>${join.userVO.age}</td>
				<td>${join.userVO.position}</td>
				<td>${join.userVO.locationVO.locationName}</td>
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