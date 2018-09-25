<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" /> 

<div class="app-content content container-fluid">
<a href="#"><button class="btn btn-success round btn-min-width mr-1 mb-1">Thêm Mới</button></a>
<div class="content-wrapper">
	<table class="table mb-0">
		<thead>
			<tr>
				
				<th>Mã Nhân Viên</th>
				<th>Họ và Tên</th>
				<th>Tên Hợp Đồng</th>
				<th>Ngày Kí Kết</th>
				<th>Ngày Kết Thúc</th>
				<th>Lương Tháng 13</th>
				<th>Trạng Thái</th>
				<th>Chức Năng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listHopDong}" var="x" varStatus="stt">
			<tr>
				
				<td>${x.hoSoNhanVienPikalong.maNv}</td>
				<td>${x.hoSoNhanVienPikalong.hoTenNv}</td>
				<td>${x.loaiHopDongPikalong.tenHopDong}</td>
				<td>${x.ngayKiKet}</td>
				<td>${x.ngayKetThuc}</td>
				<td>${x.luongThang13}</td>
				<td>${x.trangThai}</td>
				<td>
					<div class="fonticon-container"><div style="line-height:0; height: 0; margin-bottom: 0;" class="fonticon-wrap">
						<a href="view/${x.hoSoNhanVienPikalong.maNv}"><i style="font-size: 1em;" class="ft-eye"></i></a>
						<a href="#"><i style="font-size: 1em;" class="ft-edit-2"></i></a>
						<a href="#"><i style="font-size: 1em;" class="ft-trash"></i></a>
					</div></div>
				</td>
			</tr>
			</c:forEach>
		</tbody> 
</table>
</div>
</div>
 
<jsp:include page="/WEB-INF/view/templates/footer.jsp" /> 