<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div>
				<div class="container">
					<div class="table-responsive">
						<table class="table mb-0">
							<thead>
								<tr>
									<th>Chuyên Ngành</th>
									<th>Xếp Loại</th>
									<th>Nơi Cấp</th>
									<th>Ngày Cấp</th>
								</tr>
							</thead>
							<tbody>
								<h1>${viewOne.get(0).maNV }</h1>
								<c:forEach var="bangcap" items="${viewOne}">
									<tr>
										<td>${bangcap.chuyenNganh}</td>
										<td>${bangcap.xepLoai}</td>
										<td>${bangcap.noiCap}</td>
										<td>${bangcap.ngayCap}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a
							href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/addBangCap"
							class="btn btn-success btnSpace">Thêm Bằng Cấp</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />