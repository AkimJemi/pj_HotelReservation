<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="EUC-KR">
<title>${room }번방예약관리상세정보</title>


</head>
<body>
	<%
	String form = "readonly";
	%>
	<c:if test="${form eq 'update' }">
		<%
		form = "";
		%>
	</c:if>
	<div class="bs-border-radius-sm">
		<div>
			<div>
				<div></div>
			</div>
		</div>
	</div>
	<form action="/admin/book/update/${book.id }" method="POST">
		<div class="d-inline-block">
			<div>
				<div class="d-inline-block">예약번호:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="id" value="${book.id }" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">예약자:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="user_id" value="${book.userId}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">방이름:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="room_id" value="${book.roomId}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">가격:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="price" value="${book.price}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">결재유무:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="pay_flag" value="${book.payFlag}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">취소유무:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="cancel_flag" value="${book.cancelFlag}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">성인예약자수:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="adult_cnt" value="${book.adultCnt}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">아이예약자수:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="children_cnt" value="${book.childrenCnt}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">체크인일:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="start_dt" value="${book.startDate}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">체크아웃일:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="end_dt" value="${book.endDate}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">방옵션:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="options" value="${book.options}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">삭제유무:</div>
				<div class="d-inline-block">
					<input type="text" <%=form %> name="delete_flag" value="${book.deleteFlag}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">생성일:</div>
				<div class="d-inline-block">
					<input type="date" <%=form %> name="created_at" value="${book.createdAtForView}" />
				</div>
			</div>
			<div>
				<div class="d-inline-block">갱신일:</div>
				<div class="d-inline-block">
					<input type="date" <%=form %> name="updated_at"  value="${book.updatedAtForView}" /><input type="text" <%=form %> value="${book.updatedAtForTime}" />
				</div>
			</div>
		</div>
		<div class="d-inline-block">
			<c:choose>
				<c:when test="${form eq 'update' }">
					<input value="완료" type="submit">
				</c:when>
				<c:otherwise>
					<input value="수정" type="button" onclick="update('${book.id}')">
				</c:otherwise>
			</c:choose>
			<input value="삭제" type="button"
				onclick="confirm('예약정보를 삭제하시겠습니가?'); return false;">
		</div>
	</form>
	<!-- <div class="form-check">
		<input class="form-check-input" type="checkbox" value=""
			id="flexCheckChecked" checked> <label
			class="form-check-label" for="flexCheckChecked"> Checked
			checkbox </label>
	</div>
	<div class="form-check">
		<input class="form-check-input" type="checkbox" value=""
			id="flexCheckIndeterminate"> <label class="form-check-label"
			for="flexCheckIndeterminate"> Indeterminate checkbox </label>
	</div>
	Fancy display heading
	<small class="text-muted">With faded secondary text</small> -->
	<script type="text/javascript">
		function update(val) {
			location.href = "/admin/book/update/" + val;
		};
	</script>
</body>
</html>