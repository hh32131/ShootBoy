<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("#goBackBtn").click(function() {
				location.href = "/ShootBoy/board/detail?boardId=${board.boardId}";
			});

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
					"action" : "/ShootBoy/board/doModify"
				}).submit();

			});
		});
	</script>
</head>
<body>

	<form id="modifyForm" name="modifyForm" enctype="multipart/form-data">
		<input type="hidden" name="boardId" value="${board.boardId}" />
		<div>
			<input type="text" id="boardSubject" name="boardSubject"
				placeholder="제목을 입력하세요." value="${board.boardSubject}" />
		</div>
		<div>
			<textarea id="boardContent" name="boardContent"
				placeholder="내용을 입력하세요.">${board.boardContent}	</textarea>
		</div>
		<c:if test="${not empty board.fileName }">
			<div style="padding-top: 10px; padding-bottom: 10px;">
				<input type="checkbox" id="fileDeleteBtn" name="fileDeleteBtn"
					value="delete" /> <img src="/Board/img/text-file-3-xxl.png"
					style="width: 12px;" /> ${board.fileName}
			</div>
		</c:if>
		<div>
			<div class="left">
				<input type="file" id="file" name="file" />
			</div>
			<div class="right">
				<div class="inline">
					<input type="button" id="goBackBtn" value="뒤로가기" />
				</div>
				<div class="inline">
					<input type="button" id="modifyBtn" value="수정" />
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</form>
</body>
</html>