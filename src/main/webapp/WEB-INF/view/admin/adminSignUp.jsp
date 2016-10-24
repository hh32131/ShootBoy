<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="net.Y5M2.location.vo.LocationVO"%>
<%@page import="net.Y5M2.location.dao.LocationDaoImpl"%>
<%@page import="net.Y5M2.location.dao.LocationDao"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/ShootBoy/css/adminSignUp.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		isVisibleButton();
		
		$("#cancelBtn").click(function() {
			window.close();
		});

		$("#locationId").change(function() {
			$.post("/ShootBoy/checkLocation", {
				"locationId" : $("#locationId").val()
			}, function(data) {
				$("#leafCategory option").remove();
				$("#leafCategory").html(data);
			});
			isVisibleButton(); 
		});
		
		$("#checkUserEmail").click(function () {
			$.post("/ShootBoy/doCheckEmail", 
					{ "email" : $("#email").val() }, function(data){
				if(data=="false") {
					alert('사용 가능');
					$("#signBtn").slideDown();
				}
				else {
					alert('사용 불가');
					$("#signBtn").hide();
				}
			});
			isVisibleButton();
		});

		$("#userName").keyup(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
		$("#password1").keyup(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			if ($(this).val() != $("#password2").val()) {
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password2").addClass("warning");
				$("#password2").removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password2").addClass("pass");
				$("#password2").removeClass("warning");
			}
			isVisibleButton();
		});
		$("#password2").keyup(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			if ($(this).val() != $("#password1").val()) {
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password1").addClass("warning");
				$("#password1").removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password1").addClass("pass");
				$("#password1").removeClass("warning");
			}
			isVisibleButton();
		});

		$("#phoneNumber").keyup(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
		});

		$("#age").change(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});

		$("#position").change(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});

		$("#passwordHintKey").change(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});

		$("#passwordHintValue").keyup(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});

		$("#leafCategory").change(function() {
			if ($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleButton();
		});
	
		$("#signBtn").click(function() {
			$("#signUpForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doAdminSignUp"
			}).submit();
		});
	});
	
	function isVisibleButton() {
		if ($(".pass").length == 10) {
			$("#signBtn").slideDown();
		} else {
			$("#signBtn").hide();
		}
	};
</script>
<title>Administrator</title>
<body>
	<div class="member-header">
		<div class="member-top">
			<div class="member-admin-logo">
				<a href="/ShootBoy/admin" class="logo-text">ADMINISTRATOR</a>
			</div>

			<div class="member-shootboy-main">
				<a href="/ShootBoy/main" class="main-text"> ShootBoy </a>
			</div>
		</div>

		<div class="bottom">
			<p class="member-join">회원 등록</p>
		</div>
	</div>

	<div id="wrapperSignUp">
		<form id="signUpForm" name="signUpForm">
			<div class="signText">기본정보 및 개인정보 입력</div>
			<div class="checkUserEmail">
			아이디 <input type="text" id="email" name="email"
				placeholder="아이디를 입력하세요">
				<input type="button" id="checkUserEmail" name="checkUserEmail" value="중복체크" />
			</div>
				이름 <input type="text" id="userName" name="userName"
				placeholder="이름을 입력하세요"> <br /> 비밀번호 <input type="password"
				id="password1" name="password1" placeholder="비밀번호를 입력하세요"> <br />
			비밀번호 확인 <input type="password" id="password2" name="password2"
				placeholder="비밀번호를 입력하세요"><br /> <span>비밀번호 힌트를 선택해
				주세요</span><br /> <select id="passwordHintKey" name="passwordHintKey">
				<option selected="selected">질문을 선택하세요</option>
				<option>졸업한 초등학교 이름은?</option>
				<option>어머님의 성함은?</option>
				<option>아버지의 성함은?</option>
				<option>자신이 가장 좋아하는 음식은?</option>
			</select><br /> <input type="text" id="passwordHintValue"
				name="passwordHintValue" placeholder="질문의 답을 입력하세요"><br />
			전화번호 <input type="text" id="phoneNumber" name="phoneNumber"
				placeholder="전화번호를 입력해주세요"><br /> 나이 <select id="age"
				name="age">
				<option>나이를선택해주세요</option>
				<option>10대</option>
				<option>20대</option>
				<option>30대</option>
				<option>40대</option>
				<option>50대</option>
			</select><br /> 포지션 <select id="position" name="position">
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
			</select> <br /> 거주 지역 <select id="locationId" name="locationId">
				<option>거주 지역을 선택하세요</option>
				<c:forEach items="${location}" var="location">
					<option value="${location.locationId}">${location.locationName}</option>
				</c:forEach>
			</select><br /> 상세 지역 <select name="leafCategory" id="leafCategory">
			</select>
			<div id="btn">
				<input type="button" id="signBtn" value="회원가입"> <input
					type="button" id="cancelBtn" value="취  소">
			</div>
		</form>
	</div>

	<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />