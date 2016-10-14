<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#nextBtn").click(function(){
			$.post("/ShootBoy/doCheckEmail",{"email" : $("#email").val()},
					function(data){
						if(data=="false"){
							alert("존재하지 않는 아이디입니다.");
							
						}
						else{
							$("#findForm").attr({
								"method": "post",
								"action": "/ShootBoy/passwordFindTwo"
							}).submit();
						}
			});
		});
		$("#cancelBtn").click(function(){
			close();
		});
		
	});

</script>
</head>
<body>
	<form id="findForm">
		<span>아이디를 입력해주세요</span><br/>
		<input type="text" id="email" name="email" placeholder="이메일을 입력해주세요" >
		<input type="button" id="nextBtn" value="다음">
		<input type="button" id="cancelBtn" value="취소">
	</form>

</body>
</html>