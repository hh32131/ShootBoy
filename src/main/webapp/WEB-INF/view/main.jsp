</html><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>


<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
	jQuery(function($) {
		// List Tab Navigation
		var $tab_list = $('#naviList');
		$tab_list.removeClass('jx').find('ul ul');
		$tab_list.find('li li.active').parents('li').addClass('active');
		$tab_list.find('li.active>ul').show();
		$tab_list.each(function() {
			var $this = $(this);
			$this.height($this.find('li.active>ul').height() + 40);
		});
		function listTabMenuToggle(event) {
			var $this = $(this);
			$this.next('ul').show().parent('li').addClass('active').siblings(
					'li').removeClass('active').find('>ul').hide();
			$this.closest('#naviList').height($this.next('ul').height() + 40);
			if ($this.attr('href') === '#') {
				return false;
			}
		}
		$tab_list.find('>ul>li>a').click(listTabMenuToggle).focus(
				listTabMenuToggle);

		$("#userEmail").keyup(function() {
			if ($(this).val() == null) {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
		});

		$("#password").keyup(function() {
			if ($(this).val() == null) {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			} else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
		});

		$("#signInBtn").click(function() {
			$("#signInForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doSignIn"
			}).submit();
		});
	});
<<<<<<< HEAD
	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "",
				"width=900, height= 600");
=======
	
	function openWin() {
		window.open("http://localhost:8080/ShootBoy/createTeam", "",
				"width=500, height= 600");
>>>>>>> 51c86f315232a44220670953122bbed50b630bff
	}
</script>

<div id="wrapper">
	<div id="wrapperOne">
		<div class="tableOne">
			<div class="textOne">RECENT MATCH SCHEDULE</div>
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
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
				<tr class="contents">
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
				</tr>
			</table>
		</div>		
		
	
	<div class="tableTwo">
	<div class="textTwo">RECENT MATCH RESULT</div>
			<table class="grid">
				<tr class="two">
					<th colspan="4">최근 경기 결과</th>
				</tr>
				<tr class="containerTwo">
					<td colspan="4">adfasdfasdfasdfsfda<br/>adfasdfasdfasdf</td>
				</tr>
			</table>
<<<<<<< HEAD
		</div>
		<c:choose>
			<c:when test="${empty sessionScope._USER_INFO_}">
				<div class="login">
					<div class="loginHeader"
						style="font-weight: bold; font-size: 20px;">로그인</div>
					<div class="sublogin">
						<form id="signInForm" name="signInForm">
							<div class="loginContent">
								<div>
									<input type="text" id="userEmail" name="userEmail"
										placeholder="Id" />
								</div>
								<div>
									<input type="password" id="password" name="password"
										placeholder="password" />
								</div>
							</div>
						</form>
						<div class="joinButton">
							<input type="button" id="signInBtn" value="로그인" />
						</div>
					</div>
					<div>
						<a href="/ShootBoy/signUp">회원가입</a> | 
						<a href="/ShootBoy/passwordFind">비밀번호 찾기</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="login">
					<div class="loginHeader"
						style="font-weight: bold; font-size: 20px;">환영합니다</div>
					<div class="sublogin">
						<form id="informForm" name="informForm">
							<div class="loginContent">
								<div>${sessionScope._USER_INFO_.userName} 님</div>
								<div>${sessionScope._USER_INFO_.age}</div>
								<div>${sessionScope._USER_INFO_.position}</div>
							</div>
						</form>
						<div class="teamCreateButton">
							<button onclick="openWin()">팀생성</button>
						</div>
						<div class="OutButton">
							<input type="button" id="signOutBtn" value="로그아웃" onclick="location.href='/ShootBoy/logout'"/>
						</div>
					</div>
				</div>


				
			</c:otherwise>
		</c:choose>
=======
>>>>>>> 51c86f315232a44220670953122bbed50b630bff
	</div>
	
	<div id="naviBoard">
	<div class="textThree">BOARD</div>
	<div id="naviList">
		<ul>
			<li class="active"><a href="#"><span>공지사항</span></a>
				<ul>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li class="more"><a href="#">공지사항 더보기</a></li>
				</ul></li>

			<li><a href="#"><span>자유게시판</span></a>
				<ul>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li class="more"><a href="#">자유게시판 더보기</a></li>
				</ul></li>

			<li><a href="#"><span>국내축구소식</span></a>
				<ul>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li class="more"><a href="#">국내축구소식 더보기</a></li>
				</ul></li>

			<li><a href="#"><span>해외축구소식</span></a>
				<ul>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span
						class="time">2010.12.24</span></li>
					<li class="more"><a href="#">해외축구소식 더보기</a></li>
				</ul></li>
			</ul>	
		</div>
	</div>
</div>
	
	<div id="wrapperTwo">
	<c:choose>
			<c:when test="${empty sessionScope._USER_INFO_}">
				<div class="login">
					<div class="loginHeader"
						style="font-weight: bold; font-size: 20px;">로그인</div>
					<div class="sublogin">
						<form id="signInForm" name="signInForm">
							<div class="loginContent">
								<div>
									<input type="text" id="userEmail" name="userEmail"
										placeholder="Id" />
								</div>
								<div>
									<input type="password" id="password" name="password"
										placeholder="password" />
								</div>
							</div>
						</form>
						<div class="joinButton">
							<input type="button" id="signInBtn" value="로그인" />
						</div>
					</div>
					<div>
						<a href="/ShootBoy/signUp">회원가입</a> | 
						<a href="/ShootBoy/passwordFind">비밀번호 찾기</a>
					</div>
				</div>				
			</c:when>
			<c:otherwise>
				<div class="loginTwo">
					<div class="loginHeader"
						style="font-weight: bold; font-size: 20px;">환영합니다</div>
					<div class="sublogin">
						<form id="informForm" name="informForm">
							<div class="loginContent">
								<div>${sessionScope._USER_INFO_.userName} 님</div>
								<div>${sessionScope._USER_INFO_.age}</div>
								<div>${sessionScope._USER_INFO_.position}</div>
							</div>
						</form>
						<div class="teamCreateButton">
							<input type="button" id="teamCreateBtn" value="팀 생성"  onclick="openWin()"/>
						</div>
						<div class="OutButton">
							<input type="button" id="signOutBtn" value="로그아웃" onclick="location.href='/ShootBoy/logout'"/>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<jsp:include page="/WEB-INF/view/commons/banner.jsp"></jsp:include>
	</div>
</div>
	<div class="clear">
	<div style="padding-top: 60px;">
		<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>
	</div>

