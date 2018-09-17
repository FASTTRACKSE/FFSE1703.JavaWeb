<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/pickers/daterange/daterangepicker.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/pickers/pickadate/pickadate.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/plugins/forms/wizard.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/plugins/pickers/daterange/daterange.min.css"/>">


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.danhSachHopDong" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyHopDong" /></a></li>
							<li class="breadcrumb-item active"><a
								href="<c:url value = "/quanlynhansutt/"/>"><spring:message
									code="label.danhSachHopDong" /></a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quanlynhansutt/add"/>"><spring:message
										code="label.themHopDong" /></a></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="content-body">
        <!-- Form wizard with number tabs section start -->
        <section id="number-tabs">
          <div class="row">
            <div class="col-12">
              <div class="card">
                <div class="card-header">
                  <h4 class="card-title">Form wizard with number tabs</h4>
                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-h font-medium-3"></i></a>
                  <div class="heading-elements">
                    <ul class="list-inline mb-0">
                      <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                      <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                      <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                      <li><a data-action="close"><i class="ft-x"></i></a></li>
                    </ul>
                  </div>
                </div>
                <div class="card-content collapse show">
                  <div class="card-body">
                    <form action="#" class="number-tab-steps wizard-circle wizard clearfix" role="application" id="steps-uid-0"><div class="steps clearfix"><ul role="tablist"><li role="tab" class="first current" aria-disabled="false" aria-selected="true"><a id="steps-uid-0-t-0" href="#steps-uid-0-h-0" aria-controls="steps-uid-0-p-0"><span class="current-info audible">current step: </span><span class="step">1</span> Step 1</a></li><li role="tab" class="disabled" aria-disabled="true"><a id="steps-uid-0-t-1" href="#steps-uid-0-h-1" aria-controls="steps-uid-0-p-1"><span class="step">2</span> Step 2</a></li><li role="tab" class="disabled" aria-disabled="true"><a id="steps-uid-0-t-2" href="#steps-uid-0-h-2" aria-controls="steps-uid-0-p-2"><span class="step">3</span> Step 3</a></li><li role="tab" class="disabled last" aria-disabled="true"><a id="steps-uid-0-t-3" href="#steps-uid-0-h-3" aria-controls="steps-uid-0-p-3"><span class="step">4</span> Step 4</a></li></ul></div><div class="content clearfix">
                      <!-- Step 1 -->
                      <h6 id="steps-uid-0-h-0" tabindex="-1" class="title current">Step 1</h6>
                      <fieldset id="steps-uid-0-p-0" role="tabpanel" aria-labelledby="steps-uid-0-h-0" class="body current" aria-hidden="false">
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="firstName1">First Name :</label>
                              <input type="text" class="form-control" id="firstName1">
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="lastName1">Last Name :</label>
                              <input type="text" class="form-control" id="lastName1">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="emailAddress1">Email Address :</label>
                              <input type="email" class="form-control" id="emailAddress1">
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="location1">Select City :</label>
                              <select class="custom-select form-control" id="location1" name="location">
                                <option value="">Select City</option>
                                <option value="Amsterdam">Amsterdam</option>
                                <option value="Berlin">Berlin</option>
                                <option value="Frankfurt">Frankfurt</option>
                              </select>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="phoneNumber1">Phone Number :</label>
                              <input type="tel" class="form-control" id="phoneNumber1">
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="date1">Date of Birth :</label>
                              <input type="date" class="form-control" id="date1">
                            </div>
                          </div>
                        </div>
                      </fieldset>
                      <!-- Step 2 -->
                      <h6 id="steps-uid-0-h-1" tabindex="-1" class="title">Step 2</h6>
                      <fieldset id="steps-uid-0-p-1" role="tabpanel" aria-labelledby="steps-uid-0-h-1" class="body" aria-hidden="true" style="display: none;">
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="proposalTitle1">Proposal Title :</label>
                              <input type="text" class="form-control" id="proposalTitle1">
                            </div>
                            <div class="form-group">
                              <label for="emailAddress2">Email Address :</label>
                              <input type="email" class="form-control" id="emailAddress2">
                            </div>
                            <div class="form-group">
                              <label for="videoUrl1">Video URL :</label>
                              <input type="url" class="form-control" id="videoUrl1">
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="jobTitle1">Job Title :</label>
                              <input type="text" class="form-control" id="jobTitle1">
                            </div>
                            <div class="form-group">
                              <label for="shortDescription1">Short Description :</label>
                              <textarea name="shortDescription" id="shortDescription1" rows="4" class="form-control"></textarea>
                            </div>
                          </div>
                        </div>
                      </fieldset>
                      <!-- Step 3 -->
                      <h6 id="steps-uid-0-h-2" tabindex="-1" class="title">Step 3</h6>
                      <fieldset id="steps-uid-0-p-2" role="tabpanel" aria-labelledby="steps-uid-0-h-2" class="body" aria-hidden="true" style="display: none;">
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="eventName1">Event Name :</label>
                              <input type="text" class="form-control" id="eventName1">
                            </div>
                            <div class="form-group">
                              <label for="eventType1">Event Type :</label>
                              <select class="custom-select form-control" id="eventType1" data-placeholder="Type to search cities" name="eventType1">
                                <option value="Banquet">Banquet</option>
                                <option value="Fund Raiser">Fund Raiser</option>
                                <option value="Dinner Party">Dinner Party</option>
                                <option value="Wedding">Wedding</option>
                              </select>
                            </div>
                            <div class="form-group">
                              <label for="eventLocation1">Event Location :</label>
                              <select class="custom-select form-control" id="eventLocation1" name="location">
                                <option value="">Select City</option>
                                <option value="Amsterdam">Amsterdam</option>
                                <option value="Berlin">Berlin</option>
                                <option value="Frankfurt">Frankfurt</option>
                              </select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="jobTitle2">Event Date - Time :</label>
                              <div class="input-group">
                                <input type="text" class="form-control datetime" id="jobTitle2">
                                <div class="input-group-append">
                                  <span class="input-group-text">
                                    <span class="ft-calendar"></span>
                                  </span>
                                </div>
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="eventStatus1">Event Status :</label>
                              <select class="custom-select form-control" id="eventStatus1" name="eventStatus">
                                <option value="Planning">Planning</option>
                                <option value="In Progress">In Progress</option>
                                <option value="Finished">Finished</option>
                              </select>
                            </div>
                            <div class="form-group">
                              <label>Requirements :</label>
                              <div class="c-inputs-stacked">
                                <div class="d-inline-block custom-control custom-checkbox">
                                  <input type="checkbox" name="status1" class="custom-control-input" id="staffing1">
                                  <label class="custom-control-label" for="staffing1">Staffing</label>
                                </div>
                                <div class="d-inline-block custom-control custom-checkbox">
                                  <input type="checkbox" name="status1" class="custom-control-input" id="catering1">
                                  <label class="custom-control-label" for="catering1">Catering</label>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </fieldset>
                      <!-- Step 4 -->
                      <h6 id="steps-uid-0-h-3" tabindex="-1" class="title">Step 4</h6>
                      <fieldset id="steps-uid-0-p-3" role="tabpanel" aria-labelledby="steps-uid-0-h-3" class="body" aria-hidden="true" style="display: none;">
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="meetingName1">Name of Meeting :</label>
                              <input type="text" class="form-control" id="meetingName1">
                            </div>
                            <div class="form-group">
                              <label for="meetingLocation1">Location :</label>
                              <input type="text" class="form-control" id="meetingLocation1">
                            </div>
                            <div class="form-group">
                              <label for="participants1">Names of Participants</label>
                              <textarea name="participants" id="participants1" rows="4" class="form-control"></textarea>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="decisions1">Decisions Reached</label>
                              <textarea name="decisions" id="decisions1" rows="4" class="form-control"></textarea>
                            </div>
                            <div class="form-group">
                              <label>Agenda Items :</label>
                              <div class="c-inputs-stacked">
                                <div class="custom-control custom-checkbox">
                                  <input type="checkbox" name="agenda1" class="custom-control-input" id="item11">
                                  <label class="custom-control-label" for="item11">1st item</label>
                                </div>
                                <div class="custom-control custom-checkbox">
                                  <input type="checkbox" name="agenda1" class="custom-control-input" id="item12">
                                  <label class="custom-control-label" for="item12">2nd item</label>
                                </div>
                                <div class="custom-control custom-checkbox">
                                  <input type="checkbox" name="agenda1" class="custom-control-input" id="item13">
                                  <label class="custom-control-label" for="item13">3rd item</label>
                                </div>
                                <div class="custom-control custom-checkbox">
                                  <input type="checkbox" name="agenda1" class="custom-control-input" id="item14">
                                  <label class="custom-control-label" for="item14">4th item</label>
                                </div>
                                <div class="custom-control custom-checkbox">
                                  <input type="checkbox" name="agenda1" class="custom-control-input" id="item15">
                                  <label class="custom-control-label" for="item15">5th item</label>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </fieldset>
                    </div><div class="actions clearfix"><ul role="menu" aria-label="Pagination"><li class="disabled" aria-disabled="true"><a href="#previous" role="menuitem">Previous</a></li><li aria-hidden="false" aria-disabled="false"><a href="#next" role="menuitem">Next</a></li><li aria-hidden="true" style="display: none;"><a href="#finish" role="menuitem">Submit</a></li></ul></div></form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <!-- Form wizard with number tabs section end -->
      </div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />

<script src="<c:url value="/resources/vendors/js/extensions/jquery.steps.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/vendors/js/pickers/dateTime/moment-with-locales.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/vendors/js/pickers/daterange/daterangepicker.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.date.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/vendors/js/forms/validation/jquery.validate.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/scripts/customizer.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/scripts/forms/wizard-steps.min.js"/>" type="text/javascript"></script>