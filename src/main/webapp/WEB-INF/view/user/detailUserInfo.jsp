<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" >
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#password").hide();
		
		$("#modifyBtn").click(function(){
			$("#password").show();
			
			if($("#password").val() == ${userInfo.password}) {
				location.href="/ShootBoy/userModify";
			}
			else {
			$("div.warning").html("<p>비밀번호가 틀렸습니다.</p>").slideDown();
			}
			
		});
	});
</script>
</head>
<body>
	
	

</body>
</html>