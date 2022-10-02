<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>예약관리 리스트</title>
</head>
<body>
	<script type="text/javascript">
	function searchForDate(Index) {
		if (Index == 3) {
			$('#searchDate').appendTo(".moveBox1");
			$('#searchText').appendTo(".moveBox2");
		} else {
			$('#searchDate').appendTo(".moveBox2");
			$('#searchText').appendTo(".moveBox1");
		}
	}
	function selectForOption(Index) {
		alert(Index);
	}
	</script> 
	<%
	String no = "", room = "", user = "", date = "";
	%>
	<div class="d-inline-block">
		<div>
			<div>
				<div class="d-none moveBox2">
					<input type="date" id="searchDate">
				</div>
				<form action="/admin/book/list" method="POST">
					<c:if test="${paging != null}">
						<c:if test="${paging.title eq 'no'}">
							<%no = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'room'}">
							<%room = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'user'}">
							<%user = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'date'}">
							<%date = "selected";%>
							<script type="text/javascript">
							$( document ).ready(function(){
								searchForDate('3');
							});
							</script>
						</c:if>
					</c:if>
					<select name="title" onchange="searchForDate(this.selectedIndex)">
						<option value="no" <%=no%>>방번호</option>
						<option value="room" <%=room%>>방이름</option>
						<option value="user" <%=user%>>고객</option>
					</select> <input type="text" name="content"
						value="${paging.content}">
					
					<c:if test="${paging != null}">
						<c:if test="${paging.title eq 'no'}">
							<%no = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'room'}">
							<%room = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'user'}">
							<%user = "selected";%>
						</c:if>
						<c:if test="${paging.title eq 'date'}">
							<%date = "selected";%>
							<script type="text/javascript">
							$( document ).ready(function(){
								searchForDate('3');
							});
							</script>
						</c:if>
					</c:if>
					<select name="bookingCode">
							<option>옵션</option>
						<c:forEach items="${options }" var="option">
					<c:choose >
					<c:when test="${option.bookingCode eq selectedOption }">
							<option value="${option.bookingCode}" selected>${option.info }</option>
					</c:when>
					<c:otherwise>
							<option value="${option.bookingCode}" >${option.info }</option>
					</c:otherwise>
					</c:choose>
						</c:forEach>
					</select>
						
					<label for="startDate">체크인</label>
					<input type="date" name="startDate"/>	
					<label for="EndDate">체크아웃</label>
					<input type="date" name="EndDate"/>	
					<div class="d-inline-block moveBox1"></div>
					<input type="submit" value="검색">
					<%-- <input type="hidden" name="endPage"
						value="${page.endPage }"> <input type="hidden"
						name="startPage" value="${page.startPage }"> <input
						type="hidden" name="total" name="total" value="${page.total }"> --%>
				</form>
			</div>

		</div>
		
		<table class="table text-center table-dark table-hover">
			<thead>
				<tr>
					<td>방번호</td>
					<td>방이름</td>
					<td>예약자</td>
					<c:forEach var="option" items="${Option.size }">
						<td>옵션${option}</td>
					</c:forEach>
					<td>성인예약자수</td>
					<td>아이예약자수</td>
					<td>체크인일</td>
					<td>체크아웃일</td>
					<td>가격</td>
					<td>결재유무</td>
					<td>취소유무</td>
					<td>생성일</td>
					<td>갱신일</td>
					<td>삭제유무</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="book" items="${bookList }">
				<tr>
					<td><a href="/admin/book/detail/${book.id }">${book.id }</a></td>
					<td>${book.userId }</td>
					<td>${book.roomId}</td>
					<td>${book.options}</td>
					<td>${book.adultCnt}</td>
					<td>${book.childrenCnt}</td>
					<td>${book.startDate}</td>
					<td>${book.endDate}</td>
					<td>${book.price}</td>
					<td>${book.payFlag}</td>
					<td>${book.cancelFlag}</td>
					<td>${book.createdAtForView}</td>
					<td>${book.updatedAtForView}</td>
					<td>${book.deleteFlag}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<%-- <div class="d-inline-block">
			<div class="d-inline-block">방번호</div>
			<div class="d-inline-block">방이름</div>
			<div class="d-inline-block">예약자</div>
			<div class="d-inline-block">가격</div>
			<div class="d-inline-block">결재유무</div>
			<div class="d-inline-block">취소유무</div>
			<div class="d-inline-block">성인예약자수</div>
			<div class="d-inline-block">아이예약자수</div>
			<div class="d-inline-block">체크인일</div>
			<div class="d-inline-block">체크아웃일</div>
			<div class="d-inline-block">방옵션</div>
			<div class="d-inline-block">삭제유무</div>
			<div class="d-inline-block">생성일</div>
			<div class="d-inline-block">갱신일</div>
		</div>
		<div>
			<c:forEach var="book" items="${bookList }">
				<div>
					<div class="d-inline-block">
						<a href="/admin/book/detail/${book.id }">${book.id }</a>
					</div>
					<div class="d-inline-block text-danger">${book.userId }</div>
					<div class="d-inline-block">${book.price}</div>
					<div class="d-inline-block">${book.roomId}</div>
					<div class="d-inline-block">${book.payFlag}</div>
					<div class="d-inline-block">${book.cancelFlag}</div>
					<div class="d-inline-block">${book.adultCnt}</div>
					<div class="d-inline-block">${book.childrenCnt}</div>
					<div class="d-inline-block">${book.startDate}</div>
					<div class="d-inline-block">${book.endDate}</div>
					<div class="d-inline-block">${book.options}</div>
					<div class="d-inline-block">${book.deleteFlag}</div>
					<div class="d-inline-block">${book.createdAtForView}</div>
					<div class="d-inline-block">${book.updatedAtForView}</div>
				</div>
			</c:forEach>
		</div> --%>
		<%-- <div>
			<c:forEach begin="${page.startPage }" end="${page.endPage}" var="page">
				<div class="d-inline-block">${page }</div>
			</c:forEach>
		</div> --%>
	</div>
</body>
</html>