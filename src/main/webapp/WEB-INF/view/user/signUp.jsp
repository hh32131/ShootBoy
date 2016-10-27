<%@page import="net.Y5M2.location.vo.LocationVO"%>
<%@page import="net.Y5M2.location.dao.LocationDaoImpl"%>
<%@page import="net.Y5M2.location.dao.LocationDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		//isVisibleButton();

		$("#cancelBtn").click(function() {
			location.href = "/ShootBoy/signUp";
		});

		$("#locationId").change(function() {
			$.post("/ShootBoy/checkLocation", {
				"locationId" : $("#locationId").val()
			}, function(data) {
				$("#leafCategory option").remove();
				$("#leafCategory").html(data);
			});
		});

		$("#email").keyup(function() {
			$.post("/ShootBoy/doCheckEmail", {
				"email" : $("#email").val()
			}, function(data) {
				if (data == "false") {
					$("#email").addClass("pass");
					$("#email").removeClass("warning");

				} else {
					$("#email").removeClass("pass");
					$("#email").addClass("warning");
				}
				isVisibleButton();
			});
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
			isVisibleButton();
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

			if($("input:checkBox[id='checkboxOne']").is(":checked") == false) {
				alert("회원가입약관에 동의하세요!");
				return;
			}
<<<<<<< HEAD
			else if($("input:checkBox[id='checkboxTwo']").is(":checked") == false) {
=======
			
			if($("input:checkBox[id='checkboxTwo']").is(":checked") == false) {
>>>>>>> 3412f280026cf561ac1fd5f103df6d8c526d6d64
				alert("개인정보취급방침에 동의하세요!");
				return;
			}
			
			$("#signUpForm").attr({
				"method" : "post",
				"action" : "/ShootBoy/doSignUp"
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
<div id="signUpText">
	<h1 class="lineText">회원가입</h1>
	<hr class="line">
	<div id="signUpClauseOne">☞회원가입약관</div>
	<textarea id="clauseOne" name="clauseOne">제 1 조 
(목적)이 약관은 비투컴(이하 "회사")이 제공하는 슛보이 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.

제 2 조 
(정의)이 약관에서 사용하는 용어의 정의는 다음과 같습니다.

① "서비스"라 함은 구현되는 단말기(PC, TV, 휴대형단말기 등의 각종 유무선 장치를 포함)와 상관없이 "회원"이 이용할 수 있는 슛보이 서비스를 의미합니다. 
② "회원"이라 함은 회사의 "서비스"에 접속하여 이 약관에 따라 "회사"와 이용계약을 체결하고 "회사"가 제공하는 "서비스"를 이용하는 고객을 말합니다. 
③ "아이디(ID)"라 함은 "회원"의 식별과 "서비스" 이용을 위하여 "회원"이 정하고 "회사"가 승인하는 문자와 숫자의 조합을 의미합니다. 
④ "비밀번호"라 함은 "회원"이 부여 받은 "아이디와 일치되는 "회원"임을 확인하고 비밀보호를 위해 "회원" 자신이 정한 문자 또는 숫자의 조합을 의미합니다. 
⑤ "유료서비스"라 함은 "회사"가 유료로 제공하는 각종 온라인디지털콘텐츠(각종 정보콘텐츠, VOD, 아이템 기타 유료콘텐츠를 포함) 및 제반 서비스를 의미합니다. 
⑥ "포인트"라 함은 서비스의 효율적 이용을 위해 회사가 임의로 책정 또는 지급, 조정할 수 있는 재산적 가치가 없는 "서비스" 상의 가상 데이터를 의미합니다. 
⑦ "게시물"이라 함은 "회원"이 "서비스"를 이용함에 있어 "서비스상"에 게시한 부호ㆍ문자ㆍ음성ㆍ음향ㆍ화상ㆍ동영상 등의 정보 형태의 글, 사진, 동영상 및 각종 파일과 링크 등을 의미합니다. 

제 3 조 (약관의 게시와 개정)

① "회사"는 이 약관의 내용을 "회원"이 쉽게 알 수 있도록 서비스 초기 화면에 게시합니다. 
② "회사"는 "약관의규제에관한법률", "정보통신망이용촉진및정보보호등에관한법률(이하 "정보통신망법")" 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다. 
③ "회사"가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 제1항의 방식에 따라 그 개정약관의 적용일자 30일 전부터 적용일자 전일까지 공지합니다. 다만, 회원에게 불리한 약관의 개정의 경우에는 공지 외에 일정기간 서비스 내 전자우편, 전자쪽지, 로그인시 동의창 등의 전자적 수단을 통해 따로 명확히 통지하도록 합니다. 
④ 회사가 전항에 따라 개정약관을 공지 또는 통지하면서 회원에게 30일 기간 내에 의사표시를 하지 않으면 의사표시가 표명된 것으로 본다는 뜻을 명확하게 공지 또는 통지하였음에도 회원이 명시적으로 거부의 의사표시를 하지 아니한 경우 회원이 개정약관에 동의한 것으로 봅니다. 
⑤ 회원이 개정약관의 적용에 동의하지 않는 경우 회사는 개정 약관의 내용을 적용할 수 없으며, 이 경우 회원은 이용계약을 해지할 수 있습니다. 다만, 기존 약관을 적용할 수 없는 특별한 사정이 있는 경우에는 회사는 이용계약을 해지할 수 있습니다. 					
</textarea>
	<div id="checkbox">
		<input type="checkbox">  위의 회원가입약관에 동의합니다.
	</div>

	<div id="signUpClauseTwo">☞개인정보취급방침</div>
	<textarea id="clauseTwo" name="clauseTwo">슛보이는 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.

슛보이는 회사는 개인정보처리방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

○ 본 방침은 2013년 12월 1일부터 시행됩니다.

1. 개인정보의 처리 목적 슛보이는 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적이외의 용도로는 사용되지 않으며 이용 목적이 변경될 시에는 사전동의를 구할 예정입니다.

가. 홈페이지 회원가입 및 관리
회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정이용 방지, 만14세 미만 아동 개인정보 수집 시 법정대리인 동의 여부 확인, 각종 고지·통지, 고충처리, 분쟁 조정을 위한 기록 보존 등을 목적으로 개인정보를 처리합니다.

나. 민원사무 처리
민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락·통지, 처리결과 통보 등을 목적으로 개인정보를 처리합니다.

다. 재화 또는 서비스 제공
서비스 제공, 콘텐츠 제공, 맞춤 서비스 제공, 요금결제·정산 등을 목적으로 개인정보를 처리합니다.

라. 마케팅 및 광고에의 활용
신규 서비스(제품) 개발 및 맞춤 서비스 제공, 이벤트 및 광고성 정보 제공 및 참여기회 제공 , 인구통계학적 특성에 따른 서비스 제공 및 광고 게재 , 서비스의 유효성 확인, 접속빈도 파악 또는 회원의 서비스 이용에 대한 통계 등을 목적으로 개인정보를 처리합니다.
</textarea>
	<div id="checkbox">
		<input type="checkbox" id="checkboxTwo">  위의 개인정보취급방침에 동의합니다.
	</div>
	<hr class="lineTwo">
</div>

<div id="wrapperSignUp">
	
	<form id="signUpForm" name="signUpForm">
		<div class="signText">기본정보 및 개인정보 입력</div>
		아이디 <input type="text" id="email" name="email" placeholder="아이디를 입력하세요"><br />
		이름 <input type="text" id="userName" name="userName"
			placeholder="이름을 입력하세요"> <br />
		비밀번호 <input type="password"
			id="password1" name="password1" placeholder="비밀번호를 입력하세요"> <br />
		비밀번호 확인 <input type="password" id="password2" name="password2"
			placeholder="비밀번호를 입력하세요"><br /> <span>비밀번호 힌트를 선택해
			주세요</span><br /> 
		<select id="passwordHintKey" name="passwordHintKey">
			<option selected="selected">질문을 선택하세요</option>
			<option>졸업한 초등학교 이름은?</option>
			<option>어머님의 성함은?</option>
			<option>아버지의 성함은?</option>
			<option>자신이 가장 좋아하는 음식은?</option>
		</select><br /> 
		<input type="text" id="passwordHintValue"
			name="passwordHintValue" placeholder="질문의 답을 입력하세요"><br /> 
		전화번호 <input type="text" id="phoneNumber" name="phoneNumber"
			placeholder="전화번호를 입력해주세요"><br /> 
		나이 <select id="age" name="age">
			<option>나이를선택해주세요</option>
			<option>10대</option>
			<option>20대</option>
			<option>30대</option>
			<option>40대</option>
			<option>50대</option>
		</select><br /> 
		포지션 <select id="position" name="position">
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
		</select> <br /> 
		거주 지역 <select id="locationId" name="locationId">
			<option>거주 지역을 선택하세요</option>
			<c:forEach items="${location}" var="location">
				<option value="${location.locationId}">${location.locationName}</option>
			</c:forEach>
		</select><br/>
		상세 지역 <select name="leafCategory" id="leafCategory">
		</select>
		<div id="btn">
			<input type="button" id="signBtn" value="회원가입"> <input
				type="button" id="cancelBtn" value="취소">
		</div>
	</form>
</div>
	<div>
<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
	</div>