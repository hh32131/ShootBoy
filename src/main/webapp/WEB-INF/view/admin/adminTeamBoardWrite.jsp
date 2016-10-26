<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminArticleWrite.css">

<title>Administrator</title>
</head>
<body>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
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
				"action": "/ShootBoy/doWriteAdminTeamBoard"
			}).submit();
			
		});
			
		$("#backBtn").click(function() {
			window.close();
		});
	});
</script>
<body>
	<div class="articleWrite-header">
		<div class="articleWrite-top">
			<div class="articleWrite-admin-logo">
				<a href="/ShootBoy/admin" class="logo-text">ADMINISTRATOR</a>
			</div>
			<div class="articleWrite-shootboy-main">
				<a href="/ShootBoy/main" class="main-text"> ShootBoy </a> 
			</div>
		</div>
		<div class="bottom">
			<p class="articleWrite-title">게시물 등록</p> 
		</div>
	</div>
	<form id="writeForm" name="writeForm" enctype="multipart/form-data">
		<select name="teamId" id="teamId">
			<option>팀명을 선택해주세요</option>
			<c:forEach var="teamVO" items="${teamVO}">
				<option value="${teamVO.teamId}">${teamVO.teamName}</option>
			</c:forEach>
		</select>
		<input type="text" id="boardSubject" name="boardSubject"
			placeholder="제목을 입력하세요."
			style="width: 500px; height: 25px; font-size: 15px;" />

		<textarea id="boardContent" name="boardContent"	placeholder="내용을 입력하세요."
			style="width: 500px; height: 250px; font-size: 15px; margin-bottom: 30px;"></textarea>
	
		<input type="file" id="file" name="file" />
	
		<div class="btn" style="float: right">
			<input type="button" id="writeBtn" name="writeBtn" value="글쓰기" />
			<input type="button" id="backBtn" name="backBtn" value="취 소" />
		</div>
	</form>

<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />