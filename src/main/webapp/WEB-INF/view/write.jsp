<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		moveToCenter();
		$("#goBackBtn").click(function() {
			location.href="/ShootBoy/list";
			
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
 	function moveToCenter() {
 		
 		var windowHeight = $(window).height();
 		var wrapperHeight = $("#wrapper").height();
 		var middlePosition = (parseInt(windowHeight) / 2) 
 								- (parseInt(wrapperHeight) / 2);
 		
 		$("#wrapper").css({
 			"position": "relative"
 			, "top": middlePosition + "px"
 		});
 		};
</script>

<title>Insert title here</title>
</head>
<body>

	<div id="wrapper" style="width: 700px;">
		<div><h1>WRITE BOARD</h1></div>
		<form id="writeForm" name="writeForm" enctype="multipart/form-data">
			<div>
				<input type="text"  style="width:700px; height: 25px; border-radius: 10px;" id="boardSubject" name="boardSubject" placeholder="제목을 입력하세요." />
			</div>
			<div style="height: 10px;">
			</div>
			<div>
				<textarea id="boardContent" style="width:700px; height: 250px; border-radius: 10px;" name="boardContent" placeholder="내용을 입력하세요."></textarea>
			</div>
			<div>
				<input type="file" id="file" name="file"/>
				<input type="button" id="goBackBtn" name="writeBtn" value="뒤로가기" />
				<input type="button" id="writeBtn" name="goBackBtn" value="글쓰기" />
			</div>
		</form>
	</div>
</body>
</html>