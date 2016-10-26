
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	$("#goBackBtn").click(function() {			
		location.href="/ShootBoy/teamBoard?teamId=${teamId}";		
	});
	
	$("#writeBtn").click(function() {
		
		if( $("#teamBoardSubject").val() == "") {
			alert("제목을 입력해주세요.");
			return;
		}
		if( $("#teamBoardContent").val() =="") {
			alert("내용을 입력해주세요.");
			return;
		}
		
		$("#writeForm").attr( {
			"method": "post",
			"action": "/ShootBoy/doWriteTeamBoard"
		}).submit();
	});
});

</script>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><a href="/ShootBoy/userInfo">내 정보</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/detailTeamInfo">팀 정보</a></div>
			<div class="mplmThree"><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></div>
			<div class="mplmFour"><a href="/ShootBoy/message">메시지함</a></div>
			<div class="mplmFour"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/teamBoard">팀 게시판</a></div>
			
		</div>
	</div>
	<hr style="border: 1px solid; margin-bottom: 20px;"/>
		<form id="writeForm" name="writeForm" enctype="multipart/form-data">
			<input type="hidden" id="teamId" name="teamId" value="${teamId}" >
			<div>
				<input type="text" id="teamBoardSubject" name="teamBoardSubject" placeholder="제목을 입력하세요." 
						style="width:400px; height: 25px; font-size: 15px;"/>
			</div>
			<div style="height: 10px;">
			</div>
			<div>
				<textarea id="teamBoardContent" name="teamBoardContent" placeholder="내용을 입력하세요."
							style="width:700px; height: 250px; font-size: 15px; margin-bottom: 30px;" ></textarea>
			</div>
			<div>
				<input type="file" id="file" name="file"/>
				<div class="listBtn" style="float: right; margin-right: 65px;">
					<input type="button" id="goBackBtn" name="goBackBtn" value="뒤로가기" />
					<input type="button" id="writeBtn" name="writeBtn" value="글쓰기" />
				</div>
			</div>
		</form>
	
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>