<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">Danh Sách Nhân Viên</h3> <!-- title -->
		<br>
		<a href="addform"><button class="btn btn-light">
										<i class="fa fa-plus"></i>
									</button></a> <!-- add button -->	
		<div class="table-responsive">
			<table class="table mb-0">
				<thead>
					<tr>
						<th>STT</th>
						<th>Mã Nhân Viên</th>
						<th>Họ Tên</th>
						<th>Giới Tính</th>
						<th>Ngày Sinh</th>
						<th>Chức Năng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nhanVienList}" var="x" varStatus="stt">
						<tr>
							<td>${stt.index + 1}</td>
							<td>${x.maNv}</td>
							<td>${x.hoTenNv}</td>
							<td>${x.gioiTinh}</td>
							<td>${x.ngaySinh}</td>
							<td><a href="delete/${x.maNv}"><button class="btn btn-light" onclick="if (!confirm('Bạn có muốn xóa sinh viên này không?')) return false">
										<i class="fa fa-trash"></i>
									</button></a> <!-- delete button -->
								<a href="#"><button class="btn btn-light">
										<i class="fa fa-pencil"></i>
									</button></a> <!-- edit button -->	
							</td> 		
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</div>





<jsp:include page="/WEB-INF/view/templates/footer.jsp" />