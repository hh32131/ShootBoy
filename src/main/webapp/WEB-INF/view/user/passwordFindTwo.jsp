<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signIn.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">

	$().ready(function(){
		
			moveToCenter();
			
		$("#cancelBtn").click(function(){
			close();
		});
		
		$("#nextBtn").click(function(){
			if($("#answer").val()=="${userInfo.passwordAnswer}"){
				if(confirm("비밀번호는 '${userInfo.password}' 입니다. 확인을 누르면 홈화면으로 이동됩니다." )){
					location.href="/ShootBoy/main"
				}
				
			}
			else{
				alert("질문의 답이 틀렸습니다.");
			}
		});
	});
	
	function moveToCenter() {
		var windowHeight = $(window).height();
		var wrapperHeight = $("#findTwoWrapper").height();
		var middlePosition = (windowHeight / 2) 
								- (parseInt(wrapperHeight) / 2);
		
		$("#findTwoWrapper").css({
			"position": "relative"
			, "top": middlePosition+ "px"
		});
	}
</script>
</head>
<body>
	<div id="passwordHome">
		<a href="/ShootBoy/main" >홈</a> | <a href="/ShootBoy/signIn" >로그인</a>
	</div>
	<div id="findTwoWrapper">
		<form id="findForm">
			<div class="passwordFind"><span>비밀번호 찾기</span>
				<hr style="border: 1px solid">
			</div>
			<div class="findTextOne"><span>비밀번호 찾기 힌트입니다</span></div>
			<div class="findTextTwo"><span>힌트 : ${userInfo.passwordHint}</span></div>
			<input type="text" id="answer" name="answer" placeholder="비밀번호 힌트의 답을 입력하세요">
			<div><input type="button" id="nextBtn" name="nextBtnTwo" value="다음"></div>
		</form>
	</div>
</body>
</html>