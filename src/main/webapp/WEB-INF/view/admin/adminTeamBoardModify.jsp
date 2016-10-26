<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminArticleModify.css">

<title>Administrator</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var errorCode = "${param.errorCode}";

		if (errorCode == "1") {
			$("div.warning").html("<p> 글쓰기에 실패했습니다.</p>");
			$("div.warning").slideDown();
		} else if (errorCode == "2") {
			$("div.warning").html("<p> 제목을 입력해주세요.</p>");
			$("div.warning").slideDown();
		}

		$("#modifyBtn").click(function() {
			if ($("#boardSubject").val() == "") {
				alert("제목을 입력해주세요.");
				return;
			}
			if ($("#boardContent").val() == "") {
				alert("내용을 입력해주세요.");
				return;
			}
				$("#modifyForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doModifyAdminTeamModify"
			}).submit();
		});
		
		$("#backBtn").click(function() {
			window.close();
		});
	});
</script>
</head>
<body>
	<div class="modify-header">
		<div class="modify-top">
			<div class="modify-admin-logo">
				<a href="/ShootBoy/admin" class="logo-text">ADMINISTRATOR</a>
			</div>
			<div class="modify-shootboy-main">
				<a href="/ShootBoy/main" class="main-text"> ShootBoy </a> 
			</div>
		</div>
		<div class="bottom">
			<p class="modify-title">게시물 수정</p> 
		</div>
	</div>

	<form id="modifyForm" name="modifyForm" enctype="multipart/form-data">
		<input type="hidden" name="teamBoardId" value="${teamBoardVO.teamBoardId}" />
		<div>
			<select name="teamId" id="teamId">
				<option>카테고리를 선택해주세요</option>
				<c:forEach var="team" items="${team }">
					<option value="${team.teamId }">${team.teamName }</option>
				</c:forEach>
			</select>
			<input type="text" id="boardSubject" name="boardSubject"
				placeholder="제목을 입력하세요." value="${teamBoardVO.teamBoardSubject}" />
		</div>
		<div>
			<textarea id="boardContent" name="boardContent"
				placeholder="내용을 입력하세요.">${teamBoardVO.teamBoardContent}	</textarea>
		</div>
		<c:if test="${not empty teamBoardVO.fileName }">
			<div style="padding-top: 10px; padding-bottom: 10px;">
				<input type="checkbox" id="fileDeleteBtn" name="fileDeleteBtn" value="delete" /> 
				<img src="/Board/img/text-file-3-xxl.png" style="width: 12px;" /> 
				${teamBoardVO.fileName}
			</div>
		</c:if>
			<input type="file" id="file" name="file" />
			<input type="button" id="modifyBtn" value="수 정" />
			<input type="button" id="backBtn" value="취 소" />
	</form>
</body>
</html>