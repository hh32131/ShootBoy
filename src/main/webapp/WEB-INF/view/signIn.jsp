<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css"  >
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signIn.css"  >
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		moveToCenter();
		
		$("#cancelBtn").click(function(){
			location.href="/ShootBoy/signIn"
		});
		
		$("#userEmail").keyup(function(){
			if($(this).val()==null){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
		});
		
		$("#password").keyup(function(){
			if($(this).val()==null){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
		});
		
		$("#signInBtn").click(function(){
			$("#signInForm").attr({
				"method": "post",
				"action": "/ShootBoy/doSignIn"
			}).submit();
		});
	});
	
	$(window).resize(function() {
		moveToCenter();
	});
		
	function moveToCenter() {
		var windowHeight = $(window).height();
		var wrapperHeight = $("#signInWrapper").height();
		var middlePosition = (windowHeight / 2) 
								- (parseInt(wrapperHeight) / 2);
		
		$("#signInWrapper").css({
			"position": "relative"
			, "top": middlePosition+ "px"
			, "margin": "0 auto"
		});
	}

</script>
</head>
<body>
	
	<div id="signInWrapper">
		<h3 class="signInTitle">Shoot Boy</h3>
	<form id="signForm" name="signForm">
		<input type="hidden" id="Referer" name="Referer" value="${Referer}">
		<input type="text" id="userEmail" name="userEmail" placeholder="이메일를 입력해주세요">
		<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
		<input type="button" id="signInBtn" name="signBtn" value="로그인">
		<input type="button" id="cancelBtn" name="cancelBtn" value="취소">
	</form>
	</div>
</body>
</html>