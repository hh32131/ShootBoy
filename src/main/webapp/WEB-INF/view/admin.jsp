<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminMain.css" />

	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />

	<div class="wrapper">
		<div class="page-title">
			관리자 메인
		</div>

		<hr/>

		<div class="container">
			
			<div class="sub-title">
			회원 5건 목록
			</div>
			
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 회원 아이디 </th>
							<th scope="col"> 이름 </th>
							<th scope="col"> 나이 </th>
							<th scope="col"> 핸드폰 번호 </th>
							<th scope="col"> 권한 </th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td_userId"> n2350 </td>
							<td class="td_userName"> 남재현 </td>
							<td class="td_userAge"> 30 </td>
							<td class="td_userPhone"> 010-1234-5678 </td>
							<td class="td_userGrade"> 회원 </td>
						</tr>
						<tr>
							<td class="td_id"> hsb </td>
							<td class="td_name"> 황수빈 </td>
							<td class="td_age"> 26 </td>
							<td class="td_phone"> 010-4854-1564 </td>
							<td class="td_grade"> 회원 </td>
						</tr>
						<tr>
							<td class="td_id"> wogudnn </td>
							<td class="td_name"> 이재형 </td>
							<td class="td_age"> 28 </td>
							<td class="td_phone"> 010-4653-1234 </td>
							<td class="td_grade"> 회원 </td>	
						</tr>
						<tr>
							<td class="td_id"> hong </td>
							<td class="td_name"> 홍석훈 </td>
							<td class="td_age"> 27 </td>
							<td class="td_phone"> 010-7987-1245 </td>
							<td class="td_grade"> 회원 </td>
						</tr>
						<tr>
							<td class="td_id"> mindol </td>
							<td class="td_name"> 김민석 </td>
							<td class="td_age"> 26 </td>
							<td class="td_phone"> 010-7896-8451 </td>
							<td class="td_grade"> 관리자 </td>
						</tr>
					</tbody>	
				</table>
				<div class="member-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminMember'">회원 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최신 팀 목록
			</div>
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 팀 아이디 </th>
							<th scope="col"> 팀 명 </th>
							<th scope="col"> 팀 정보 </th>
							<th scope="col"> 팀 인원수 </th>
							<th scope="col"> 팀 생성일자 </th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td_teamId"> 1 </td>
							<td class="td_teamName"> 레알마드리드 </td>
							<td class="td_teamInfo"> 저희는 스페인에 있습니다~! </td>
							<td class="td_team-memberCnt"> 23 </td>
							<td class="td_team-date"> 2016-10-13 11:00 </td>
						</tr>
						<tr>
							<td class="td_teamId"> 2 </td>
							<td class="td_teamName"> 수원 </td>
							<td class="td_teamInfo"> 한국 수원에서 활동해요~ </td>
							<td class="td_team-memberCnt"> 21 </td>
							<td class="td_team-date"> 2016-10-11 21:00 </td>
						</tr>
					</tbody>	
				</table>
				<div class="game-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminTeam'">팀 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최근 경기
			</div>			
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 경기 번호 </th>
							<th scope="col"> 생성 팀 </th>
							<th scope="col"> 신청 팀 </th>
							<th scope="col"> 지역 </th>
							<th scope="col"> 날짜 </th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td_gameId"> 1 </td>
							<td class="td_homeTeam"> 홈팀 </td>
							<td class="td_awayTeam"> 어웨이팀 </td>
							<td class="td_location"> 서울-강남 </td>
							<td class="td_date"> 2016-10-13 4:00 </td>
						</tr>
						<tr>
							<td class="td_gameId"> 2 </td>
							<td class="td_homeTeam"> y3 </td>
							<td class="td_awayTeam"> m2 </td>
							<td class="td_location"> 경기-이천 </td>
							<td class="td_date"> 2016-10-14 21:00 </td>
						</tr>
					</tbody>	
				</table>
				<div class="game-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminGame'">경기 전체보기</button>
					<br/>
					<br/>
				</div>
			</div>
			
			<div class="sub-title">
				최근 게시물
			</div>
			<div class="list-table">
				<table>
					<thead>
						<tr>
							<th scope="col"> 게시판 </th>
							<th scope="col"> 게시물 번호 </th>
							<th scope="col"> 제 목 </th>
							<th scope="col"> 회원 아이디 </th>
							<th scope="col"> 이름 </th>
							<th scope="col"> 날짜 </th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td_articleName"> 축구갤러리 </td>
							<td class="td_articleId"> 1 </td>
							<td class="td_articleSubject"> 손흥민 골! </td>
							<td class="td_userId"> wogudnn </td>
							<td class="td_userName"> 이재형 </td>
							<td class="td_articleDate"> 2016-10-13 21:00 </td>
						</tr>
					</tbody>	
				</table>
				<div class="article-view">
					<button class="viewbtn" onclick="location.href='/ShootBoy/adminArticle'">게시글 전체보기</button>
					<br/>
				</div>
			</div>
			<br/><br/><br/>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />