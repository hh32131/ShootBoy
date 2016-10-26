<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/commons/header.jsp"></jsp:include>

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if (confirm("\"${board.boardSubject }\"를 삭제하시겠습니까?")) {
				location.href="/ShootBoy/board/doDelete?boardId=${board.boardId}&&categoryId=${categoryId}";
			}
		});
		
		$(".replayDeleteBtn").click(function() {
			var replyId = $(this).data("replyid");
			if (confirm("정말로  삭제하시겠습니까?")) {
				location.href="/ShootBoy/replayDelete?replayId="+replyId+"&&boardId=${board.boardId}";
			}
		});
		
		$(".replayModifyBtn").click(function() {
			var modify = $(this).data("modify");
			window.open("/ShootBoy/modifyReply?replyId="+modify, "",
						"width=600, height= 200");
			
		});
		
		$("#replayWriteBtn").click(function () {
			$("#replayId").attr({
				"mothod":"post",
				"action":"/ShootBoy/replayList"
			}).submit();
		})
	});
</script>
</head>
<body>
	<div id="listDetailWrapper">
		<div id="myPageLeftMenu">
			<div class="mplmTitle">Community</div>
			<div id="myPageLeftMenuTwo">
				<div class="mplmOne">
					<c:if test="${categoryId eq 11}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=11">공지사항</a>
				</div>
				<div class="mplmTwo">
					<c:if test="${categoryId eq 12}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=12">가입인사</a>
				</div>
				<div class="mplmThree">
					<c:if test="${categoryId eq 13}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=13">자유게시판</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 14}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=14">국내축구소식</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 15}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=15">해외축구소식</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 16}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=16">축구동영상</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 17}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=17">축구갤러리</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 18}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=18">매치경기후기</a>
				</div>
				<div class="mplmFour">
					<c:if test="${categoryId eq 19}">
						<img src="/ShootBoy/img/화살표.jpg" class="arrow">
					</c:if>
					<a href="/ShootBoy/list?categoryId=19">모집게시판</a>
				</div>
			</div>
		</div>
		
	<div id="boardDetail">
			
	<div class="boardTitle">${board.boardSubject} | </div>
	<div class="boardListText">
			<c:if test="${categoryId eq 0}">
				<a href="/ShootBoy/list">Community</a>
			</c:if>
			<c:if test="${categoryId eq 11}">
				<a href="/ShootBoy/list?categoryId=11">공지사항</a>
			</c:if>
			<c:if test="${categoryId eq 12}">
				<a href="/ShootBoy/list?categoryId=12">가입인사</a>
			</c:if>
			<c:if test="${categoryId eq 13}">
				<a href="/ShootBoy/list?categoryId=13">자유게시판</a>
			</c:if>
			<c:if test="${categoryId eq 14}">
				<a href="/ShootBoy/list?categoryId=14" style="font-size: 10px;">국내축구소식</a>
			</c:if>
			<c:if test="${categoryId eq 15}">
				<a href="/ShootBoy/list?categoryId=15">해외축구소식</a>
			</c:if>
			<c:if test="${categoryId eq 16}">
				<a href="/ShootBoy/list?categoryId=16">축구동영상</a>
			</c:if>
			<c:if test="${categoryId eq 17}">
				<a href="/ShootBoy/list?categoryId=17">축구갤러리</a>
			</c:if>
			<c:if test="${categoryId eq 18}">
				<a href="/ShootBoy/list?categoryId=18">매치경기후기</a>
			</c:if>
			<c:if test="${categoryId eq 19}">
				<a href="/ShootBoy/list?categoryId=19">모집게시판</a>
			</c:if>
		<div class="listUserName" style="display: inline-block; font-size: 15px;">( ${board.userVO.userName} )</div>
	</div>
		
		
		<div class="boardCreateDate">${board.createDate}</div>
	<hr/>
	<a href="/ShootBoy/board/doDownload?boardId=${board.boardId}" style="float: right;">${board.fileName}</a>
	
	${board.boardContent}<br/><br/>
	
	<br/><br/>
	조회수	${board.hitCount} 
	<c:if test="${sessionScope._USER_INFO_.userId eq board.userId}">|
		<a href="javascript:void(0);" id="deleteBtn" style="color:#000;">삭제</a> |
		<a href="/ShootBoy/board/modify?boardId=${board.boardId}&&categoryId=${categoryId}" style="color:#000;">수정 </a> 
	</c:if>
	<hr/>
	<p style="color: orange; margin-top: 10px;">댓글</p><br/>
		<c:forEach items="${replays}" var="replay" >
			<div style="display: inline-block; width: 400px;">${replay.replayContent}</div>
			<div id="replayRight">
				<div style="display: inline-block;">${replay.userVO.userName} |</div>
				<div style="display: inline-block;">${replay.createDate}</div> 
			<c:if test="${sessionScope._USER_INFO_.userId eq replay.userVO.userId}"> |
				<a href="javascript:void(0);" class="replayDeleteBtn" 
						data-replyid="${replay.replayId}" style="font-size: 11px; color:#000;" >삭제</a> | 
				<a href="javascript:void(0);" class="replayModifyBtn" 
						data-modify="${replay.replayId}" style="font-size: 11px; color:#000;" >수정</a>
			</c:if>
			</div>
		</c:forEach>
	<form id="replayId">
		<input type="hidden" id="boardId" name="boardId" value="${board.boardId}" ><br/>
		<textarea id="replayContent" name="replayContent" style="width: 600px; height: 25px;" placeholder="댓글을 입력해 주세요..."></textarea>
		<input type="button" id="replayWriteBtn" name="replayWriteBtn" value="등록" />
	</form>
	
	</div> 
</div>

	<div class="clear">
		<div style="padding-top: 60px;">
			<jsp:include page="/WEB-INF/view/commons/footer.jsp"></jsp:include>
		</div>
	</div>
