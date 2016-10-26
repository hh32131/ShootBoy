<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/layout.css">
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/page.css">

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		
		$("#locationId").change(function(){
			$.post("/ShootBoy/checkLocation",{"locationId": $("#locationId").val()}, function(data) {
				$("#leafLocation option").remove();
				$("#leafLocation").html(data); 
			});
		});
		
		$("#backBtn").click(function() {
			if (confirm("정말 취소하시겠습니까?")) {
				closeWin();
			}
		});
		
		$("#checkTeamName").click(function () {
			$.post("/ShootBoy/doCheckTeamName", 
					{ "teamName" : $("#teamName").val() }, function(data){
				if(data=="false") {
					$("#teamNameCheck").html("사용 가능한 팀 이름입니다.").css("color","blue");
;					$("#teamCreateBtn").slideDown();
				}
				else {
					$("#teamNameCheck").html("중복된 팀 이름입니다.").css("color","red");
					$("#teamCreateBtn").hide();
				}
			});
		
		});
		
		$("#teamCreateBtn").click(function() {
				
			if ( $("#teamName").val() == "") {
				alert("팀명을 입력해주세요.");
				$("#teamName").focus();
				return;
			}
			
			else if ( $("#teamCount").val() == 0 ) {
				alert("팀원수를 작성해주세요.");
				$("#teamCount").focus();
				return;
			}
			
			else if ( $("#teamInfo").val() == "" ) {
				alert("소개글을 작성해주세요.");
				$("#teamInfo").focus();
				return;
			}
			else if ( $("#locationId").val() == "거주 지역을 선택하세요" ) {
				alert("거주 지역을 선택해주세요.");
				return;
			}
			else if ( $("#leafLocation").val() == "상세 지역을 선택하세요" ) {
				alert("상제 지역을 선택해주세요.");
				return;
			}
			
			if (confirm("생성하시겠습니까?")) {
				// 나중에 한번더 확인 하기!
				if ( $("#teamNameCheck").text().length < 13 ) {
					alert("중복체크를 해주시기 바랍니다.");
				}
				else {
					$("#craeteTeamForm").attr({
					"method" : "post",
					"action" : "/ShootBoy/doCreateTeam"
					}).submit(); 
				}
			}
			
		});

	});
	
	function closeWin() {
		close();
	}
	
</script>
</head>
<body>
	<div id="createTeamWrapper" style= "margin: 0 auto; width: 600px">
		<div class="createTeamText" style="color: #518cf0;">
		<h1>CREATE TEAM</h1></div>
		<form id="craeteTeamForm" name="createTeamForm"	enctype="multipart/form-data" >
			<div>
				<div class="inline-block" style="border-radius: 8px;">
<<<<<<< HEAD
					<input type="text" style=" width: 255px; height: 25px; border-radius: 8px; margin-bottom: 20px;" id="teamName" name="teamName" placeholder="팀명" />
					<div id="teamNameCheck"></div>
					<input type="button" id="checkTeamName" name="checkTeamName" value="중복체크" />
=======
					<input type="text"
						style=" width: 255px; height: 25px; border-radius: 8px; margin-bottom: 5px;"
						id="teamName" name="teamName" placeholder="팀명" />
						<div id="teamNameCheck" style="vertical-align: top; margin-bottom: 5px;"></div>
					<input type="button" id="checkTeamName" name="checkTeamName" value="중복체크"
							style="background-color: #000; color: #fff; margin-bottom: 20px;" />
>>>>>>> 31f1da4bc582b588455cb7ee809c53d5b361d358
				</div>
	
				<div class="inline-block" style="vertical-align: top;">
					<input type="text"
						style=" width: 75px; height: 30px; border-radius: 8px;"
						id="teamCount" name="teamCount" placeholder="팀원 수"/>
				</div>
			</div>
		<select id="locationId" name="locationId" style="border-radius: 5px">
			<option>거주 지역을 선택하세요</option>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
	 	</select>
		<select name="leafLocation" id="leafLocation" style="border-radius: 5px; margin-bottom: 20px;">
			<option>상세 지역을 선택하세요 </option>
		</select>
			<div style="height: 8px;"></div>
			<div>
				<textarea id="teamInfo" name="teamInfo"
					style="width: 350px; height: 250px; border-radius: 10px; margin-bottom:20px;
					font-size: 15px;" placeholder="소개글을 입력하세요."></textarea>
			</div>
			<input type="file" id="file" name="file" style="width: 220px; back" /> 
			<input type="button" id="teamCreateBtn" 
					name="teamCreateBtn" value="팀 생성" 
					style="margin-left: 60px; width: 60px; border-radius: 200px; "/>			  
		</form>
	</div>
</body>
</html>