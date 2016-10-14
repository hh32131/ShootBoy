<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/grid.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/signUp.css">
<title>Shoot Boy</title>
</head>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/ShootBoy/js/jquery.FadeWideBgImg.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	var myIndex = 0;
	carousel();

	function carousel() {
		
	    var i;
	    var x = document.getElementsByClassName("mainImgOne");
	    for (i = 0; i < x.length; i++) {
	       x[i].style.display = "none";  
	    }
	    myIndex++;
	    if (myIndex > x.length) {
	    	myIndex = 1;
	    }    
	    x[myIndex-1].style.display = "block";
	   
	  	setTimeout(carousel, 2000);

	}

});
	
</script>
<body>
	<h1>
		<a href="/ShootBoy/main"><img class="headerImg"
			src="/ShootBoy/img/팀로고.png" /></a> Shoot Boy
	</h1>

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
							<li><a href="/ShootBoy/userInfo">내 정보</a></li>
							<li><a href="#">팀 정보</a></li>
							<li><a href="#">팀 매치 정보</a></li>
							<li><a href="#">메시지함</a></li>
						</ul></li>

					<li><a href="#">Match</a>
						<ul>
							<li><a href="#">매치보드</a></li>
							<li><a href="#">매치신청</a></li>
							<li><a href="#">매치 신청 관리</a></li>
						</ul></li>

					<li><a href="#">Team</a>
						<ul>
							<li><a href="#">전체 팀 보기</a></li>
						</ul></li>

					<li><a href="#">Community</a>
						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">가입인사</a></li>
							<li><a href="#">자유게시판</a></li>
							<li><a href="#">국내축구소식</a></li>
							<li><a href="#">해외축구소식</a></li>
							<li><a href="#">축구동영상</a></li>
							<li><a href="#">축구갤러리</a></li>
							<li><a href="#">매치경기후기</a></li>
							<li><a href="#">모집게시판</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="mainImg">
				<img class="mainImgOne" src="/ShootBoy/img/경기장.png">
				<img class="mainImgOne" src="/ShootBoy/img/메시.jpg">
				<img class="mainImgOne" src="/ShootBoy/img/호날두.jpg">
			</div>		
		</div>
	</div>
