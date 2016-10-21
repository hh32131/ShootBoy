<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="/ShootBoy/css/adminPage.css" />
<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(
			function() {
				$("#checkAll").click(function() {
					var chk = $(this).is(":checked");
					if (chk)
						$(".check input").prop('checked', true);
					else
						$(".check input").prop('checked', false);
				});

				$(".boardCode").click(
						function() {
							var boardid = $(this).data("boardid");
							window.open("/ShootBoy/adminArticleDetail?boardId="
									+ boardid, "", "width=500, height= 500");
						});

				$("#searchType").change(function() {
					alert($("#searchType option:selected").text());
				});

				$("#deleteBtn").click(
						function() {
							$.post("/ShootBoy/doAdminArticleDelete", $(
									"#checkBoxForm").serialize(),
									function(data) {
										alert("" + data);
										location.reload();
									});
						});

				$("#modifyBtn").click(
						function() {
							var select = $(".select-check:checked").val();
							var checkBoard = $(".select-check:checked").length;
							if (checkBoard == 1) {
								window.open(
										"/ShootBoy/adminArticleModify?boardId="
												+ select, "",
										"width=500, height= 500");
							} else {
								alert(" 수정할 게시물을 선택해 주세요");
							}
						});

				$("#searchBtn").click(
						function() {
							var searchType = $("#searchForm > .searchType")
									.val();
							var searchKeyword = $(
									"#searchForm > .searchKeyword").val();

							$("#pagingForm > .searchType").val(searchType);
							$("#pagingForm > .searchKeyword")
									.val(searchKeyword);

							movePage(0);
						});
			});
</script>
<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />

<div class="wrapper">
	<div class="page-title">게시판 관리</div>

	<div class="listAll">
		<c:set var="list" value="boards" />
		<p class="textAll">전체 목록 | 총 경기수 ${fn:length(list)}개</p>
	</div>

	<div class="search-tool">
		<form id="searchForm" name="searchForm">
			<select class="searchType" name="searchType" id="searchType">
				<option value="1" ${ searchBoard.searchType eq 1 ? 'selected' : '' }>제목+내용</option>
				<option value="2" ${ searchBoard.searchType eq 2 ? 'selected' : '' }>제목</option>
				<option value="3" ${ searchBoard.searchType eq 3 ? 'selected' : '' }>내용</option>
				<option value="4" ${ searchBoard.searchType eq 4 ? 'selected' : '' }>작성자</option>
			</select> <input type="text" class="searchKeyword" name="searchKeyword"
				id="searchKeyword" value="${searchBoard.searchKeyword}" /> <input
				type="button" id="searchBtn" value="검색" />

			<div class="clear"></div>
		</form>
	</div>

	<div class="line"></div>

	<div class="notice">
		<p id="notice-text">게시물 리스트</p>
	</div>
	<div class="alldata-table">
		<table>
			<thead>
				<tr>
					<th>
						<div class="checks">
							<input type="checkbox" id="checkAll" name="checkAll"
								value="checkall"> <label for="select-check"></label>
						</div>
					</th>
					<th>게시물 아이디</th>
					<th>제 목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>카테고리</th>
					<th>첨부파일</th>
				</tr>
			</thead>
			<form id="checkBoxForm" name="checkBoxForm">
				<c:forEach var="boards" items="${boards}">
					<tbody>
						<tr>
							<td class="td_check">
								<div class="checks check" id="checkBoard" neame="checkBoard">
									<input type="checkbox" class="select-check"
										data-selectid="${boards.boardId }" name="select-check"
										value="${boards.boardId }"> <label for="select-check"></label>
								</div>
							</td>
							<c:set var="number" value="${fn:split(boards.boardId,'-')[2]}" />
							<fmt:parseNumber var="number" type="number" value="${number}" />
							<td class="td_boardId"><input type="hidden"
								value="${boards.boardId }"> <span> <a
									href="javascript:void(0)" class="boardCode"
									data-boardid="${boards.boardId }"> ${number} </a>
							</span></td>
							<td class="td_boardSubject">${boards.boardSubject}
								[${boards.replayHitCount}]</td>
							<td class="td_userName">${boards.userVO.userName }</td>
							<td class="td_createDate">${boards.createDate}</td>
							<td class="td_hitCount">${boards.hitCount}</td>
							<td class="td_categoryId">${boards.categoryId}</td>
							<td class="td_fileName">${boards.fileName}</td>
						</tr>
					</tbody>
				</c:forEach>
			</form>
		</table>
		<div style="padding-top: 5px;">
			<form id="pagingForm" name="pagingForm">
				${paging} <input type="hidden" class="searchType" name="searchType"
					value="${ searchBoard.searchType }" /> <input type="hidden"
					class="searchKeyword" name="searchKeyword"
					value="${searchBoard.searchKeyword}" />
			</form>
		</div>
		<div class="initBtn">
			<input type="button" id="initBtn" value="전체 보기"
				onclick="location='/ShootBoy/adminList/init'" />
		</div>
		<div class="functionBtn">
			<input type="button" id="writeBtn" value="등 록" /> <input
				type="button" id="modifyBtn" value="선택 수정" /> <input type="button"
				id="deleteBtn" value="선택 삭제" />
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />