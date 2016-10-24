<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/commons/adminHeader.jsp" />

<script type="text/javascript" src="/ShootBoy/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#writeBtn").click(function() {
			
			if( $("#boardSubject").val() == "") {
				alert("제목을 입력해주세요.");
				return;
			}
			if( $("#boardContent").val() =="") {
				alert("내용을 입력해주세요.");
				return;
			}
			
			$("#writeForm").attr( {
				"method": "post",
				"action": "/ShootBoy/doWriteAdminArticle"
			}).submit();
		});
			
		$("#backBtn").click(function() {
			location.href="/ShootBoy/adminArticle";
		});
	});
</script>
<body>
	<form id="writeForm" name="writeForm" enctype="multipart/form-data">
		<div>
			<input type="text" id="boardSubject" name="boardSubject"
				placeholder="제목을 입력하세요."
				style="width: 400px; height: 25px; font-size: 15px;" />
			
			<div>
			
				<select name="categoryId" id="categoryId">
					<option>카테고리를 선택해주세요</option>
					<c:forEach var="cate" items="${category }">
						<option value="${cate.categoryId }">${cate.categoryName }</option>
					</c:forEach>
				
 				</select>
			</div>
		</div>
		<div style="height: 10px;"></div>
		<div>
			<textarea id="boardContent" name="boardContent"
				placeholder="내용을 입력하세요."
				style="width: 700px; height: 250px; font-size: 15px; margin-bottom: 30px;"></textarea>
		</div>
		<div>
			<input type="file" id="file" name="file" />
			<div class="listBtn" style="float: right; margin-right: 65px;">
				<input type="button" id="writeBtn" name="writeBtn" value="글쓰기" />
				<input type="button" id="backBtn" name="backBtn" value="뒤로가기" />
			</div>
		</div>
	</form>

</html>

<jsp:include page="/WEB-INF/view/commons/adminFooter.jsp" />