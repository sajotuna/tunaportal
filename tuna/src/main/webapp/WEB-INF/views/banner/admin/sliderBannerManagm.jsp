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
	<title>sliderBannerManagm</title>
	
	<!-- Stylesheets -->
	<!-- Page JS Plugins CSS -->
	<link rel="stylesheet" href="${path}/assets/js/plugins/dropzone/min/dropzone.min.css">
	<link rel="stylesheet" href="${path}/assets/js/plugins/slick-carousel/slick.css">
	<link rel="stylesheet" href="${path}/assets/js/plugins/slick-carousel/slick-theme.css">
	<!-- End Stylesheets -->
</head>
<body>
	<!-- Page Content -->
	<div class="mt-3">
	<div class="content">
		<p class="h3 fw-bold">슬라이드 배너 등록 및 삭제</p>
		<div class="block block-rounded">
			<div class="block-content block-content-full">
				<div class="m-3">
				<!-- Image Preview -->
				<div class="block block-rounded block-themed mb-4">
					<div id="preview-img" style="background: #eeeeee; height:350px;">
						<img src="#">
					</div>
				</div>
				<!-- END Image Preview -->
				<!-- Image List -->
				<div class="block block-rounded block-themed mb-4">
					<div class="block-header bg-primary-darker">
						<h4 class="block-title">배너 사진 목록</h4>
						<div class="block-options">
						<button type="button" class="btn btn-sm btn-light" style="margin-right: 10px;">삭제</button>
						<button type="button" class="btn btn-sm btn-light">사진 올리기</button>
						</div>
					</div>
					<table class="table table-striped table-hover table-vcenter">
						<thead>
							<tr>
								<th class="d-none d-sm-table-cell" style="width: 30px;">
									<input class="form-check-input" type="checkbox">
								</th>
								<th class="d-none d-sm-table-cell">파일명</th>
								<th style="width: 30px;"></th>
								<th style="width: 30px;"></th>
							</tr>
						</thead>
						<tbody>
							<tr scope="row">
								<td class="fw-semibold fs-sm">
									<input class="form-check-input" type="checkbox">
								</td>
								<td class="fw-semibold fs-sm">banner-1.jpg</td>
								<td class="fs-sm">
									<button class="btn btn-sm" type="button"><i class="fa fa-arrow-up"></i></button>
								</td>
								<td class="fw-semibold fs-sm">
									<button class="btn btn-sm" type="button"><i class="fa fa-arrow-down"></i></button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="d-flex justify-content-center mt-5">
						<button type="button" class="btn btn-sm btn-dark"
							data-bs-toggle="modal" data-bs-target="#modal-block-vcenter">배너 미리보기</button>
            		</div>
				</div>
				<!-- END Image List -->
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- END Page Content -->
	
	<!-- Banner Preview Modal -->
	<div class="modal" id="modal-block-vcenter" tabindex="-1" role="dialog" aria-labelledby="modal-block-vcenter" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="block block-rounded block-transparent mb-0">
					<div class="block-header block-header-default">
						<h3 class="block-title">슬라이드 배너 미리보기</h3>
						<div class="block-options">
							<button type="button" class="btn-block-option" data-bs-dismiss="modal" aria-label="Close">
								<i class="fa fa-fw fa-times"></i>
							</button>
						</div>
					</div>
					<div class="block block-rounded">
						<div class="block-content box banner">
							<div class="js-slider slick-dotted-inner slick-dotted-white box"
								data-dots="true" data-autoplay="true" data-autoplay-speed="1800">
								<div>
									<img class="img-fluid" src="#" alt="">
								</div>
								<div>
									<img class="img-fluid" src="#" alt="">
								</div>
								<div>
									<img class="img-fluid" src="#" alt="">
								</div>
								<div>
									<img class="img-fluid" src="#" alt="">
								</div>
							</div>
						</div>
					</div>
					<div class="block-content block-content-full text-end bg-body">
						<button type="button" class="btn btn-sm btn-alt-secondary me-1" data-bs-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-sm btn-primary" data-bs-dismiss="modal">등록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END Banner Preview Modal -->

	<!-- Script -->
	<script src="${path}/assets/js/lib/jquery.min.js"></script>
	<script src="${path}/assets/js/plugins/dropzone/min/dropzone.min.js"></script>
	<script src="${path}/assets/js/plugins/slick-carousel/slick.min.js"></script>
	<!-- Page JS Helpers (Slick Slider Plugin) -->
	<script>One.helpersOnLoad([ 'jq-slick' ]);</script>
	<!-- END Script -->
</body>
</html>