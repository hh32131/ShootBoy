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
				<a href="/ShootBoy/adminInfo" style="color:#a1a1a1; text-decoration: none;"> 관리자 정보 </a>  |  
				<a href="/ShootBoy/adminSetting" style="color:#a1a1a1; text-decoration: none;">환경 설정</a>  | 
				<a href="/ShootBoy/main" style="color:#a1a1a1; text-decoration: none;">ShootBoy</a>  | 
				<a href="/ShootBoy/signIn" style="color:red; text-decoration: none;">로그인</a>
				
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
			  	<a href="/ShootBoy/adminTeam" class="dropbtn">팀 관리</a>
			  		<div class="dropdown-content">
				  		<a href="/ShootBoy/adminTeam">팀 관리 </a>
				  		<a href="/ShootBoy/adminTeamBoard">팀 게시판</a>
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
				      <a href="/ShootBoy/adminArticle">게시판 관리</a>
				    </div>
			</li>
		</div>
	</div>

