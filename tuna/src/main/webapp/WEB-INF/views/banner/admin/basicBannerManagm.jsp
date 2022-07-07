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
	<title>basicBannerManagm</title>
</head>
<body>
	
	<!-- Page Content -->
	<div class="mt-3">
	<div class="content">
		<!-- Block -->
		<p class="h3 fw-bold">기본 바로가기 배너 수정 및 등록</p>
		<div class="block block-rounded justify-content-center">
			<div class="block-content block-content-full">
				<div class="m-3">
					<div class="row justify-content-center">
					
						<div class="col-xl-6">
							<!-- Banner Preview -->
							<div id="shortcut-banner" class="block-content box banner">
								<button id="shortcut-btn" class="btn btn-alt-secondary" href="#">바로가기</button>
								<img class="banner-img" src="#" alt="">
							</div> 
							<!-- END Banner Preview -->
						
							<!-- Form -->
							<form id="basicBannerFrm" action="" method="post">
		          				<h2 class="content-heading">사진 올리기 <span class="text-danger">*</span></h2>
					            <div class="mb-2">
					              <input class="form-control" type="file" id="example-file-input">
					            </div>
	          					<h2 class="content-heading">바로가기 URL <span class="text-danger">*</span></h2>
					            <input type="text" class="form-control" id="val-website" name="val-website" placeholder="http://example.com">
					            <div id="val-website-error" class="invalid-feedback animated fadeIn">정확한 URL을 입력해 주세요.</div>
					    		<div class="d-flex justify-content-center mt-5">
						    		<button type="button" class="btn btn-sm btn-dark m-1">배너 수정</button>
				      				<button type="button" class="btn btn-sm btn-dark m-1">배너 등록</button>
			      				</div>
					    	</form>
					    	<!-- END Form -->
					    	
      					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END Block -->
	</div>
	</div>
	<!-- END Page Content -->
	
	<!-- Script -->
	<script src="${path}/assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${path}/assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${path}/assets/js/pages/be_forms_validation.min.js"></script>
	<!-- END Script -->
</body>
</html>