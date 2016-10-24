<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/match.css">
<script type="text/javascript">
	$().ready(function(){
		$("#matchEnroll").click(function(){
			window.open("/ShootBoy/matchApply","","width=500, height=500");
		});
		
		$(".location").click(function(){
			var locationId = $(this).data("value");
			$.post("/ShootBoy/doSelectMatch","locationId",function(data){
				$("#matchList").html(data);
				if($("")){
					
				}
			});
			
		});
		
	});
</script>
<body>
	<div id="myPageLeftMenu">
		<div class="mplmTitle">My Page</div>
		<div id="myPageLeftMenuTwo">
			<div class="mplmOne"><img src="/ShootBoy/img/화살표.jpg" class="arrow"><a href="/ShootBoy/matchBoard">매치 보드</a></div>
			<div class="mplmTwo"><a href="/ShootBoy/matchApply">매치 신청</a></div>
			<div class="mplmThree"><a href="/ShootBoy/matchApplyManagement">매칭 신청 관리</a></div>
		</div>
	</div>
	
	<div class="myInfoText"><h1>매치 보드</h1>
		<hr class="myPageline">
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
	<a href="javascript:void(0);" id="matchEnroll">매치등록</a>
	<div id="matchList" ></div>
	</div>
</body>
</html>