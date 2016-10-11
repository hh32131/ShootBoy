<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css"  >
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#cancelBtn").click(function(){
			location.href="/ShootBoy/signIn"
		});
		
		$("#userId").keyup(function(){
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

</script>
</head>
<body>
	<form id="signInForm" name="signInForm">
		<input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요">
		<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
		<input type="button" id="signInBtn" name="signBtn" value="로그인">
		<input type="button" id="cancelBtn" name="cancelBtn" value="취소">
	</form>
</body>
</html>