</html><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>


<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>

<div id="wrapper">
	<div class="tableAndLogin">
		<div class="table">
			<table class="grid">
				<tr class="one">
					<th colspan="4">최근 성사된 경기일정</th>
				</tr>
				<tr class="containerOne">
					<td>팀이름</td>
					<td>지역</td>
					<td>날짜</td>
					<td>시간</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</table>
			<table class="grid">
				<tr class="two">
					<th colspan="4">최근 경기 결과</th>
				</tr>
				<tr class="containerTwo">
					<td colspan="4"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="login">
			<div class="sublogin">
				<div class="header" style="font-weight: bold; font-size: 20px;">로그인</div>
				<div class="loginContent">
					<input type="text" id="userEmail" name="userEmail"
						placeholder="아이디를 입력해주세요" style="width: 150px;" /><br /> <input
						type="password" id="userPassword" name="userPassword"
						placeholder="비밀번호를 입력해주세요" style="width: 150px;" /><br />
				</div>
			</div>
			<div class="signButton">
				<input type="button" id="signInBtn" value="로그인" />
			</div>
		</div>
	</div>

	<div id="naviList">
		<ul>
			<li><a class="active" href="#">공지사항</a></li>
			<li><a href="#">자유게시판</a></li>
			<li><a href="#">국내축구소식</a></li>
			<li><a href="#">해외축구소식</a></li>
		</ul>
	</div>
</div>



<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>