<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/grid.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/hsh.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signUp.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/board.css">

<title>Shoot Boy</title>
</head>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/ShootBoy/js/jquery.cycle2.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	

});
	
</script>
<body>
	<h1>
		<a href="/ShootBoy/main"><img class="headerImg"
			src="/ShootBoy/img/팀로고.png" /></a> Shoot Boy
	</h1>
	<bgsound src="[Abba] Happy New Year.wma" loop="0">
	<div id="mainHeader">
		<c:choose>
			<c:when test="${empty sessionScope._USER_INFO_}">
				<div class="mainRight">
					<a href="/ShootBoy/main">홈</a> | <a href="/ShootBoy/signUp">회원가입</a> | <a href="/ShootBoy/signIn">로그인</a>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="mainRight">
					<a href="/ShootBoy/main">홈</a> | <a href="/ShootBoy/logout">로그아웃</a>
				</div>
			</c:otherwise>
		
		</c:choose>

		<div id="headwrapper">
			<div id="navi" class="inline">
				<ul>
					<li class="active"><a href="#">My page</a>
						<ul>
						<c:if test="${!empty sessionScope._USER_INFO_}">
							<li><a href="/ShootBoy/userInfo">내 정보</a></li>
							<li><a href="/ShootBoy/detailTeamInfo">팀 정보</a></li>
							<li><a href="/ShootBoy/teamMatchInfo">팀 매치 정보</a></li>
							<li><a href="/ShootBoy/message">메시지함</a></li>
						</c:if>
						</ul>
					</li>

					<li><a href="#">Match</a>
						<ul>
							<li><a href="/ShootBoy/matchBoard">매치보드</a></li>
							<li><a href="/ShootBoy/matchApply">매치신청</a></li>
							<li><a href="/ShootBoy/matchApplyManagement">매치 신청 관리</a></li>
						</ul></li>

					<li><a href="#">Team</a>
						<ul>
							<li><a href="/ShootBoy/remove">전체 팀 보기</a></li>
						</ul></li>

					<li><a href="/ShootBoy/list">Community</a>
						<ul>
							<li><a href="/ShootBoy/list?categoryId=11">공지사항</a></li>
							<li><a href="/ShootBoy/list?categoryId=12">가입인사</a></li>
							<li><a href="/ShootBoy/list?categoryId=13">자유게시판</a></li>
							<li><a href="/ShootBoy/list?categoryId=14">국내축구소식</a></li>
							<li><a href="/ShootBoy/list?categoryId=15">해외축구소식</a></li>
							<li><a href="/ShootBoy/list?categoryId=16">축구동영상</a></li>
							<li><a href="/ShootBoy/list?categoryId=17">축구갤러리</a></li>
							<li><a href="/ShootBoy/list?categoryId=18">매치경기후기</a></li>
							<li><a href="/ShootBoy/list?categoryId=19">모집게시판</a></li>
						</ul>
						</li>
				</ul>
			</div>
			<div class="cycle-slideshow" data-cycle-timeout=2000>
				<img src="/ShootBoy/img/경기장.png">
				<img src="/ShootBoy/img/호날두.jpg">
				<img src="/ShootBoy/img/메시.jpg">				
				<img src="/ShootBoy/img/손흥민.jpg">
			</div>		
		</div>
	</div>
