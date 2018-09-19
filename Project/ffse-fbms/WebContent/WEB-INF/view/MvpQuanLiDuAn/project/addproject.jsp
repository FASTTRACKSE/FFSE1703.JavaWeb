
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<div class="app-content content container-fluid">

	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới dự án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/vendor/list-vendor" />'>Danh
									sách dự án</a></li>
							<li class="breadcrumb-item active">Thêm mới dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<!-- End Path -->

		<div class="justify-content-md-center" style="width: 95%">
			<h4 class="card-title" id="basic-layout-form">Project Info</h4>
			<div class="card-body">

				<form class="form">
					<div class="form-body">
						<h4 class="form-section">
							<i class="ft-user"></i> Thông tin dự án
						</h4>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput1">Mã dự án</label> <input type="text"
										id="projectinput1" class="form-control"
										placeholder="First Name" name="fname">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput2">Tên dự án</label> <input type="text"
										id="projectinput2" class="form-control"
										placeholder="Last Name" name="lname">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Khách hàng</label> <select
										id="projectinput5" name="interested" class="form-control">
										<option value="none" selected="" disabled="">Interested
											in</option>
										<option value="design">design</option>
										<option value="development">development</option>
										<option value="illustration">illustration</option>
										<option value="branding">branding</option>
										<option value="video">video</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Phòng dự án</label> <select
										id="projectinput5" name="interested" class="form-control">
										<option value="none" selected="" disabled="">Interested
											in</option>
										<option value="design">design</option>
										<option value="development">development</option>
										<option value="illustration">illustration</option>
										<option value="branding">branding</option>
										<option value="video">video</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Ngày bắt đầu</label> <input
										type="date" id="issueinput4" class="form-control"
										name="datefixed" data-toggle="tooltip" data-trigger="hover"
										data-placement="top" data-title="Date Fixed"
										data-original-title="" title="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Ngày kết thúc</label> 
									<input
										type="date" id="issueinput4" class="form-control"
										name="datefixed" data-toggle="tooltip" data-trigger="hover"
										data-placement="top" data-title="Date Fixed"
										data-original-title="" title="">
								</div>
							</div>
							
						</div>
							<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Nghiệp vụ</label> <input
										type="date" id="issueinput4" class="form-control"
										name="datefixed" data-toggle="tooltip" data-trigger="hover"
										data-placement="top" data-title="Date Fixed"
										data-original-title="" title="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Nhà cung cấp</label> 
									<input
										type="date" id="issueinput4" class="form-control"
										name="datefixed" data-toggle="tooltip" data-trigger="hover"
										data-placement="top" data-title="Date Fixed"
										data-original-title="" title="">
								</div>
							</div>
							
						</div>
						</div>
						
						<h4 class="form-section">
							<i class="fa fa-paperclip"></i> Công nghệ 
						</h4>
						<div class="form-group">
							<label for="companyName">Kĩ thuật</label> <input type="text"
								id="companyName" class="form-control" placeholder="Company Name"
								name="company">
						</div>
						<div class="form-group">
							<label for="companyName">Database</label> <input type="text"
								id="companyName" class="form-control" placeholder="Company Name"
								name="company">
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Programming language</label> <select
										id="projectinput5" name="interested" class="form-control">
										<option value="none" selected="" disabled="">Interested
											in</option>
										<option value="design">design</option>
										<option value="development">development</option>
										<option value="illustration">illustration</option>
										<option value="branding">branding</option>
										<option value="video">video</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput6">Framework</label> <select
										id="projectinput6" name="budget" class="form-control">
										<option value="0" selected="" disabled="">Budget</option>
										<option value="less than 5000$">less than 5000$</option>
										<option value="5000$ - 10000$">5000$ - 10000$</option>
										<option value="10000$ - 20000$">10000$ - 20000$</option>
										<option value="more than 20000$">more than 20000$</option>
									</select>
								</div>
							</div>
						</div>
						<h4 class="form-section">
							<i class="fa fa-paperclip"></i> Mô tả dự án
						</h4>
						<div class="form-group">
							<label for="projectinput8">Mô tả dự án</label>
							<textarea id="projectinput8" rows="5" class="form-control"
								name="comment" placeholder="About Project"></textarea>
						</div>
					</div>
					 <div class="col-sm-12 text-center">
                        
							<button type="submit" class="btn btn-outline-primary btn-lg mr-1 mb-1 btn-block round"><i class="fa fa-check-circle"></i> Lưu thông tin</button>
						</div>
                       
				</form>
			</div>
		</div>
	</div>

		<!-- ////////////////////////////////////////////////////////////////////////////-->

		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />