<%@page import="net.Y5M2.location.vo.LocationVO"%>
<%@page import="net.Y5M2.location.dao.LocationDaoImpl"%>
<%@page import="net.Y5M2.location.dao.LocationDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	LocationDao dao = new LocationDaoImpl();
	
	List<LocationVO> locations	= dao.getLocations();
	
%>
=======
	pageEncoding="UTF-8"%>
>>>>>>> ab8f59ed4f7f0da9bd90591def4f1de3b28de6e0
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		moveToCenter();
		isVisibleButton();
		
		$("#cancelBtn").click(function() {
			location.href = "/ShootBoy/signUp";
		});

		$("#email").keyup(function(){
			$.post("/ShootBoy/doCheckEmail",{"email": $("#email").val()}, function(data){
				if(data == "false") {
					$("#email").addClass("pass");
					$("#email").removeClass("warning");
					
				}
				else {
					$("#email").removeClass("pass");
					$("#email").addClass("warning");
				}
				isVisibleButton();
			});
			
		});
		
		$("#userName").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#password1").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			if($(this).val()!=$("#password2").val()){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password2").addClass("warning");
				$("#password2").removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password2").addClass("pass");
				$("#password2").removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#password2").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			if($(this).val()!=$("#password1").val()){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password1").addClass("warning");
				$("#password1").removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password1").addClass("pass");
				$("#password1").removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#phoneNumber").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#age").change(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#position").change(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		
		
		$("#passwordHintKey").change(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		
		$("#passwordHintValue").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		
		$("#signBtn").click(function() {
			
			$("#signUpForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doSignUp"
			}).submit();
			
		});

	});
	
	
	$(window).resize(function() {
		moveToCenter();
	});
	
	
	function moveToCenter(){
		
		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight)/2) 
								-(parseInt(wrapperHeight)/2);
		
		$("#wrapper").css({
			"position": "relative"
			, "top": middlePosition + "px"
		});
		
	};
	
	function isVisibleButton(){
		if($(".pass").length==9){
			$("#signBtn").slideDown();
		}
		else{
			$("#signBtn").hide();
		}
		
	};
	
</script>
</head>
<body>
<<<<<<< HEAD

	<form id="signUpForm" name="signUpForm">
		<input type="text" id="email" name="email" placeholder="아이디를 입력하세요" >
		<input type="text" id="userName" name="userName" placeholder="이름을 입력하세요" >
		<input type="password" id="password1" name="password1" placeholder="비밀번호를 입력하세요">
		<input type="password" id="password2" name="password2" placeholder="비밀번호를 입력하세요">
		<input type="text" id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력해주세요">
		
		<select name="categoryId">
			<option>거주 지역을 선택하세요</option>
		<%-- 			<%
				for( LocationVO locationVO : locations){
			%>
			<option value="${location.locationId }"><%= categoryVO.getCategoryName()%></option>
			<% } %> --%>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
		</select>
		<select name="leafCategory">
			<option> 상세 지역을 선택하세요 </option>
		</select>
		
		<input type="date" id="age" name="age" placeholder="나이름 선택하세요">
		<select>
			<option selected="selected">포지션을 선택하세요</option>
			<option>골키퍼</option>
			<option>왼쪽 풀백</option>
			<option>오른쪽 풀백</option>
			<option>센터백</option>
			<option>스위퍼/리베로</option>
			<option>중앙 미드필더</option>
			<option>수비형 미드필더</option>
			<option>공격형 미드필더</option>
			<option>왼쪽 윙어</option>
			<option>오른쪽 윙어</option>
			<option>중앙 공격수</option>
			<option>세컨드 스트라이커</option>
		</select>
		<input type="button" id="signBtn" value="회원가입">
		<input type="button" id="cancelBtn" value="취소">
		<span>사진을 선택해주세요</span>
		<input type="file" id="imge" name="imge" >
		<select>
			
		</select>
	</form>

=======
	<div id="wrapper">
		<form id="signUpForm" name="signUpForm" >
				<input type="text" id="email" name="email" placeholder="아이디를 입력하세요"><br/>
				<input type="text" id="userName" name="userName"placeholder="이름을 입력하세요"> <br/>
				<input type="password"	id="password1" name="password1" placeholder="비밀번호를 입력하세요"> <br/>
				<input	type="password" id="password2" name="password2"	placeholder="비밀번호를 입력하세요"><br/>
				<span>비밀번호 힌트를 선택해 주세요</span><br/>
				<select id="passwordHintKey" name="passwordHintKey">
					<option selected="selected">질문을 선택하세요</option>
					<option>졸업한 초등학교 이름은?</option>
					<option>어머님의 성함은?</option>
					<option>아버지의 성함은?</option>
					<option>자신이 가장 좋아하는 음식은?</option>
				</select><br/>
				<input type="text" id="passwordHintValue" name="passwordHintValue" placeholder="질문의 답을 입력하세요"><br/>
				 <input type="text"	id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력해주세요"><br/>
				<select id="age">
					<option>나이를선택해주세요</option>
					<option>10 대</option>
					<option>20 대</option>
					<option>30 대</option>
					<option>50 대</option>
				</select><br/>
				 <select id="position" name="position">
					<option selected="selected">포지션을 선택해주세요</option>
					<option>골키퍼</option>
					<option>왼쪽 풀백</option>
					<option>오른쪽 풀백</option>
					<option>센터백</option>
					<option>스위퍼/리베로</option>
					<option>중앙 미드필더</option>
					<option>수비형 미드필더</option>
					<option>공격형 미드필더</option>
					<option>왼쪽 윙어</option>
					<option>오른쪽 윙어</option>
					<option>중앙 공격수</option>
					<option>세컨드 스트라이커</option>
				</select> <br/>
				
				<input type="button" id="signBtn" value="회원가입">
				<input type="button" id="cancelBtn" value="취소">
		</form>
	</div>
>>>>>>> ab8f59ed4f7f0da9bd90591def4f1de3b28de6e0
</body>
</html>