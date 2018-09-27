<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
div.stroke a button, div.stroke a button:after, div.stroke a button:before
	{
	transition: all .5s;
}

div.stroke a button:hover {
	color: #555;
	
}

div.stroke:hover {
	transition: transform .5s;
	transform: scale(1.09);
}

div.stroke a button {
	position: relative;
	
}

div.stroke a button:hover:after {
	width: 100%;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
	<h3 class="content-header-title mb-0">Thông Tin Của Nhân
			Viên</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item active">Thông Tin Nhân Viên</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-12">
				<div class="stroke">
					<a href="/ffse-fbms/quantrinhansu/hosonhanvien/hosochitiet/${maNv}">
						<button class="btn btn-default" style="background-color: #F5F7FA">
							<div class="card">
								<div class="card-content">
									<div class="media align-items-stretch">
										<div class="p-2 text-center bg-primary bg-darken-2">
											<i class="icon-user font-large-2 white"></i>
										</div>
										<div class="p-2 bg-gradient-x-primary white media-body">
											<h5>Hồ Sơ Chi Tiết</h5>
										</div>
									</div>
								</div>
							</div>
						</button>
					</a>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-12">
				<div class="stroke">
					<a href="/ffse-fbms/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${maNv}">
						<button class="btn btn-default" style="background-color: #F5F7FA">
							<div class="card">
								<div class="card-content">
									<div class="media align-items-stretch">
										<div class="p-2 text-center bg-primary bg-darken-2">
											<i class="ft-clipboard font-large-2 white"></i>
										</div>
										<div class="p-2 bg-gradient-x-primary white media-body">
											<h5>Thông Tin Hợp Đồng</h5>											
										</div>
									</div>
								</div>
							</div>
						</button>
					</a>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-12">
				<div class="stroke">
					<a href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/${maNv}">
						<button class="btn btn-default" style="background-color: #F5F7FA">
							<div class="card">
								<div class="card-content">
									<div class="media align-items-stretch">
										<div class="p-2 text-center bg-primary bg-darken-2">
											<i class="fa fa-home font-large-2 white"></i>
										</div>
										<div class="p-2 bg-gradient-x-primary white media-body">
											<h5>Thông Tin Gia Đình</h5>											
										</div>
									</div>
								</div>
							</div>
						</button>
					</a>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-12">
				<div class="stroke">
					<a href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/${maNv}">
						<button class="btn btn-default" style="background-color: #F5F7FA">
							<div class="card">
								<div class="card-content">
									<div class="media align-items-stretch">
										<div class="p-2 text-center bg-primary bg-darken-2">
											<i class="fa fa-institution font-large-2 white"></i>
										</div>
										<div class="p-2 bg-gradient-x-primary white media-body">
											<h5>Thông Tin Bằng Cấp</h5>											
										</div>
									</div>
								</div>
							</div>
						</button>
					</a>
				</div>
			</div>
		</div>

	</div>
</div>



<jsp:include page="/WEB-INF/view/templates/footer.jsp" />