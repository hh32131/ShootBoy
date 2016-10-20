<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminMain.css" />

<title>Administrator</title>

<body>

	<div class="header">
		<div class="top">

			<div class="admin-logo">
				<a class="adminMain"; href="/ShootBoy/admin">ADMINISTRATOR</a>
			</div>
			
			<div class="top-right">
				<a > 관리자 정보 </a>  |  <a>기본 환경</a>  |  <a> ShootBoy </a>  |  <a style="color: red"> 로그인 </a>
			</div>
		</div>
		
		<div class="bottom">
			<li class="dropdown"> 
				<div class="blank"></div>
			</li>
			<li class="dropdown">
			  	<a href="/ShootBoy/adminMember" class="dropbtn">회원 관리</a>
			  		<div class="dropdown-content">
				  		<a href="/ShootBoy/adminUser/init">회원 관리 </a>
				  	</div>
			</li>
				
			<li class="dropdown">
			  	<a href="/ShootBoy/removeTeam" class="dropbtn">팀 관리</a>
			  		<div class="dropdown-content">
				  		<a href="/ShootBoy/removeTeam">팀 관리 </a>
				  	</div>
			</li>
			
			<li class="dropdown">
			  	<a href="/ShootBoy/adminGame" class="dropbtn">경기 관리</a>
			  		<div class="dropdown-content">
			  			<a href="/ShootBoy/adminGame">경기 관리 </a>
			  		</div>
			</li>
			
			<li class="dropdown">
			    <a href="/ShootBoy/adminArticle" class="dropbtn">게시판 관리</a>
				    <div class="dropdown-content">
				      <a href="/ShootBoy/adminArticle/init">게시판 관리</a>
				    </div>
			</li>
		</div>
	</div>

