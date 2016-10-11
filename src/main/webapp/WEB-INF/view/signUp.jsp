<%@page import="net.Y5M2.location.vo.LocationVO"%>
<%@page import="net.Y5M2.location.dao.LocationDaoImpl"%>
<%@page import="net.Y5M2.location.dao.LocationDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	LocationDao dao = new LocationDaoImpl();
	
	List<LocationVO> locations	= dao.getLocations();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		
		$("#cancelBtn").click(function(){
			location.href="/ShootBoy/signUp";
		});
		
		
		
		
		
		$("#signBtn").click(function(){
			if($("#email")==null){
				alert("아이디를 입력하세요");
				return;
			};
			if($("#userName")==null){
				alert("닉네임를 입력하세요");
				return;
			};
			if($("#password1")==null){
				alert("비밀번호를 입력하세요");
				return;
			};
			if($("#password2")==null){
				alert("비밀번호를 입력하세요");
				return;
			};
			if($("#password1") != $("#password1")){
				alert("비밀번호가 일치하지 않습니다.");
				return;
			};
			
			
			
			$("#signUpForm").attr({
				"method": "post",
				"action": "/ShootBoy/doSignUp"
			}).submit();
		});
		
	});
	


</script>
</head>
<body>

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

</body>
</html>