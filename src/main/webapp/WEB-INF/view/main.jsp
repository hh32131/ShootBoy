</html><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>


<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	jQuery(function($){
		// List Tab Navigation
		var $tab_list = $('#naviList');
		$tab_list.removeClass('jx').find('ul ul');
		$tab_list.find('li li.active').parents('li').addClass('active');
		$tab_list.find('li.active>ul').show();
		$tab_list.each(function(){
			var $this = $(this);
			$this.height($this.find('li.active>ul').height()+40);
		});
		function listTabMenuToggle(event){
			var $this = $(this);
			$this.next('ul').show().parent('li').addClass('active').siblings('li').removeClass('active').find('>ul').hide();
			$this.closest('#naviList').height($this.next('ul').height()+40);
			if($this.attr('href') === '#'){
				return false;
			}
		}
		$tab_list.find('>ul>li>a').click(listTabMenuToggle).focus(listTabMenuToggle);
	});
</script>

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
					<td>팀이름팀이름</td>
					<td>서울시 강남구</td>
					<td>2016-10-10</td>
					<td>13:10</td>
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
				<div class="loginHeader" style="font-weight: bold; font-size: 20px;">로그인</div>
			<div class="sublogin">
				<div class="loginContent">
					<div><input type="text" id="userEmail" name="userEmail"
						placeholder="Id" /></div> 
					<div><input
						type="password" id="userPassword" name="userPassword"
						placeholder="password" /></div>
				</div>
				<div class="joinButton">
					<input type="button" id="signInBtn" value="로그인" />
				</div>
			</div>
			<div>
				<a href="">회원가입</a> | <a href="">아이디 찾기</a> | <a href="">비밀번호 찾기</a>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/commons/banner.jsp"></jsp:include>
	
	<div id="naviList">
		<ul>
			<li class="active"><a href="#"><span>공지사항</span></a>
				<ul>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 첫 번째 탭의 공지사항 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li class="more"><a href="#">공지사항 더보기</a></li>
				</ul>
			</li>

			<li><a href="#"><span>자유게시판</span></a>
				<ul>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 두 번째 탭의 자유게시판 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li class="more"><a href="#">자유게시판 더보기</a></li>
				</ul>
			</li>
			
			<li><a href="#"><span>국내축구소식</span></a>
				<ul>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 세 번째 탭의 국내축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li class="more"><a href="#">국내축구소식 더보기</a></li>
				</ul>
			</li>
			
			<li><a href="#"><span>해외축구소식</span></a>
				<ul>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li><a href="#">이것은 네 번째 탭의 해외축구소식 목록 입니다.</a> <span class="time">2010.12.24</span></li>
					<li class="more"><a href="#">해외축구소식 더보기</a></li>
				</ul>
			</li>
		</ul>
	</div>
	
	<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
</div>

