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

		
		$("#signInBtn").click(function(){
			$.post("/ShootBoy/doSignIn",$("#signInForm").serialize(), function(data){
				$("#passwordreturn").html(data);
			});
		
		/* $("#signInBtn").click(function() {
			$("#signInForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doSignIn"
			}).submit(); */
		}); 
	});

	function openWin() {
		window.open("/ShootBoy/createTeam", "",
				"width=900, height= 600");
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
	</div>
	
	<div class="tableThree">
			<div class="textThree" style="display: inline-block;">BOARD</div>
			<div class="textRight" style="display: inline-block; margin-left: 290px;">
				<a href="/ShootBoy/list">▶ 게시판 더보기</a>
			</div>
		<table class="grid">
			<tr class="two">
				<th colspan="4" style="background-color: #deaf41;">Community</th>
			</tr>
			<c:forEach items="${boards}" var="boards" begin="0" end="5">
				<tr class="containerThree">
					<td>
						<a href="/ShootBoy/board/detail?boardId=${boards.boardId}" style="color:#8a642b;">${boards.boardSubject} [${boards.replayHitCount}]</a>
					</td>
					<td>
						${boards.userVO.userName}
					</td>
					<td>
						<span style="margin-left: 50px;">${boards.createDate}</span>
					</td>
					<td>
						${boards.hitCount}
					</td>
				</tr>
			</c:forEach>
		</table>
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
							<div id="passwordreturn"></div>
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
						<c:if test="${empty sessionScope._USER_INFO_.teamId}">
						<div class="teamCreateButton">
							<input type="button" id="teamCreateBtn" value="팀 생성"  onclick="openWin()"/>
						</div>
						</c:if>
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

