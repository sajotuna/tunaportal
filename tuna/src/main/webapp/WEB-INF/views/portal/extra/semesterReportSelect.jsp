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
	<title>semesterReportSelect</title>
	<style>
	.table-div {
		 max-height:300px; 
		 overflow:auto;
	}
	</style>
</head>
<body>
	<!-- Hero -->
	<div class="bg-body-light">
		<div class="content content-full content-boxed">
			<div
				class="d-flex flex-column flex-md-row justify-content-md-between align-items-md-center py-2 text-center text-md-start">
				<div class="flex-grow-1 mb-1 mb-md-0">
					<h2 class="h2 fw-bold mb-2">당해학기 성적 조회</h2>
					<h2 class="h6 fw-medium fw-medium text-muted mb-0 text-gray-dark">
						당해학기의 성적을 조회하는 페이지입니다.</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- END Hero -->
	<!-- Page Content -->
	<div class="mt-3">
		<div class="content content-boxed">
			<!-- Block -->
			<div class="block block-rounded">
			<div class="content content-full">
			<div class="block block-rounded block-themed mb-4">
				<div class="block-header bg-primary-dark">
					<h3 class="block-title">수강 과목 및 성적</h3>
					<div class="block-options">
						<button type="button" class="btn btn-sm btn-light"
							data-bs-toggle="modal" data-bs-target="#modal-block-vcenter">성적 이의신청</button>
					</div>
				</div>
					<div class="table-div">
						<!-- Table -->
						<table class="table table-striped table-vcenter">
							<thead>
								<tr>
									<th class="d-none d-sm-table-cell" style="width: 100px;">년도</th>
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
						<!-- END Table -->
					</div>
			</div>
			<!-- END Block -->
			<!-- Block -->
			<div class="block block-rounded block-themed mb-4">
				<div class="block-header bg-primary-dark">
					<h3 class="block-title">성적 누계</h3>
				</div>
					<!-- Table -->
					<table class="table table-vcenter table-striped">
						<thead>
							<tr>
								<th class="text-center d-none d-sm-table-cell">신청과목수</th>
								<th class="text-center d-none d-sm-table-cell">신청학점</th>
								<th class="text-center d-none d-sm-table-cell">평점평균</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td scope="row" class="text-center fw-semibold fs-sm">10</td>
								<td class="text-center fw-semibold fs-sm">18</td>
								<td class="text-center fw-semibold fs-sm">3.875</td>
							</tr>
						</tbody>
					</table>
					<!-- END Table -->
			</div>
			<!-- END Block -->
			</div>
			</div>
		</div>
	</div>
	<!-- END Page Content -->
	
	<!-- Objection Modal -->
	<div class="modal" id="modal-block-vcenter" tabindex="-1" role="dialog" aria-labelledby="modal-block-vcenter" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-xl"role="document">
			<div class="modal-content">
				<div class="block block-rounded block-transparent mb-0">
					<div class="block-header block-header-default">
						<h3 class="block-title">성적 이의신청 및 답변 조회</h3>
						<div class="block-options">
							<button type="button" class="btn-block-option"
								data-bs-dismiss="modal" aria-label="Close">
								<i class="fa fa-fw fa-times"></i>
							</button>
						</div>
					</div>
					<div class="block-content block-content-full">
						<!-- Block -->
						<div class="block block-rounded block-themed mb-4">
							<div class="block-header bg-primary-dark">
								<h4 class="block-title">강의 목록</h4>
							</div>
							<table class="table table-striped table-hover table-vcenter">
								<thead>
									<tr>
										<th class="d-none d-sm-table-cell" style="width: 100px;">년도</th>
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
									<tr scope="row">
										<td class="fw-semibold fs-sm">2014</td>
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
						<!-- END Block -->
						<!-- Block -->
						<div class="block block-rounded block-themed mb-4">
							<div class="block-header bg-primary-dark">
								<h4 class="block-title">이의신청 및 답변 조회</h4>
							</div>
							<form class="mb-4" action="">
								<table class="table table-vcenter">
									<tr>
										<th scope="row" class="d-none d-sm-table-cell table-active" style="width: 150px;">과목명</th>
										<td class="fw-semibold fs-sm" style="width: 250px;">40753-01/ 타이포그래피(1)</td>
										<th class="d-none d-sm-table-cell table-active" style="width: 150px;">담당교수</th>
										<td class="fw-semibold fs-sm">이설민</td>
										<th class="d-none d-sm-table-cell table-active" style="width: 150px;">진행상태</th>
										<td class="fw-semibold fs-sm">미신청</td>
									</tr>
									<tr>
										<th scope="row" class="d-none d-sm-table-cell table-active" style="width: 150px;">이의신청 내용</th>
										<td class="fw-semibold fs-sm" colspan="5">
											<textarea rows="4" placeholder="내용을 입력하세요." style="width: 100%"></textarea>
										</td>
									</tr>
									<tr>
										<th scope="row" class="d-none d-sm-table-cell table-active"style="width: 150px;">답변</th>
										<td class="fw-semibold fs-sm" colspan="5">수업을 나와야 성적을 주죠. F 맞습니다.</td>
									</tr>
								</table>
							</form>
						</div>
						<!-- END Block -->
					</div>
					
					<div class="block-content block-content-full text-end bg-body">
						<button type="button" class="btn btn-sm btn-alt-secondary me-1"
							data-bs-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-sm btn-primary"
							data-bs-dismiss="modal">등록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END Objection Modal -->

</body>
</html>