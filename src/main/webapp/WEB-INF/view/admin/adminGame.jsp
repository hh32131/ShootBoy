<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			경기 관리
		</div>
		
		<div class="listAll">
				<p class="textAll">전체 목록 | 총 경기수 00개</p>
		</div>
		
		<div class="container">
			<div class="search-tool"> 
				<form id="search-select" name="search-select" method="post">
					<select id="search-target" name="search-target">
						<option value="gm_id"> 경기 아이디 </option>
						<option value="tm_name"> 팀 명 </option>
						<option value="gm_date"> 경기 날짜 </option>
						<option value="gm_location"> 지역 </option>
					</select>
					<input type="text" id="search-input" name="search-input" value id ="search-word"/>
					<button id="sbtn" name="sbtn" onclick="" >검색 </button> 
				</form>
			</div>
		
			<div class=line>
			</div>
			
			<div class=notice>
				<p id="notice-text">경기 리스트</p>
			</div>
			
			<div class="alldata-table">
				<table>
					<thead>
						<tr>
							<th>
								<div class="checks">
									<input type="checkbox" id="select-check">
									<label for="select-check"></label>
								</div>
							</th>
							<th>경기 아이디</th>
							<th>홈 팀명</th>
							<th>어웨이 팀명</th>
							<th>경기 날짜</th>
							<th>등록 날짜</th>
							<th>지역</th>
						</tr>	
					</thead>
					<tbody>
						<tr>	
							<td class="td_check">
								<div class="checks">
									<input type="checkbox" id="select-check">
									<label for="select-check"></label>
								</div>
							</td>
							<td class="td_gameId"> GM-161017-0001 </td>
							<td class="td_homeTeam"> y5m2 </td>
							<td class="td_awayTeam"> Post it </td>
							<td class="td_gamedate"> 2016-10-17 14:00 </td>
							<td class="td_registerdate"> 2016-10-15 </td>
							<td class="td_gameLocation"> 서울-강남 </td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>