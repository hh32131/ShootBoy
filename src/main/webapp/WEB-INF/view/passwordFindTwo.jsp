<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$().ready(function(){
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
</script>
</head>
<body>
	<form>
		<span>비밀번호 찾기 힌트입니다.</span>
		<span>${userInfo.passwordHint}</span>
		<input type="text" id="answer" name="answer" placeholder="비밀번호 답을 입력하세요">
		<input type="button" id="nextBtn" name="nextBtn" value="다음">
		<input type="button" id="cancelBtn" name="cancelBtn" value="취소">
	</form>
</body>
</html>