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
	<title>lectureAndReportSelect</title>
	<style>
	.space-x-2 {
		padding: 7px 15px;
	}
	.chart-margin {
		margin: 2rem 0 6rem 0;
	}
	</style>
</head>
<body>
	<!-- Hero -->
	<div class="bg-body-light">
		<div class="content content-full content-boxed">
			<div class="d-flex flex-column flex-md-row justify-content-md-between align-items-md-center py-2 text-center text-md-start">
				<div class="flex-grow-1 mb-1 mb-md-0">
					<h2 class="h2 fw-bold mb-2">강의 / 성적 조회</h2>
					<h2 class="h6 fw-medium fw-medium text-muted mb-0 text-gray-dark">강의 계획서, 수강 내역 및 성적 조회 페이지입니다.</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- END Hero -->
	<!-- Page Content -->
	<div class="mt-3">
		<div class="content content-boxed">
			<div class="block block-rounded">

				<!-- Tab -->
				<ul class="nav nav-tabs nav-tabs-block" role="tablist">
					<li class="nav-item">
						<button class="nav-link active" id="btabs-static-subject-tab"
							data-bs-toggle="tab" data-bs-target="#btabs-static-subject"
							role="tab" aria-controls="btabs-static-subject"
							aria-selected="true">강의 계획서 조회</button>
					</li>
					<li class="nav-item">
						<button class="nav-link" id="btabs-static-mysubject-tab"
							data-bs-toggle="tab" data-bs-target="#btabs-static-mysubject"
							role="tab" aria-controls="btabs-static-mysubject"
							aria-selected="false">수강 내역 조회</button>
					</li>
					<li class="nav-item">
						<button class="nav-link" id="btabs-static-grade-tab"
							data-bs-toggle="tab" data-bs-target="#btabs-static-grade"
							role="tab" aria-controls="btabs-static-grade"
							aria-selected="false">보관 성적 조회</button>
					</li>
				</ul>
				<!-- END Tab -->

				<!-- Block -->
				<div class="block-content tab-content">
				
					<!-- SUBJECT Tab -->
					<div class="tab-pane active" id="btabs-static-subject"
						role="tabpanel" aria-labelledby="btabs-static-subject-tab">
						<!-- Form -->
						<form class="row" id="" action="" method="post">
							<div class="col-md-6 col-xl-2">
								<div class="mb-2">
									<select class="form-select" id="" name="">
										<option selected>연도</option>
										<option value="1">2022</option>
										<option value="2">2021</option>
										<option value="3">2020</option>
									</select>
								</div>
							</div>
							<div class="col-md-6 col-xl-2">
								<div class="mb-2">
									<select class="form-select" id="example-select"
										name="example-select">
										<option selected>학기</option>
										<option value="1">1</option>
										<option value="2">2</option>
									</select>
								</div>
							</div>
							<div class="col-md-6 col-xl-4">
								<div class="block block-rounded bg-primary-darker mb-2">
									<div class="space-x-2 text-center text-gray-light">
										<div class="form-check form-check-inline">검색 대상</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												id="lecture" name="lecture"
												value="lecture" checked> 
											<label class="form-check-label" for="lecture">과목명</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												id="professor" name="professor"
												value="professor"> 
											<label class="form-check-label" for="professor">교수명</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-xl-3">
								<div class="mb-3">
									<input type="text" class="form-control" id="example-text-input"	name="example-text-input" placeholder="검색어">
								</div>
							</div>
							<div class="col-md-12 col-xl-1">
								<div class="mb-3">
									<button type="submit" class="btn btn-primary w-100">조회</button>
								</div>
							</div>
						</form>
						<!-- END Form -->
						<!-- Table -->
						<div class="mb-4">
							<table class="table table-striped table-vcenter">
								<thead>
									<tr>
										<th class="d-none d-sm-table-cell" style="width: 120px;">과목번호</th>
										<th class="d-none d-sm-table-cell" style="width: 230px;">과목명</th>
										<th class="d-none d-sm-table-cell" style="width: 200px;">개설학과</th>
										<th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
										<th class="d-none d-sm-table-cell" style="width: 100px;">담당교수</th>
										<th class="d-none d-sm-table-cell">강의실/강의시간</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row" class="fw-semibold fs-sm">49171-01</th>
										<td class="fw-semibold fs-sm"><a href="#">비주얼인포메이션디자인(2)</a></td>
										<td class="fw-semibold fs-sm">예술대학 디자인학부</td>
										<td class="fw-semibold fs-sm">전공</td>
										<td class="fw-semibold fs-sm"><a href="#">이설민</a></td>
										<td class="fw-semibold fs-sm">808관(조형관) 423호 시각디자인실 / 화5,6,7,8</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- END Table -->
					</div>
					<!-- END SUBJECT Tab -->

					<!-- MYSUBJECT Tab -->
					<div class="tab-pane" id="btabs-static-mysubject" role="tabpanel" aria-labelledby="btabs-static-mysubject-tab">
						<!-- Input -->
						<div class="row">
							<div class="col-md-6 col-xl-4">
								<div class="mb-2">
									<select class="form-select" id=""	name="">
										<option selected>연도</option>
										<option value="2022">2022</option>
										<option value="2021">2021</option>
										<option value="2020">2020</option>
									</select>
								</div>
							</div>
							<div class="col-md-6 col-xl-4">
								<div class="mb-2">
									<select class="form-select" id="" name="">
										<option selected>학기</option>
										<option value="1">1</option>
										<option value="2">2</option>
									</select>
								</div>
							</div>
							<div class="col-md-6 col-xl-2">
								<div class="block block-rounded bg-primary-darker mb-2">
									<div class="space-x-2 text-center text-gray-light">신청 과목수 0</div>
								</div>
							</div>
							<div class="col-md-6 col-xl-2">
								<div class="block block-rounded bg-primary-darker mb-3">
									<div class="space-x-2 text-center text-gray-light">신청 학점 0</div>
								</div>
							</div>
						</div>
						<!-- END Input -->
						<!-- Table -->
						<div class="mb-4">
							<table class="table table-striped table-vcenter">
								<thead>
									<tr>
										<th class="d-none d-sm-table-cell" style="width: 120px;">과목번호</th>
										<th class="d-none d-sm-table-cell" style="width: 230px;">과목명</th>
										<th class="d-none d-sm-table-cell" style="width: 200px;">개설학과</th>
										<th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
										<th class="d-none d-sm-table-cell" style="width: 100px;">담당교수</th>
										<th class="d-none d-sm-table-cell">강의실/강의시간</th>
										<th class="d-none d-sm-table-cell">강의평가</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td scope="row" class="fw-semibold fs-sm">49171-01</td>
										<td class="fw-semibold fs-sm">비주얼인포메이션디자인(2)</td>
										<td class="fw-semibold fs-sm">예술대학 디자인학부</td>
										<td class="fw-semibold fs-sm">전공</td>
										<td class="fw-semibold fs-sm">이설민</td>
										<td class="fw-semibold fs-sm">808관(조형관) 423호 시각디자인실 /
											화5,6,7,8</td>
										<td class="fw-semibold fs-sm">O</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- END Table -->
					</div>
					<!-- END MYSUBJECT Tab -->

					<!-- GRADE Tab -->
					<div class="tab-pane" id="btabs-static-grade" role="tabpanel"
						aria-labelledby="btabs-static-grade-tab">
						<!-- Bar Chart -->
						<div class="block block-rounded block-themed mb-4">
							<div class="block-header bg-primary-dark">
								<h4 class="block-title">Information</h4>
							</div>
							<div class="flex-grow-1 d-flex align-items-center justify-content-center chart-margin">
								<div class="col-9">
									<canvas id="js-chartjs-earnings"></canvas>
								</div>
							</div>
						</div>
						<!-- END Bar Chart -->
						<!-- Ring Chart -->
						<div class="block block-rounded block-themed mb-4">
							<div class="row justify-content-center chart-margin">
								<div class="col-3">
									<div class="js-pie-chart pie-chart" data-percent="85"
										data-line-width="20" data-size="180" data-bar-color="#abe37d"
										data-track-color="#eeeeee">
										<!-- <div class="text-center mb-4">총 취득 학점</div> -->
										<span>
											<span class="h2">112</span><br> <small class="text-muted">/137</small>
										</span>
									</div>
								</div>
								<div class="col-3">
									<div class="js-pie-chart pie-chart" data-percent="87"
										data-line-width="20" data-size="180" data-bar-color="#fadb7d"
										data-track-color="#eeeeee">
										<!-- <div class="text-center mb-4">총 평점 평균</div> -->
										<span>
											<span class="h2">3.76</span><br> <small class="text-muted">/4.5</small>
										</span>
									</div>
								</div>
								<div class="col-3">
									<div class="js-pie-chart pie-chart" data-percent="91.54"
										data-line-width="20" data-size="180" data-bar-color="#faad7d"
										data-track-color="#eeeeee">
										<!-- <div class="text-center mb-4">백분율 성적</div> -->
										<span>
											<span class="h2">91.54</span><br> <small class="text-muted">/100</small>
										</span>
									</div>
								</div>
							</div>
						</div>
						<!-- END Ring Chart -->
						<!-- Lecture grade list -->
						<div class="block block-rounded block-themed mb-4">
							<div class="block-header bg-primary-dark">
								<h4 class="block-title">과목별 성적 내역</h4>
								<div class="block-options">
									<select class="form-select btn-sm" style="width: 150px;">
										<option selected>연도/학기</option>
										<option value="2022-2">2022년도 2학기</option>
										<option value="2022-1">2022년도 1학기</option>
										<option value="2021-2">2021년도 2학기</option>
									</select>
								</div>
								<div class="block-options">
									<button type="button" class="btn btn-sm btn-light">PDF</button>
								</div>
							</div>
							<!-- Table -->
							<div class="mb-4">
								<table class="table table-striped table-vcenter">
									<thead>
										<tr>
											<th class="d-none d-sm-table-cell" style="width: 100px;">연도</th>
											<th class="d-none d-sm-table-cell" style="width: 100px;">학기</th>
											<th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
											<th class="d-none d-sm-table-cell" style="width: 150px;">교과목-분반</th>
											<th class="d-none d-sm-table-cell">과목명</th>
											<th class="d-none d-sm-table-cell" style="width: 100px;">학점</th>
											<th class="d-none d-sm-table-cell" style="width: 100px;">등급</th>
											<th class="d-none d-sm-table-cell" style="width: 100px;">평점</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td scope="row" class="fw-semibold fs-sm">2014</td>
											<td class="fw-semibold fs-sm">1</td>
											<td class="fw-semibold fs-sm">전공필수</td>
											<td class="fw-semibold fs-sm">40753-01</td>
											<td class="fw-semibold fs-sm">타이포그래피(1)</td>
											<td class="fw-semibold fs-sm">2</td>
											<td class="fw-semibold fs-sm">A+</td>
											<td class="fw-semibold fs-sm">4.5</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- END Table -->
						</div>
						<!-- END Lecture grade list -->
						
						<div class="row">
							<!-- Grade avg -->
							<div class="col-7">
								<div class="block block-rounded block-themed mb-4">
									<div class="block-header bg-primary-dark">
										<h4 class="block-title">평균 평점</h4>
									</div>
									<!-- Table -->
									<div class="mb-4">
										<table class="table table-striped table-vcenter text-center">
											<thead>
												<tr>
													<th class="d-none d-sm-table-cell" style="width: 100px;">연도</th>
													<th class="d-none d-sm-table-cell" style="width: 100px;">학기</th>
													<th class="d-none d-sm-table-cell" style="width: 100px;">취득학점</th>
													<th class="d-none d-sm-table-cell" style="width: 150px;">평점평균</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td scope="row" class="fw-semibold fs-sm">2014</td>
													<td class="fw-semibold fs-sm">1</td>
													<td class="fw-semibold fs-sm">18</td>
													<td class="fw-semibold fs-sm">3.38</td>
												</tr>
											</tbody>
										</table>
									</div>
									<!-- END Table -->
								</div>
							</div>
							<!-- END Grade avg -->
							<!-- Total grade -->
							<div class="col-5">
								<div class="block block-rounded block-themed mb-4">
									<div class="block-header bg-primary-dark">
										<h4 class="block-title">이수구분별 취득 학점</h4>
									</div>
									<!-- Table -->
									<div class="mb-4">
										<table class="table table-striped table-vcenter text-center ">
											<tr>
												<th scope="row" class="d-none d-sm-table-cell" style="width: 50%;">전공기초</th>
												<td class="fw-semibold fs-sm">0</td>
											</tr>
											<tr>
												<th scope="row" class="d-none d-sm-table-cell" style="width: 50%;">전공필수</th>
												<td class="fw-semibold fs-sm">0</td>
											</tr>
											<tr>
												<th scope="row" class="d-none d-sm-table-cell" style="width: 50%;">일반교양</th>
												<td class="fw-semibold fs-sm">0</td>
											</tr>
											<tr>
												<th scope="row" class="d-none d-sm-table-cell" style="width: 50%;">필수교양</th>
												<td class="fw-semibold fs-sm">0</td>
											</tr>
										</table>
									</div>
									<!-- END Table -->
								</div>
							</div>
							<!-- END total grade -->
						</div>
					</div>
					<!-- END GRADE Tab -->
				</div>
				<!-- END Block -->
			</div>
		</div>
	</div>
	<!-- END Page Content -->

	<!-- Script -->
	<script src="${path }/assets/js/oneui.app.min.js"></script>
	<!-- jQuery -->
	<script src="${path}/assets/js/lib/jquery.min.js"></script>
	<!-- Page JS Plugins -->
	<script
		src="${path}/assets/js/plugins/easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script
		src="${path}/assets/js/plugins/jquery-sparkline/jquery.sparkline.min.js"></script>
	<script src="${path}/assets/js/plugins/chart.js/chart.min.js"></script>
	<!-- Page JS Code -->
	<script src="${path}/assets/js/pages/be_comp_charts.min.js"></script>
	<script src="${path}/assets/js/pages/be_pages_dashboard.min.js"></script>
	<!-- Page JS Helpers (Easy Pie Chart + jQuery Sparkline Plugins) -->
	<script>
		One.helpersOnLoad([ 'jq-easy-pie-chart', 'jq-sparkline' ]);
	</script>
	<!-- END Script -->
</body>
</html>