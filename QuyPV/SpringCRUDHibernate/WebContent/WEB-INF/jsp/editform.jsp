<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

		<<h2 style="text-align: center"><spring:message code="title.edit" /></h2>
		<form:form class="form-horizontal" action="/SpringCRUDHibernate/editsave" method="POST" enctype="multipart/form-data">
			<div class= "form-group">
				<!-- label>Id:</label> -->
				<form:input class= "form-control" type="hidden" path="id"/> <br>
			</div>
			<div class= "form-group">
				<!-- label>Mã Sinh Viên:</label> -->
				<form:input class= "form-control" type="hidden" path="maSv"/> <br>
			</div>
			<div class= "form-group">
				<label>Họ tên:</label>
				<form:input class= "form-control" type="text" path="hoTen"/> <br>
				<form:errors path="hoTen" cssStyle="color: red" />
			</div>
			<div class= "form-group">
				<label>Năm sinh:</label>
				<form:input class= "form-control" type="number" path="namSinh"/> <br>
				<form:errors path="namSinh" cssStyle="color: red" />
			</div>
			<div class= "form-group">
				<label>Quê quán:</label>
				<form:input class= "form-control" type="text" path="queQuan"/> <br>
				<form:errors path="queQuan" cssStyle="color: red" />
			</div>
			<div class= "form-group">
				<label>Email:</label>
				<form:input class= "form-control" type="text" path="email"/> <br>
				<form:errors path="email" cssStyle="color: red" />
			</div>
			<div class= "form-group">
				<label>Điện thoại:</label>
				<form:input class= "form-control" type="number" path="dienThoai"/> <br>
				<form:errors path="dienThoai" cssStyle="color: red" />
			</div>
			<div class= "form-group">
				<label>Mã lớp:</label>
				<form:select path="maLop" class= "form-control">
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1702">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
				</form:select>
				<form:errors path="maLop" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Hình Ảnh:</label> <input id="imgUrl" class="form-control"
					type="file" name="file" /> <br> 
					<img src="<c:url value="/images/${command.hinhAnh}" />" width="100" height="150">
					<img id="img" src="#"
					alt="your image" width="100" height="150" />
				<form:errors path="hinhAnh" cssStyle="color: red" />

			</div>
			
			<input class= "btn btn-success" type="submit" value="Lưu" />
		</form:form>
	
	</div>
	<!-- .content -->
</div>
<!-- /#right-panel -->

<!-- Right Panel -->
	
	
	
<!-- footer -->
<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
<!-- /.footer -->


