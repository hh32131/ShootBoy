<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator</title>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminTeamCreate.css">
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
                    $("#teamNameCheck").html("사용 가능한 팀 이름입니다.")
                    $("#teamCreateBtn").slideDown();
                }
                else {
                    $("#teamNameCheck").html("중복된 팀 이름입니다.")
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
    <div class="teamCreate-header">
        <div class="teamCreate-top">
            <div class="teamCreate-admin-logo">
                <a href="/ShootBoy/admin" class="logo-text">ADMINISTRATOR</a>
            </div>
            <div class="teamCreate-shootboy-main">
                <a href="/ShootBoy/main" class="main-text"> ShootBoy </a> 
            </div>
        </div>
        
        <div class="bottom">
            <p class="teamCreate-title">팀 생성</p> 
        </div>
    </div>
    <div id="createTeamWrapper" >
        <form id="craeteTeamForm" name="createTeamForm"  enctype="multipart/form-data" >
            <div>
                <div class="team-name" >
                    <input type="text" id="teamName" name="teamName" placeholder="팀명" />
                </div>
                <input type="button" id="checkTeamName" name="checkTeamName" value="중복체크" />
                <div id="teamNameCheck"></div>
                <div class="team-member">
                    <input type="text" id="teamCount" name="teamCount" placeholder="팀원 수" />
                </div>
            </div>
            
            <div class="location">
                <select id="locationId" name="locationId" >
                    <option>거주 지역을 선택하세요</option>
                    <c:forEach items="${location}" var="location">
                        <option value="${location.locationId}">${location.locationName}</option>
                    </c:forEach>
                </select>
                <select name="leafLocation" id="leafLocation" >
                    <option> 상세 지역을 선택하세요 </option>
                </select>
            </div>
            <div class="filebox">
                <label for="fileBtn">파일 업로드</label>
                 <input type="file" id="fileBtn" name="file" back /> 
            </div>
            <textarea id="teamInfo" name="teamInfo"  placeholder="소개글을 입력하세요."></textarea>
            <div class="btn">
                <input type="button" id="teamCreateBtn" name="teamCreateBtn" value="팀 생성"/>           
                <input type="button" id="backBtn" name="backBtn" value="취소"/>
            </div>
        </form>
    </div>
<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />