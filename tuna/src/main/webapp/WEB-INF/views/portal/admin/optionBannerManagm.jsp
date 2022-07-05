<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>optionBannerManagm</title>
	
	<!-- Stylesheets -->
	<!-- Page JS Plugins CSS -->
	<link rel="stylesheet" href="${path}/assets/js/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css">
	<!-- End Stylesheets -->
</head>
<body>
	<!-- Page Content -->
	<div class="content">
		<div class="block block-rounded">
			<div class="block-header block-header-default">
				<h3 class="block-title">옵션 바로가기 배너 등록</h3>
				<div class="block-options">
					<button type="button" class="btn btn-sm btn-dark">배너 등록</button>
				</div>
			</div>
		    <div class="block-content block-content-full">
				<div class="content content-full">
			        <div class="row justify-content-center">
						<div class="col-xl-10">
							<!-- Banner Preview -->
							<div id="shortcut-banner" class="block-content box banner">
								<button id="shortcut-btn" class="btn btn-alt-secondary" href="#">바로가기</button>
								<img class="banner-img" src="#" alt="">
							</div>
							<!-- END Banner Preview -->
							<!-- Form -->
				            <div class="row">
								<div class="col-xl-6">
									<h2 class="content-heading">사진 올리기 <span class="text-danger">*</span></h2>
									<div class="mb-4">
										<input class="form-control" type="file" id="" name="" required="required">
									</div>
								</div>
							<div class="col-xl-6">
								<h2 class="content-heading">URL 옵션 <span class="text-danger">*</span></h2>
				                <div class="mb-4">
									<select class="form-select" id="" name="" required="required">
					                    <option selected>옵션 선택</option>
					                    <option value="semesterReport">당해학기 성적 조회</option>
					                    <option value="lectureEvaluation">강의평가</option>
				                  </select>
				                </div>
				              </div>
				            </div>
				            <h2 class="content-heading">게시일자 <span class="text-danger">*</span></h2>
				            <div class="mb-4">
				              <div class="input-daterange input-group" data-date-format="mm/dd/yyyy" data-week-start="1"
				                data-autoclose="true" data-today-highlight="true">
				                <input type="text" class="form-control" id="" name="" required="required"
				                  placeholder="From" data-week-start="1" data-autoclose="true" data-today-highlight="true">
				                <span class="input-group-text fw-semibold">
				                  <i class="fa fa-fw fa-arrow-right"></i>
				                </span>
				                <input type="text" class="form-control" id="" name="" required="required"
				                  placeholder="To" data-week-start="1" data-autoclose="true" data-today-highlight="true">
				              </div>
				            </div>
				            <!-- END Form -->
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
	<!-- END Page Content -->

	<!-- Script -->
	<script src="${path}/assets/js/lib/jquery.min.js"></script>
	<script src="${path}/assets/js/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<!-- Page JS Helpers (BS Datepicker) -->
	<script>One.helpersOnLoad(['jq-datepicker']);</script>
	<!-- END Script -->
</body>
</html>