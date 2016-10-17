<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/ShootBoy/css/adminPage.css" />
	<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />
	
	<div class="wrapper">
		<div class="page-title">
			게시판 관리 
		</div>
				
		<div class="listAll">
				<p class="textAll">전체 목록 | 총 경기수 00개</p>
		</div>
		
		<div class="container">
			<div class="search-tool"> 
				<form id="search-select" name="search-select" method="post">
					<select id="search-target" name="search-target">
						<option value="ar_id"> 게시물 아이디 </option>
						<option value="ar_subCont"> 제목+내용 </option>
						<option value="ar_subject"> 제 목 </option>
						<option value="ar_cont"> 내 용 </option>
						<option value="ar_userId"> 작성자 </option>
					</select>
					<input type="text" id="search-input" name="search-input" value id ="search-word"/>
					<button id="sbtn" name="sbtn" onclick="" >검색 </button> 
				</div>
			</form>
		
			<div class=line>
			</div>
			
			<div class=notice>
				<p id="notice-text">게시물 리스트</p>
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
							<th>게시물 아이디</th>
							<th>제 목</th>
							<th>내 용</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>카테고리</th>
							<th>첨부파일</th>
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
							<td class="td_articleId"> AR-161017-0001 </td>
							<td class="td_articleSubject"> 관리자 게시판페이지 </td>
							<td class="td_articleContent"> 내용....... </td>
							<td class="td_articleUserId"> mindol </td>
							<td class="td_articleRegistDate"> 2016-10-15 </td>
							<td class="td_articleHitCount"> 6 </td>
							<td class="td_articleCategory"> 커뮤니티 </td>
							<td class="td_articleFile"> 펭귄.jpg </td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
				
	</div>
	
	<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />