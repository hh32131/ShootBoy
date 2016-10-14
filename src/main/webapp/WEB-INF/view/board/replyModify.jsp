<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#check").click(function () {
			if( confirm("수정 하시겠습니까?") ) {
				location.href="";
			}
		});
		
		$("cancel").click(function() {
			close();
		});
	});
</script>
</head>
<body>

	<textarea id="replyModify" name="replyModify" placeholder="내용을 적어주세요" ></textarea>
	<input type="button" id="check" name="check" value="수정하기"/>
	<input type="button" id="cancel" name="cancel" value="취소"/>
	
</body>
</html>