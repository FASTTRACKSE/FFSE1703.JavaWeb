<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<!-- Header -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
	
	<h3 class="content-header-title mb-0"><spring:message code="label.suaNhanVien" /></h3> <!-- title -->
	
                    <form:form class="form" method="POST" action="/ffse-fbms/quantrinhansu/hosonhanvien/update" modelAttribute="formHosopkl"  enctype="multipart/form-data">
                      <div class="form-body">
                        <h4 class="form-section"><i class="ft-user"></i><spring:message code="label.thongTinCoBan" /></h4>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="maNhanVienId"><spring:message code="label.maNhanVien" /></label>
                              <form:input path="maNv" type="number" id="maNhanVienId" class="form-control" placeholder="Mã nhân viên"
                              name="maNhanVienInput"/>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2"><spring:message code="label.hoTen" /></label>
                              <form:input path="hoTenNv" type="text" id="projectinput2" class="form-control" placeholder="Họ tên"
                              name="hoTenInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Email</label>
                              <form:input path="email" type="text" id="projectinput2" class="form-control" placeholder="Email"
                              name="emailInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2"><spring:message code="label.quanHe" /></label>
                              <form:select path="tinhTrangHonNhan" type="text" id="projectinput2" class="form-control"
                              name="tinhTrangHonNhanRadio">
                              		<form:option value=""><spring:message code="label.chonQuanHe" /></form:option>
                              		<form:option value="0" ><spring:message code="label.chuaKetHon" /></form:option>
                              		<form:option value="1" ><spring:message code="label.daKetHon" /></form:option>
                              </form:select>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput3"><spring:message code="label.gioiTinh" /></label>
                              <form:select path="gioiTinh" type="text" id="projectinput3" class="form-control" placeholder="Giới tính" name="gioiTinhRadio">
                              		<form:option value="none"><spring:message code="label.chonGioiTinh" /></form:option>
                              		<form:option value="Nam" ><spring:message code="label.nam" /></form:option>
                              		<form:option value="Nữ" ><spring:message code="label.nu" /></form:option>
                              </form:select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.ngaySinh" /></label>
                              <form:input path="ngaySinh" type="date" id="projectinput4" class="form-control" placeholder="Ngày sinh" name="ngaySinhInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.sdt" /></label>
                              <form:input path="sDT" type="number" id="projectinput4" class="form-control" placeholder="Số điện thoại" name="soDienThoaiInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.cmnd" /></label>
                              <form:input path="cMND" type="number" id="projectinput4" class="form-control" placeholder="Số CMND" name="soCMNDInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.noiCap" /></label>
                              <form:input path="noiCap" type="text" id="projectinput4" class="form-control" placeholder="Nơi cấp" name="noiCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.ngayCap" /></label>
                              <form:input path="ngayCap" type="date" id="projectinput4" class="form-control" placeholder="Ngày cấp" name="ngayCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.quocTich" /></label>
                              <form:select path="quocTich" type="text" id="projectinput4" class="form-control" name="quocTichSelect">
                              		<form:option value="none"><spring:message code="label.chonQuocTich" /></form:option>
                              	 <c:forEach items="${listQuocTich}" var="x">
                              		<form:option value="${x.tenNuoc}" >${x.tenNuoc}</form:option>
                              	 </c:forEach>
                              </form:select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.danToc" /></label>
                              <form:input path="danToc" type="text" id="projectinput4" class="form-control" placeholder="Dân tộc" name="danTocInput" />
                            </div>
                          </div>
                          
                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="projectinput4"><spring:message code="label.noiOHienNay" /></label>
                              <form:textarea path="noiOHienNay" type="text" id="projectinput4" class="form-control" placeholder="Nơi ở hiện nay" name="noiOHienNayInput" />
                            </div>
                          </div>
                        </div>
                        <h4 class="form-section"><i class="fa fa-paperclip"></i><spring:message code="label.thongTinQueQuan" /></h4>
                        <div class="form-group">
                          <label for="thanhPhoId"><spring:message code="label.thanhPho" /></label>
                          <form:select path="thanhPho.maTinhThanh" type="text" id="thanhPhoId" class="form-control"
                          				name="thanhPhoSelect" onchange="clickComboboxThanhPho()">
                          		<form:option value="noThanhPho" selected="selected" ><spring:message code="label.chonThanhPho" /></form:option>
    								<c:forEach items="${listThanhPho}" var="x">
                              			<form:option value="${x.maTinhThanh}" >${x.tenTinhThanh}</form:option>
                              		</c:forEach>						
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="quanHuyenId"><spring:message code="label.quanHuyen" /></label>
                          <form:select path="quanHuyen.maQuanHuyen" id="quanHuyenId"  name="quanHuyen" type="text" class="form-control" disabled="true"
                          			onchange="clickComboboxQuan()" >
                          		 <option value="noQuanHuyen" selected="selected" ><spring:message code="label.chonQuanHuyen" /></option>
                          </form:select>
                     
                          
                        </div>
                        <div class="form-group">
                          <label for="phuongXaId"><spring:message code="label.phuongXa" /></label>
                          <form:select path="phuongXa.maPhuong" type="text" id="phuongXaId" class="form-control"
                          name="phuongXaSelect" disabled="true">
                          		<option value="noPhuongXa" selected="selected"><spring:message code="label.chonPhuongXa" /></option>
                          	
                          </form:select>
                        </div>
                        
                      </div>
                      
                      <h4 class="form-section"><i class="fa fa-paperclip"></i><spring:message code="label.phongBan" /></h4>
                        <div class="form-group">
                          <label for="companyName"><spring:message code="label.phongBan" /></label>
                          <form:select path="maPhongBan.maPhongBan" type="text" id="companyName" class="form-control"
                          name="phongBanSelect">
                          		<form:option value=""><spring:message code="label.chonPhongBan" /></form:option>
                          	  <c:forEach items="${listPhongBan}" var="x">
                              	<form:option value="${x.maPhongBan}" >${x.tenPhongBan}</form:option>
                              </c:forEach>
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="companyName"><spring:message code="label.chucDanh" /></label>
                          <form:select path="maChucDanh.maChucDanh" type="text" id="companyName" class="form-control" placeholder="Company Name"
                          name="chucDanhSelect">
                          		<form:option value="" ><spring:message code="label.chonChucDanh" /></form:option>
                          	  <c:forEach items="${listChucDanh}" var="x">
                              	<form:option value="${x.maChucDanh}" >${x.tenChucDanh}</form:option>
                              </c:forEach>
                          </form:select>
                        </div>
                        
                        <div class="form-group">
                          <label><spring:message code="label.anhDaiDien" />:</label> <input id="imgUrl" class="form-control"
						type="file" name="file" /> <br>
						 <img src="<c:url value="/uploads/${formHosopkl.avatar}" />"
						width="100" height="150">
						<img id="img" src="#"
						alt="your image" width="100" height="150" />
						 
                        </div>
             
                        <div class="form-actions">
                        
                        <button type="submit" class="btn btn-primary">
                          <i class="fa fa-check-square-o"></i> <spring:message code="label.luu" />
                        </button>
                      </div>
                    </form:form>
                    <div ><p id="result"></p></div>
                    <button type="button" class="btn btn-warning mr-1" onclick="bam()">
                          <i class="ft-x"></i>  <spring:message code="label.huy" />
                        </button>
                        
                     
                     <script>
                     
                     	window.onload= function(){
                     		clickComboboxThanhPho(); // gọi function này để load quận
                     		
                     	
                    		
                     	}
                     </script>
                        
                     <script type="text/javascript">
                     <!-- ajax select ThanhPho -->
                     function clickComboboxThanhPho(){
                    	 var maThanhPho = $("#thanhPhoId").val();
                    	 if(maThanhPho == 'noThanhPho'){  // nếu người dùng chưa chọn thành phố
                    		 $('#quanHuyenId option').remove();
                    		 $('#quanHuyenId').prop('disabled', true); /*disable combobox quận huyện */
                    		
                    		 $('#phuongXaId option[value=noPhuongXa]').attr('selected', 'selected')
                    		 $('#phuongXaId').prop('disabled', true);
                    		 
                    	 } else{                // nếu người dùng đã chọn thành phố
                    		
                    		 $('#quanHuyenId').prop('disabled', false); /*enable combobox quận huyện */
                    		
                    		 $('#quanHuyenId option').remove(); /* xóa những option quận huyện cũ */
                    	 }
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectquan/" + maThanhPho, 
                        	 dataType: "json",
                        	 success: function(data){
                        		$('#quanHuyenId').append($('<option>', {
                             		    value: 'noQuanHuyen',
                             		    text: 'Chọn Quận Huyện'
                             		}));
                        		
                        		for (var i = 0; i < data.length; i++) {
                        			$('#quanHuyenId').append($('<option>', {
                             		    value: data[i].maQuanHuyen,
                             		    text: data[i].tenQuanHuyen
                             		}));
                        		
								}
                        		$('#quanHuyenId option[value=${formHosopkl.quanHuyen.maQuanHuyen}]').attr('selected', 'selected')
                        			clickComboboxQuan(); // gọi function này để load phường
                        		
                         }});
                     };
                   
                     </script>
                     
                     <script>
                     // ajax select QuanHuyen
                     function clickComboboxQuan(){
                    	 var maQuanHuyen = $("#quanHuyenId").val();
                    	 if(maQuanHuyen == 'noQuanHuyen'){  /* nếu người dùng chưa chọn thành phố */
                    		 $('#phuongXaId option').remove();
                    		 $('#phuongXaId').prop('disabled', true); /*disable combobox quận huyện */
                    		 
                    	 } else{                /* nếu người dùng đã chọn thành phố*/
                    		
                    		 $('#phuongXaId').prop('disabled', false); // enable combobox quận huyện 
                    		 $('#phuongXaId option').remove(); // xóa những option quận huyện cũ
                    	 }
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectphuong/" + maQuanHuyen, 
                        	 dataType: "json",
                        	 success: function(data){
                 
                        		
                        		$('#phuongXaId').append($('<option>', {
                             		    value: 'noPhuongXa',	
                             		    text: 'Chọn phường xã'
                             		}));
                        		
                        		for (var i = 0; i < data.length; i++) {
                        			$('#phuongXaId').append($('<option>', {
                             		    value: data[i].maPhuong,
                             		    text: data[i].tenPhuong
                             		}));
                        			
								}
                        		$('#phuongXaId option[value=${formHosopkl.phuongXa.maPhuong}]').attr('selected', 'selected')
	
                         }});
                     };
                     </script>
                     
                      <!-- preview image -->  
                     <script type="text/javascript">
						function readURL(input) {
						if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
						$('#img').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
						}
						}
						$("#imgUrl").change(function() {
						readURL(this);
						});
					</script>
                     
			
	</div>
</div>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />