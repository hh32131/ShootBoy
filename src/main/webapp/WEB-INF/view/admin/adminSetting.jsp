<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
	  $("#memberForm >.list").click(function () {
		  var memberValue = $("#memberForm >.list:checked").val();
		  $.post("/ShootBoy/doCheckList", {"memberValue":memberValue});
	  });
	  
	  $("#teamForm >.list").click(function () {
		  var teamValue = $("#teamForm >.list:checked").val();
		  $.post("/ShootBoy/doCheckListTwo", {"teamValue":teamValue});
	  });
	  
	  $("#teamArticleForm >.list").click(function () {
		  var teamArticleValue = $("#teamArticleForm >.list:checked").val();
		  $.post("/ShootBoy/doCheckListThree", {"teamArticleValue":teamArticleValue});
	  });
	  
	  $("#gameForm >.list").click(function () {
		  var gameValue = $("#gameForm >.list:checked").val();
		  $.post("/ShootBoy/doCheckListFour", {"gameValue":gameValue});
	  });
	  
	  $("#artcleForm >.list").click(function () {
		  var articleValue = $("#artcleForm >.list:checked").val();
		  $.post("/ShootBoy/doCheckListFive", {"articleValue":articleValue});
	  });
	  
	  
	  
	});

</script>

<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />


	<div class="setting-title">
		SETTING	
	</div>
	<div class="setting-line">
	</div>
	
	<div class="setting-wrapper">
		<div class="data-list">
			▶  회원 보기 설정
		</div>
		<div class="list-radio">
			<form id="memberForm" name="memberForm">
				<input type="radio" class="list" name="memberList" value=10 checked="checked" > 10개씩 보기 <br/>
				<input type="radio" class="list" name="memberList" value=15  > 15개씩 보기 <br/>
				<input type="radio" class="list" name="memberList" value=20  > 20개씩 보기 <br/>
			</form>
		</div>
		<div class="setting-line">
		</div>
		<div class="data-list">
			▶  팀 보기 설정
		</div>
		<div class="list-radio">
			<form id="teamForm" name="teamform">
				<input type="radio" class="list" name="teamList" value="10" checked="checked" > 10개씩 보기 <br/>
				<input type="radio" class="list" name="teamList" value="15"  > 15개씩 보기 <br/>
				<input type="radio" class="list" name="teamList" value="20"  > 20개씩 보기 <br/>
			</form>
		</div>
		<div class="setting-line">
		</div>
		<div class="data-list">
			▶  팀 게시판 보기 설정
		</div>
		<div class="list-radio">
			<form id="teamArticleForm" name="teamArticleForm">
				<input type="radio" class="list" name="teamArticleList" value="10"  checked="checked"> 10개씩 보기 <br/>
				<input type="radio" class="list" name="teamArticleList" value="15"  > 15개씩 보기 <br/>
				<input type="radio" class="list" name="teamArticleList" value="20"  > 20개씩 보기 <br/>
			</form>
		</div>
		<div class="setting-line">
		</div>
		<div class="data-list">
			▶  경기 보기 설정
		</div>
		<div class="list-radio">
			<form id="gameForm" name="gameForm">
				<input type="radio" class="list" name="gameList" value="10" checked="checked" > 10개씩 보기 <br/>
				<input type="radio" class="list" name="gameList" value="15"  > 15개씩 보기 <br/>
				<input type="radio" class="list" name="gameList" value="20"  > 20개씩 보기 <br/>
			</form>
		</div>
		<div class="setting-line">
		</div>
		<div class="data-list">	
			▶  게시판 보기 설정
		</div>
		<div class="list-radio">
			<form id="artcleForm" name="articleForm">
				<input type="radio" class="list" name="articleList" value="10" checked="checked"> 10개씩 보기 <br/>
				<input type="radio" class="list" name="articleList" value="15"  > 15개씩 보기 <br/>
				<input type="radio" class="list" name="articleList" value="20"  > 20개씩 보기 <br/>
			</form>
		</div>
	</div>
	
	

<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />