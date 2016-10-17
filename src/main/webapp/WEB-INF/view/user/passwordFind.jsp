<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signIn.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$().ready(function(){
		
		moveToCenter();
		
		$("#nextBtn").click(function(){
			$.post("/ShootBoy/doCheckEmail",{"email" : $("#email").val()},
					function(data){
						if(data=="false"){
							$("div.findWarning").html("<p>이메일이 존재하지않습니다. 다시 입력하세요.</p>");
						}
						else{
							$("#findForm").attr({
								"method": "post",
								"action": "/ShootBoy/passwordFindTwo"
							}).submit();
						}
			});
		});
		
	});
	
	$(window).resize(function() {
		moveToCenter();
	});
		
	function moveToCenter() {
		var windowHeight = $(window).height();
		var wrapperHeight = $("#findPasswordWrapper").height();
		var middlePosition = (parseInt(windowHeight) / 2) 
								- (parseInt(wrapperHeight) / 2);
		
		$("#findPasswordWrapper").css({
			"position": "relative"
			, "top": middlePosition + "px"
		});
	}

</script>
</head>
<body>
	<div id="passwordHome">
		<a href="/ShootBoy/main" >홈</a> | <a href="/ShootBoy/signIn" >로그인</a>
	</div>
	<div id="findPasswordWrapper">
		<form id="findForm">
			<div class="passwordFind"><span>비밀번호 찾기</span>
				<hr style="border: 1px solid">
			</div>
			<div class="passwordText"><span>비밀번호를 찾고자 하는 아이디를 입력해 주세요.</span></div>
			<div>
				<input type="text" id="email" name="email" placeholder="Id" >
				<div class="findWarning"></div>
			</div>
			<div class="findBtn">
				<input type="button" id="nextBtn" value="다음">
			</div>
		</form>
	</div>
</body>
</html>