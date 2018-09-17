<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">Thêm nhân viên</h3> <!-- title -->
	
                    <form:form class="form" method="GET" modelAttribute="formHoSoNhanVien" action="" enctype="multipart/form-data">
                      <div class="form-body">
                        <h4 class="form-section"><i class="ft-user"></i>Thông tin cơ bản</h4>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput1">Mã nhân viên</label>
                              <form:input path="maNv" type="number" id="projectinput1" class="form-control" placeholder="Mã nhân viên"
                              name="maNhanVienInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Họ tên</label>
                              <form:input path="hoTenNv" type="text" id="projectinput2" class="form-control" placeholder="Họ tên"
                              name="hoTenInput" />
                            </div>
                          </div>
                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="projectinput2">Email</label>
                              <form:input path="email" type="text" id="projectinput2" class="form-control" placeholder="Email"
                              name="emailInput" />
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput3">Giới tính</label>
                              <form:input path="gioiTinh" type="text" id="projectinput3" class="form-control" placeholder="Giới tính" name="gioiTinhRadio" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày sinh</label>
                              <form:input path="ngaySinh" type="date" id="projectinput4" class="form-control" placeholder="Ngày sinh" name="ngaySinhInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số điện thoại</label>
                              <form:input path="sDT" type="number" id="projectinput4" class="form-control" placeholder="Số điện thoại" name="soDienThoaiInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số CMND</label>
                              <form:input path="cMND" type="number" id="projectinput4" class="form-control" placeholder="Số CMND" name="soCMNDInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Nơi cấp</label>
                              <form:input path="noiCap" type="text" id="projectinput4" class="form-control" placeholder="Nơi cấp" name="noiCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày cấp</label>
                              <form:input path="ngayCap" type="date" id="projectinput4" class="form-control" placeholder="Ngày cấp" name="ngayCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Quốc tịch</label>
                              <form:select path="quocTich" type="text" id="projectinput4" class="form-control" name="quocTichSelect">
                              		<option value="none" selected="" >Chọn quốc tịch</option>
                              	 <c:forEach items="${listQuocTich}" var="x">
                              		<option value="${x.maNuoc}" >${x.tenNuoc}</option>
                              	 </c:forEach>
                              </form:select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Dân tộc</label>
                              <form:input path="danToc" type="text" id="projectinput4" class="form-control" placeholder="Dân tộc" name="danTocInput" />
                            </div>
                          </div>
                          
                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="projectinput4">Nơi ở hiện nay</label>
                              <form:textarea path="noiOHienNay" type="text" id="projectinput4" class="form-control" placeholder="Nơi ở hiện nay" name="noiOHienNayInput" />
                            </div>
                          </div>
                        </div>
                        <h4 class="form-section"><i class="fa fa-paperclip"></i>Thông tin quê quán</h4>
                        <div class="form-group">
                          <label for="companyName">Thành Phố</label>
                          <form:select path="thanhPho" type="text" id="companyName" class="form-control"
                          name="thanhPhoSelect">
                          		<option value="none" selected="" >Chọn thành phố</option>
                          	  <c:forEach items="${listThanhPho}" var="x">
                              	<option value="${x.maTinhThanh}" >${x.tenTinhThanh}</option>
                              </c:forEach>
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="companyName">Quận huyện</label>
                          <form:select path="quanHuyen" type="text" id="companyName" class="form-control"
                          name="quanHuyenSelect">
                          		<option value="none" selected="" >Chọn quận huyện</option>
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="companyName">Phường xã</label>
                          <form:select path="phuongXa" type="text" id="companyName" class="form-control"
                          name="phuongXaSelect">
                          		<option value="none" selected="" >Chọn phường xã</option>
                          </form:select>
                        </div>
                        
                      </div>
                      
                      <h4 class="form-section"><i class="fa fa-paperclip"></i>Phòng Ban</h4>
                        <div class="form-group">
                          <label for="companyName">Phòng ban</label>
                          <form:select path="maPhongBan" type="text" id="companyName" class="form-control"
                          name="phongBanSelect">
                          		<option value="none" selected="" >Chọn Phòng ban</option>
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="companyName">Chức danh</label>
                          <form:select path="maChucDanh" type="text" id="companyName" class="form-control" placeholder="Company Name"
                          name="chucDanhSelect">
                          		<option value="none" selected="" >Chọn chức danh</option>
                          </form:select>
                        </div>
                        
                        <div class="form-group">
                          <label>Ảnh đại diện</label>
                          <label id="projectinput7" class="file center-block">
                            <form:input path="avatar" type="file" id="file" />
                            <span class="file-custom"></span>
                          </label>
                        </div>
                        <div class="form-actions">
                        <button type="button" class="btn btn-warning mr-1">
                          <i class="ft-x"></i> Hủy
                        </button>
                        <button type="submit" class="btn btn-primary">
                          <i class="fa fa-check-square-o"></i> Lưu
                        </button>
                      </div>
                    </form:form>
                    
                      </div>
                      
		
	</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />