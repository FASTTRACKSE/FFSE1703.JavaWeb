<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
		<div>
		<div class="col-md-5"></div>
			<h3 >Danh sách Trạng Thái</h3>
		</div>
			
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th >Mã Trang Thái</th>
					<th >Tên Trang Thái</th>
					<th >Số Đơn</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="tl" items="${thongketrangthai}">
					<tr>
					
					<td>${tl.id}</td>
					<td>${tl.trangThai}</td>
						</tr>
				</c:forEach>
				</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="?page=1">Trang Đầu</a></li>
		<c:if test="${currentPage > 2}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-2}">${currentPage-2}</a></li>
			</c:if>
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-1}">${currentPage-1}</a></li>
			</c:if>
			<li class="page-item active"><a class="page-link"
				href="?page=${currentPage}">${currentPage}</a></li>
			<c:if test="${currentPage < lastPage}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+1}">${currentPage+1}</a></li>
			</c:if>
			<c:if test="${currentPage < lastPage - 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+2}">${currentPage+2}</a></li>
			</c:if>
		<li class="page-item"><a class="page-link" href="?page=${lastPage }">Trang Cuối</a></li>
	</ul>
	</nav>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
<script>
		
	</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />