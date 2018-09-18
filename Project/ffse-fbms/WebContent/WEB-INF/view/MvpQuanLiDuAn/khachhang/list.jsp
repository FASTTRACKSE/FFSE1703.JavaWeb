<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:url var="createlink" value="/khachhang/create" />
<c:url var="updatelink" value="/khachhang/update/" />
<c:url var="deletelink" value="/khachhang/delete/" />
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title"><spring:message code="khachhang.list" /></h4>
                <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
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
                <div class="card-block card-dashboard">
                    <!-- phần view flashmessage -->
					<c:if test="${message !=null }">
						<div id="message" class="alert alert-success mb-2" role="alert">
							${message }</div>
					</c:if>
					<!-- end flash message -->
                     <p><a href="${createlink }"><span class="text-bold-600"><spring:message code="khachhang.add" /></span> </a></p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    
                                    <th><spring:message code="khachhang.code" /></th>
                                    <th><spring:message code="khachhang.name" /></th>
                                    <th><spring:message code="khachhang.phone" /></th>
                                    <th><spring:message code="khachhang.email" /></th>
                                    <th><spring:message code="khachhang.business" /></th>
                                    <th><spring:message code="khachhang.address" /></th>
                                    <th><spring:message code="ngonngu.action" /></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="khachhang" items="${list }" varStatus="count"   >
                                <tr>
                                    <th scope="row">${count.count  }</th>
                                    <td>${khachhang.maKhachHang }</td>
                                    <td>${khachhang.tenKhachHang }</td>
                                    <td>${khachhang.phoneNumber }</td>
                                    <td>${khachhang.email }</td>
                                    <td>${khachhang.nghiepVu }</td>
                                    <td>${khachhang.diaChi }</td>
                                    <td><a href="${updatelink }${khachhang.maKhachHang }" data-toggle="tooltip" title="edit!"><button type="button" class="btn btn-icon btn-outline-warning"><i class="fa fa-gavel"></i></button></a>
                                    	<button type="button"
												class="btn btn-outline-danger btn-icon checkid"
												data-toggle="modal"
												data-link="${deletelink }${khachhang.maKhachHang }"
												data-target="#danger">
												<i class="fa fa-trash-o"></i>
											</button>
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
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<script>
	$(document).ready(function() {
		$('.checkid').click(function() {
			var link = $(this).attr("data-link");
			$("#deletemodal").attr("href", link);
		});
	});
</script>
<!-- modal -->
<div class="modal fade text-xs-left" id="danger" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel10" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header bg-danger white">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel10">
					<spring:message code="database.delete" />
				</h4>
			</div>
			<div class="modal-body">
				<h5>
					<spring:message code="database.confirm" />
				</h5>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn grey btn-outline-secondary"
					data-dismiss="modal">
					<spring:message code="btn.no" />
				</button>
				<a id="deletemodal" href="${deletelink }"><button type="button"
						class="btn btn-outline-danger">
						<spring:message code="btn.yes" />
					</button></a>
			</div>
		</div>
	</div>
</div>