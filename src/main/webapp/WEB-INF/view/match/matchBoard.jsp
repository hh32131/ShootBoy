<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">
<script type="text/javascript">
	$().ready(function(){
		var locationId = $(".location").data("");
		
		$("#matchEnroll").click(function(){
			window.open("/ShootBoy/matchApply","","width=500, height=500");
		});
		
		$(".location").click(function(){
			$.post("/ShootBoy/doSelectMatch",{"locationId":$(this).data("value")},function(data){
				$("#matchList").html(data);
			});
		});
	
	});
</script>
<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmThree"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
<<<<<<< HEAD
	<form id="filter" name="filter">
	<div class="myInfoText"><h1>매치 보드</h1>
		<hr class="myPageline">
=======
	<div class="myInfoText" style="width:700px;"><h1>매치 보드</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
>>>>>>> 3850cd6332bcac2eb6268aaba784d41eb90c1bd1
	<div id="locationNavi">
		<ul>
		  <li><a class="active" href="#">전체</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="4">서울</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="5">경기</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="6">강원</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="7">충청</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="8">전라</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="9">제주</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="10">경상</a></li>
		</ul>
	</div>
	<div id="matchList" ></div>
	</div>
	</form>
	<a href="javascript:void(0);" id="matchEnroll">매치등록</a>
</body>
</html>