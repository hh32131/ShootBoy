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
			window.open("/ShootBoy/matchApply","","width=600, height=500");
		});
		
		$(".location").click(function(){
			console.log($(this).data("value"));
			$.post("/ShootBoy/doSelectMatch",{"locationId":$(this).data("value")}, function(data){
				$("#matchList").html(data);
			});
		});
	
		$("#matchList").on("click",".matchAgreementBtn",function() {
			var teamId = $(this).data("teamid");
			var matchId = $(this).data("matchid");
			var myTeamId = "${sessionScope._USER_INFO_.teamId}";
				if(myTeamId==teamId){
					alert("자신의 팀입니다.");
				}
				else{
					$.post("/ShootBoy/doCheckMatchRequest", {"matchId":$(this).data("matchid")}, function(data) {
						if (data =="false") {
							if( confirm("신청하시겠습니까?") ) {
								location.href="/ShootBoy/doMatchRequest?teamId="+teamId+"&&matchId="+matchId;
							}
						}
						else {
							alert("이미 신청하셨습니다.");
						}
					});
				}
		});

		$("#matchList").on("click", ".matchCancelBtn", function() {
			var teamId = $(this).data("teamid");
			var matchId = $(this).data("matchid");
			var myTeamId = "${sessionScope._USER_INFO_.teamId}";
			if ( myTeamId == teamId ) {
				if(confirm("삭제하시겠습니까?")){
					$.post("/ShootBoy/doDeleteTeamMatch", {"matchId":$(this).data("matchid")}, function(data) {
						if(data=="true"){
							alert("삭제하였습니다.");
							window.location.reload();
						}
						else{
							alert("매치 취소에 실패했습니다. 관리자에게 문의하세요");
						}
					});
				}
			}
			else {
				alert("해당 팀이 아닙니다.");
			}
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
	
	<div class="myInfoText" style="width:700px;"><h1>매치 보드</h1>
		<hr class="myPageline" style="width: 680px; margin-right: 100px;">
	<div id="locationNavi">
		<c:forEach items="${matchs}" var="match" >
			<div id="teamMatchWrapper">
				<div id="teamOne">
					<img class="teamOneImg" src="/ShootBoy/showImage?teamId=${match.teamVO.teamId}"/>
					<div class="teamOneName">${match.teamVO.teamName}</div>
				</div>
				<div id="matchFieldAndLocation">
					<img src="/ShootBoy/img/VS.png" class="vsImg">
					<div class="matchPlayField">${match.playField}</div>
					<div class="matchLocation">${match.locationVO.parentLocationName} 
												- ${match.locationVO.locationName}</div>
					<div class="matchShedule">${match.schedule}</div>
				</div>
				<div id="teamTwo">
					<img class="teamTwoImg" src="/ShootBoy/showImage?teamId=${match.awayTeamVO.teamId}">
					<div class="teamTwoName">${match.awayTeamVO.teamName}</div>
				</div>
			</div>			
		</c:forEach>
		
		<form id="pagingForm" name="pagingForm">
			<div style="margin-left: 330px; margin-bottom: 20px;">${paging}</div>
		</form>
		
	<div id="locationNavi" style="margin-bottom: 20px;">
	<c:if test="${!empty sessionScope._USER_INFO_.userId and !empty sessionScope._USER_INFO_.teamId }">
	<div style="font-size: 30px; width: 180px; background-color: #987d2e;
		margin-left: 250px; margin-top: 20px; margin-bottom: 20px; padding: 5px;">
			<a href="javascript:void(0);" id="matchEnroll" style="color: #fff;" >▷매치등록◁</a>
	</div>
	</c:if>
		<ul>
		  <li><a class="active location" href="javascript:void(0);" data-value="0">전체</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="4">서울</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="5">경기</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="6">강원</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="7">충청</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="8">전라</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="9">제주</a></li>
		  <li><a class="location" href="javascript:void(0);" data-value="10">경상</a></li>
		</ul>
	<br/>
	<br/>
	<br/>
	<br/>
	</div>
	<div id="matchList" style="margin-top: 20px;" ></div>
	
	</div>
</div>
	
<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
</div>

	

