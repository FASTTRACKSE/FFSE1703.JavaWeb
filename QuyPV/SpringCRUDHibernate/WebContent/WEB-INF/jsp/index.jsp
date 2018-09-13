<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- header -->
<jsp:include page="/WEB-INF/jsp/template/header.jsp" />
<!-- /.header -->


<!-- Right Panel -->

<div id="right-panel" class="right-panel">

	<!-- Header-->
	<header id="header" class="header">

		<div class="header-menu">

			<div class="col-sm-7">
				<a id="menuToggle" class="menutoggle pull-left"><i
					class="fa fa fa-tasks"></i></a>
				<div class="header-left">
					<button class="search-trigger">
						<i class="fa fa-search"></i>
					</button>
					<div class="form-inline">
						<form class="search-form">
							<input class="form-control mr-sm-2" type="text"
								placeholder="Search ..." aria-label="Search">
							<button class="search-close" type="submit">
								<i class="fa fa-close"></i>
							</button>
						</form>
					</div>

					<div class="dropdown for-notification">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="notification" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							<i class="fa fa-bell"></i> <span class="count bg-danger">5</span>
						</button>
						<div class="dropdown-menu" aria-labelledby="notification">
							<p class="red">You have 3 Notification</p>
							<a class="dropdown-item media bg-flat-color-1" href="#"> <i
								class="fa fa-check"></i>
								<p>Server #1 overloaded.</p>
							</a> <a class="dropdown-item media bg-flat-color-4" href="#"> <i
								class="fa fa-info"></i>
								<p>Server #2 overloaded.</p>
							</a> <a class="dropdown-item media bg-flat-color-5" href="#"> <i
								class="fa fa-warning"></i>
								<p>Server #3 overloaded.</p>
							</a>
						</div>
					</div>

					<div class="dropdown for-message">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="message" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							<i class="ti-email"></i> <span class="count bg-primary">9</span>
						</button>
						<div class="dropdown-menu" aria-labelledby="message">
							<p class="red">You have 4 Mails</p>
							<a class="dropdown-item media bg-flat-color-1" href="#"> <span
								class="photo media-left"><img alt="avatar"
									src="<c:url value= "/themes/images/avatar/1.jpg"/>"></span> <span
								class="message media-body"> <span class="name float-left">Jonathan
										Smith</span> <span class="time float-right">Just now</span>
									<p>Hello, this is an example msg</p>
							</span>
							</a> <a class="dropdown-item media bg-flat-color-4" href="#"> <span
								class="photo media-left"><img alt="avatar"
									src="<c:url value= "/themes/images/avatar/2.jpg"/>"></span> <span
								class="message media-body"> <span class="name float-left">Jack
										Sanders</span> <span class="time float-right">5 minutes ago</span>
									<p>Lorem ipsum dolor sit amet, consectetur</p>
							</span>
							</a> <a class="dropdown-item media bg-flat-color-5" href="#"> <span
								class="photo media-left"><img alt="avatar"
									src="<c:url value= "/themes/images/avatar/3.jpg"/>"></span> <span
								class="message media-body"> <span class="name float-left">Cheryl
										Wheeler</span> <span class="time float-right">10 minutes ago</span>
									<p>Hello, this is an example msg</p>
							</span>
							</a> <a class="dropdown-item media bg-flat-color-3" href="#"> <span
								class="photo media-left"><img alt="avatar"
									src="<c:url value= "/themes/images/avatar/4.jpg"/>"></span> <span
								class="message media-body"> <span class="name float-left">Rachel
										Santos</span> <span class="time float-right">15 minutes ago</span>
									<p>Lorem ipsum dolor sit amet, consectetur</p>
							</span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-5">
				<div class="user-area dropdown float-right">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <img
						class="user-avatar rounded-circle"
						src="<c:url value= "/themes/images/user.jpg"/>" alt="User Avatar">
					</a>

					<div class="user-menu dropdown-menu">
						<a class="nav-link" href="#"><i class="fa fa- user"></i>My
							Profile</a> <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications
							<span class="count">13</span></a> <a class="nav-link" href="#"><i
							class="fa fa -cog"></i>Settings</a> <a class="nav-link" href="#"><i
							class="fa fa-power -off"></i>Logout</a>
					</div>
				</div>

				<div class="language-select dropdown" id="language-select">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown"
						id="language" aria-haspopup="true" aria-expanded="true"> <i
						class="flag-icon flag-icon-us"></i>
					</a>
					<div class="dropdown-menu" aria-labelledby="language">
						<div class="dropdown-item">
							<span class="flag-icon flag-icon-fr"></span>
						</div>
						<div class="dropdown-item">
							<i class="flag-icon flag-icon-es"></i>
						</div>
						<div class="dropdown-item">
							<i class="flag-icon flag-icon-us"></i>
						</div>
						<div class="dropdown-item">
							<i class="flag-icon flag-icon-it"></i>
						</div>
					</div>
				</div>

			</div>
		</div>

	</header>
	<!-- /header -->
	<!-- Header-->

	<div class="breadcrumbs">
		<div class="col-sm-4">
			<div class="page-header float-left">
				<div class="page-title">
					<h1>Dashboard</h1>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="page-header float-right">
				<div class="page-title">
					<ol class="breadcrumb text-right">
						<li class="active">Dashboard</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="content mt-3">

		<div class="col-sm-12">
			<div class="alert  alert-success alert-dismissible fade show"
				role="alert">
				<span class="badge badge-pill badge-success">Success</span> You
				successfully read this important alert message.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>

		<a href="template">template</a> <br>
		<a href="export">export excel file</a>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				Dropdown <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="?lang=en">English</a></li>
				<li><a href="?lang=vi_VN">Vietnamese</a></li>
			</ul>
		</div>

		<h2 style="text-align: center">
			<spring:message code="title.sinhVienList" />
		</h2>
		<a href="addSv"><button class="btn btn-success">
				<spring:message code="button.add" />
			</button></a>
		<table class="table table-hover">

			<tr>
				<th>STT</th>
				<th>Mã sv</th>
				<th>Họ tên</th>
				<th>Năm Sinh</th>
				<th>Quê Quán</th>
				<th>Email</th>
				<th>Điện Thoại</th>
				<th>Mã Lớp</th>
				<th>Hình Ảnh</th>
				<th>Chức năng</th>
			</tr>
			<c:forEach var="x" items="${listSinhVien}" varStatus="itr">
				<tr>
					<td>${itr.index + 1}</td>
					<td>${x.maSv}</td>
					<td>${x.hoTen}</td>
					<td>${x.namSinh}</td>
					<td>${x.queQuan}</td>
					<td>${x.email}</td>
					<td>${x.dienThoai}</td>
					<td>${x.maLop}</td>
					<td><img src="<c:url value="/images/${x.hinhAnh}" />"
						width="60" height="80"></td>
					<td><a href="editSv/${x.id}"><button
								class="btn btn-warning">
								<spring:message code="button.edit" />
							</button></a> &nbsp; &nbsp; <a href="deleteSv/${x.id}"><button
								class="btn btn-danger"
								onclick="if (!confirm('Bạn có muốn xóa sinh viên này không?')) return false">
								<spring:message code="button.delete" />
							</button></a></td>
				</tr>
			</c:forEach>
		</table>
		<p>${totalPage}</p>

		<c:if test="${pageIndex > 1}">
			<a href="1">first</a>
			<a href="${pageIndex - 1}">
				<button class="btn btn-default">${pageIndex - 1}</button>
			</a>
		</c:if>

		<a href="${pageIndex}"><button class="btn btn-success">${pageIndex}</button></a>

		<c:if test="${pageIndex < totalPage}">
			<a href="${pageIndex + 1}"><button class="btn btn-default">${pageIndex + 1}</button></a>
			<a href="${totalPage}">last</a>
		</c:if>
		<tag:paginate max="15" start="${start}" count="${totalPage}"
			uri="/list" next="&raquo;" previous="&laquo;" />



	</div>
	<!-- .content -->
</div>
<!-- /#right-panel -->

<!-- Right Panel -->

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
<!-- /.footer -->

