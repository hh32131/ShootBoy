<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	moveToCenter();
}

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

	function openWin() {
		window.open("http://10.225.152.163:8080/ShootBoy/createTeam", "",
				"width=900, height= 600");

	}
</script>
</head>

<body>
<<<<<<< HEAD
	<table>
		<tr>
			<td>
				
			</td>
		</tr>
	</table>
	<button onclick="openWin()">팀생성하기 </button>
=======
	<button onclick="openWin()">팀생성하기</button>
	<div  id="wrapper" style="width: 700px;">
		<table>
			<c:forEach begin="1" end="5" step="1">
				<tr>
					<c:forEach begin="1" end="5" step="1">

						<td align="center" class="teamtd">
							<div class="teamPhoto double">사진</div>
							<div>팀이름</div>
							<div>지역</div>
							<div>인원수</div> ${a}

						</td>

					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
>>>>>>> d1fd9bf9e787b5b189503ba1ef3ed4643b7306ab
</body>
</html>