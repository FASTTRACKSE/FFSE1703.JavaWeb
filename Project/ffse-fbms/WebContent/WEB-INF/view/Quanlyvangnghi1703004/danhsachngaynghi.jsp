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
			<h3 class="content-header-title mb-0">Danh sách ngày nghỉ</h3>
		</div>
			
			<div>
			<div class="container">
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th >Mã đơn</th>
					<th>Mã nhân viên</th>
					<th>Số ngày đã nghi</th>
					<th>Số ngày còn lại</th>
					<th>Chức năng</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nn" items="${danhsachngaynghi}">
					<tr>
					<td>${nn.id}</td>
					<td>${nn.thongTinHoSoNhanVien.maNhanVien}</td>
					<td>${nn.thongTinHoSoNhanVien.soNgayDaNghi}</td>
					<td>${nn.thongTinHoSoNhanVien.soNgayConLai}</td>
					<td><a href="deleteDate/${nn.id }"><button class="btn btn-outline-danger round  mr-1 mb-1"
									onclick="return confirm('Bạn có muốn xóa sinh viên này?');">Xóa</button></a>
					</td>
						</tr>
				</c:forEach>
				</tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
