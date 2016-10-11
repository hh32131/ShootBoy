<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		moveToCenter();
		$("#backBtn").click(function() {
			if (confirm("정말 취소하시겠습니까?")) {
				location.href = "/ShootBoy/main";
			}
		});
		$("#createBtn").click(function() {
			if (confirm("생성하시겠습니까?")) {
			$("#craeteTeamForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doCreateTeam"
			}).submit();
			}
		});
	});

	$(window).resize(function() {
		moveToCenter();
	});


	function moveToCenter() {

		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight) / 2)
				- (parseInt(wrapperHeight) / 2);

		$("#wrapper").css({
			"position" : "relative",
			"top" : middlePosition + "px"
		});

	};
</script>
</head>
<body>
	<div id="wrapper" style="width: 350px;">
		<form id="craeteTeamForm" name="createTeamForm"
			enctype="multipart/form-data">
			<div>
				<input type="text"
					style="width: 350px; height: 25px; border-radius: 10px;"
					id="boardSubject" name="boardSubject" placeholder="팀명을 입력하세요." />
			</div>
			<div style="height: 10px;"></div>
			<div>
				<textarea id="teamInfo" name="teamInfo"
					style="width: 350px; height: 250px; border-radius: 10px;"
					placeholder="소개글을 입력하세요."></textarea>
			</div>
			<input type="file" style="width: 150px;" /> <input type="button"
				id="createBtn" name="createBtn" value="팀 생성" /> <input
				type="button" id="backBtn" name="backBtn" value="취소" />
		</form>
	</div>
</body>
</html>