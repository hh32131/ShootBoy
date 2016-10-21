<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			
<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		
		$("#goBackBtn").click(function() {			
			location.href="/ShootBoy/list?categoryId=${categoryId}";		
		});
		
		$("#writeBtn").click(function() {
			
			if( $("#boardSubject").val() == "") {
				alert("제목을 입력해주세요.");
				return;
			}
			if( $("#boardContent").val() =="") {
				alert("내용을 입력해주세요.");
				return;
			}
			
			$("#writeForm").attr( {
				"method": "post",
				"action": "/ShootBoy/doWrite"
			}).submit();
		});
	});
</script>

<body>
	<div id="boardWrapper">
		<div id="myPageLeftMenu">
			<div class="mplmTitle">Community</div>
				<div id="myPageLeftMenuTwo">
					<div class="mplmOne"><c:if test="${categoryId eq 11}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=11">공지사항</a></div>
					<div class="mplmTwo"><c:if test="${categoryId eq 12}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=12">가입인사</a></div>
					<div class="mplmThree"><c:if test="${categoryId eq 13}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=13">자유게시판</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 14}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=14">국내축구소식</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 15}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=15">해외축구소식</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 16}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=16">축구동영상</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 17}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=17">축구갤러리</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 18}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=18">매치경기후기</a></div>
					<div class="mplmFour"><c:if test="${categoryId eq 19}"><img src="/ShootBoy/img/화살표.jpg" class="arrow"></c:if><a href="/ShootBoy/list?categoryId=19">모집게시판</a></div>
				</div>
		</div>
		<div class="boardText" style="margin-top: 20px;">
		<c:choose >
			<c:when test="${categoryId == '0'}">
				<h1>Community</h1>
			</c:when>
			<c:when test="${categoryId == '11'}">
				<h1>공지사항</h1>
			</c:when>
			<c:when test="${categoryId == '12'}">
				<h1>가입인사</h1>
			</c:when>
			<c:when test="${categoryId == '13'}">
				<h1>자유게시판</h1>
			</c:when>
			<c:when test="${categoryId == '14'}">
				<h1>국내축구소식</h1>
			</c:when>
			<c:when test="${categoryId == '15'}">
				<h1>해외축구소식</h1>
			</c:when>
			<c:when test="${categoryId == '16'}">
				<h1>축구동영상</h1>
			</c:when>
			<c:when test="${categoryId == '17'}">
				<h1>축구갤러리</h1>
			</c:when>
			<c:when test="${categoryId == '18'}">
				<h1>매치경기후기</h1>
			</c:when>
			<c:when test="${categoryId == '19'}">
				<h1>모집게시판</h1>
				</c:when>
			</c:choose>
		<hr style="border: 1px solid; margin-bottom: 20px;"/>
		<form id="writeForm" name="writeForm" enctype="multipart/form-data">
			<input type="hidden" id="categoryId" name="categoryId" value="${categoryId}" >
			<div>
				<input type="text" id="boardSubject" name="boardSubject" placeholder="제목을 입력하세요." 
						style="width:400px; height: 25px; font-size: 15px;"/>
 			<div>
					<%-- <select id="categoryId" name="categoryId" >
						<option>카테고리를 선택해주세요</option>
						<option value="0" >Community</option>
						<option value="11" >공지사항</option>
						<option value="${categoryId == '12'}" >가입인사</option>
						<option value="${categoryId == '13'}" >자유게시판</option>
						<option value="${categoryId == '14'}" >국내축구소식</option>
						<option value="${categoryId == '15'}" >해외축구소식</option>
						<option value="${categoryId == '16'}" >축구동영상</option>
						<option value="${categoryId == '17'}" >축구갤러리</option>
						<option value="${categoryId == '18'}" >매치경기후기</option>
						<option value="${categoryId == '19'}" >모집게시판</option>
					</select> --%>
				</div> 
			</div>
			<div style="height: 10px;">
			</div>
			<div>
				<textarea id="boardContent" name="boardContent" placeholder="내용을 입력하세요."
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
	</div>
</div>
</body>
</html>