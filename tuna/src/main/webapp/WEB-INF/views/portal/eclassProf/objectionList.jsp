<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>objectionList</title>
</head>
<body>
	<!-- Page Content -->
	<div class="mt-3">
		<div class="content content-boxed">
			<!-- Block -->
			<div class="block block-rounded mb-4">
				<div class="block-header block-header-default">
					<h3 class="block-title">학기별 이의신청 조회</h3>
				</div>
				<div class="block-content block-content-full">
					<!-- Input -->
					<div class="row">
						<div class="col-lg-6">
							<div class="mb-4">
								<select class="form-select" id="" name="">
									<option selected>연도</option>
									<option value="2022">2022</option>
									<option value="2021">2021</option>
									<option value="2020">2020</option>
								</select>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="mb-4">
								<select class="form-select" id="" name="">
									<option selected>학기</option>
									<option value="1">1</option>
									<option value="2">2</option>
								</select>
							</div>
						</div>
					</div>
					<!-- END Input -->
					<!-- Table -->
					<div class="mb-4">
						<table class="table table-hover table-striped table-vcenter">
							<thead>
								<tr>
									<th class="d-none d-sm-table-cell" style="width: 120px;">과목번호</th>
									<th class="d-none d-sm-table-cell">과목명</th>
									<th class="d-none d-sm-table-cell" style="width: 200px;">개설학과</th>
									<th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
									<th class="d-none d-sm-table-cell" style="width: 100px;">담당교수</th>
									<th class="d-none d-sm-table-cell" style="width: 100px;">학생명</th>
									<th class="d-none d-sm-table-cell">이의신청일</th>
									<th class="d-none d-sm-table-cell" style="width: 100px;">답변</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td scope="row" class="fw-semibold fs-sm">49171-01</td>
									<td class="fw-semibold fs-sm">비주얼인포메이션디자인(2)</td>
									<td class="fw-semibold fs-sm">예술대학 디자인학부</td>
									<td class="fw-semibold fs-sm">전공</td>
									<td class="fw-semibold fs-sm">이설민</td>
									<td class="fw-semibold fs-sm">지수빈</td>
									<td class="fw-semibold fs-sm">2022-07-01</td>
									<td class="fw-semibold fs-sm">미등록</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- END Table -->
				</div>
			</div>
			<!-- END Block -->
		</div>
	</div>
	<!-- END Page Content -->
</body>
</html>