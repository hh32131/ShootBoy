<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "", "width=900, height= 600");
	}
	
</script>
	<button onclick="openWin()">팀생성하기</button>
	<div  id="wrapper" style="width: 700px;">
		<table>
			<c:forEach begin="1" end="4" step="1">
				<tr>
					<c:forEach items="${teams}" var="teams"  begin="0" end="4" step="1">
					
						<td align="center" class="teamtd">
							<div class="teamPhoto double"><span><a href=""><img class="teamPhoto" src="/ShootBoy/img/soccer.png" /></a></span></div>
							<div>${teams.teamName}</div>
							<div>${teams.teamCount}</div>
					 		<div>${teams.locationVO.locationName}-${teams.locationVO.parentLocationName}</div>
						
						</td>
						
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>