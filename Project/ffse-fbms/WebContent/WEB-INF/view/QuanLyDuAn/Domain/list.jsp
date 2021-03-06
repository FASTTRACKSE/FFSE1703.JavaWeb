<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách Nghiệp Vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách Nghiệp Vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<!-- Form search -->
			<div class="row mb-2">
				<form class="col-xs-12"
					action='<c:url value="/chuc-nang-phong-ban/"></c:url>' method="get"
					enctype="multipart/form-data">
					<!-- <div class="frm-search-box form-inline pull-left">
						<label class="mr-sm-2" for="">Từ khóa: </label> <input
							class="form-control" type="text" value="" name="q"
							id="txtkeyword" placeholder="Keyword">&nbsp;
						<button type="submit" id="button" class="btn btn-success">Tìm
							kiếm</button>
					</div> -->
					<div class="pull-right">
						<a href="<c:url value="/qlda/domain/add_form"></c:url>"
							class="btn btn-success button"><i class="fa fa-plus"
							aria-hidden="true"></i> Thêm mới</a>
					</div>
				</form>
			</div>
			<!-- End Form search -->

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageError}
				</div>
			</c:if>
			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Danh sách Nghiệp Vụ</h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="table-responsive">
								<table class="table mb-0">
									<thead class="bg-success">
										<tr>
											<th>STT</th>
											<th>Mã Nghiệp Vụ</th>
											<th>Tên Nghiệp Vụ</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${list}" begin="0"
											varStatus="counter">
											<tr>
												<td>${counter.index + 1}</td>
												<td>${item.maNghiepVu}</td>
												<td>${item.tenNghiepVu}</td>

												<td class="tbl_actions"><a
													href="<c:url value="/qlda/domain/view/${item.maNghiepVu}" />"
													title="view"> <i class="fa fa-eye" aria-hidden="true"></i>view
												</a> <a
													href="<c:url value="/qlda/domain/edit_form/${item.maNghiepVu}" />"
													title="Sửa"> <i class="fa fa-pencil-square-o blue"
														aria-hidden="true"></i>Sửa
												</a> <a
													href="<c:url value="/qlda/domain/delete/${item.maNghiepVu}" />"
													title="Xóa"
													onclick="return confirm('Bạn có chắc muốn xóa ?')"> <i
														class="fa fa-trash red" aria-hidden="true"></i>Delete
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="?page=1">First
												Page</a></li>
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
										<li class="page-item"><a class="page-link"
											href="?page=${lastPage }">Last Page</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
