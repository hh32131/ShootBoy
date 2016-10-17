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
		
		$("#signBtn").click(function(){
			$("#signForm").attr({
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
		<a href="/ShootBoy/main" class="signInTitle">Shoot Boy</a>
	<form id="signForm" name="signForm">
		<input type="hidden" id="Referer" name="Referer" value="${Referer}">
		<input type="text" id="userEmail" name="userEmail" placeholder="Id">
		<input type="password" id="password" name="password" placeholder="password">
		<input type="button" id="signBtn" name="signBtn" value="로그인">
	<div class="subSignForm">
		<a href="/ShootBoy/signUp">회원가입</a> | 
		<a href="/ShootBoy/passwordFind">비밀번호 찾기</a>
	</div>
	</form>
	</div>
</body>
</html>