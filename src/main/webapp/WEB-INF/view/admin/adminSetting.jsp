<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
	  var memberSelect = ($("input[type=radio][name=memberList]:checked").val());
	  var teamSelect = ($("input[type=radio][name=teamList]:checked").val());
	  var teamArticleSelect = ($("input[type=radio][name=teamArticleList]:checked").val());
	  var gameSelect = ($("input[type=radio][name=gameList]:checked").val());
	  var articleSelect = ($("input[type=radio][name=articleList]:checked").val());
	  
	  $('input:radio[name=memberList]:input[value=' + memberSelect + ']').attr("checked", true);
	  $('input:radio[name=memberList]:input[value=' + teamSelect + ']').attr("checked", true);
	  $('input:radio[name=memberList]:input[value=' + teamArticleSelect + ']').attr("checked", true);
	  $('input:radio[name=memberList]:input[value=' + gameSelect + ']').attr("checked", true);
	  $('input:radio[name=memberList]:input[value=' + articleSelect + ']').attr("checked", true);
	
	  confirm(memberSelect);
		
	  $(".list").click(function () {
		  $.post("/ShootBoy/doCheckList", "", function(data) {
			 $("#memberForm").html(data);
		  });
	  })
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
				<input type="radio" class="list" name="memberList" value=10 checked="checked"  > 10개씩 보기 <br/>
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
				<input type="radio" class="list" name="teamList" value="10" checked="checked"  > 10개씩 보기 <br/>
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
				<input type="radio" class="list" name="teamArticleList" value="10" checked="checked"  > 10개씩 보기 <br/>
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