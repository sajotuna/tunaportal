<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
<title>portalSchedule</title>
</head>
<body>
    <!--title start-->
    <div class="bg-body-light">
      <div class="content content-full content-boxed">
        <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
          <div class="flex-grow-1">
            <h1 class="h1 fw-bold mb-2">
              학사일정
            </h1>
            <h2 class="fs-base lh-base fw-medium text-muted mb-0">
              Schedule
            </h2>
          </div>
        </div>
      </div>
    </div>
    <!--title end-->
    <div class="content content-boxed">


      <!--search end-->
      <div class="block block-rounded">
        <div class="block-header block-header-default">
          <div class="block-title">
            <div class="row">
            <button type="button" class="btn btn-outline-secondary"
              style="border:none; height:38px; width: 40px;"><i class="fa fa-arrow-left"></i></button>
              <div class="col-3">
                <select class="form-select">
                    <option value="1">2022 1학기</option>
                    <option value="2">2022 2학기</option>
                    <option value="3">2021 1학기</option>
                </select>
            </div>
            <button type="button" class="btn btn-outline-secondary" style="border:none; height:38px;  width: 40px;"><i
                class="fa fa-arrow-right"></i></button>
              </div>
          </div>
          <div class="block-obtions">
            <!--search start-->
            <form action="be_pages_blog_classic.html" method="POST">
              <div class="input-group">
                <input type="text" class="form-control form-control-alt" placeholder="Search">
                <button class="btn btn-alt-secondary">
                  <i class="fa fa-search"></i>
                </button>
              </div>
            </form>
          </div>
        </div>
        <div class="block-content">
          <table class="table table-bordered table-striped table-vcenter js-dataTable-full dataTable no-footer"
            id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
            <thead>
              <tr>
                <th class="text-center" style="width: 80px;" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1"
                  colspan="1">월</th>
                <th class="text-center" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1">일</th>
                <th class="text-center" style="width: 30%;" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1"
                  colspan="1">학사내용</th>
              </tr>
            </thead>
            <tbody>
              <tr class="odd">
                <td class="text-center fs-sm sorting_1 col-1" rowspan="3">2</td>
                <td class="fw-semibold fs-sm text-center">02. 07 ~ 02. 18</td>
                <td class="d-none d-sm-table-cell fs-sm">
                  2022학년도 1학기 전공학과 변경신청 및 복학원 제출
                </td>
              </tr>
              <tr class="even">
                <td class="fw-semibold fs-sm  text-center col-2">02. 11</td>
                <td class="d-none d-sm-table-cell fs-sm">
                  2022년 2월 학위수여 (2021학년도 학위수여일)
                </td>
              </tr>
              <tr class="odd">
                <td class="fw-semibold fs-sm  text-center col-2">02. 17 ~ 03. 02</td>
                <td class="d-none d-sm-table-cell fs-sm">
                  수강신청 확인 및 정정
                </td>
              </tr>
              <tr class="odd">
                <td class="text-center fs-sm sorting_1 col-2" rowspan="3">3</td>
                <td class="fw-semibold fs-sm text-center">03. 01</td>
                <td class="d-none d-sm-table-cell fs-sm">
                  삼일절 (공휴일)
                </td>
              </tr>
              <tr class="even">
                <td class="fw-semibold fs-sm  text-center col-2">03. 18</td>
                <td class="d-none d-sm-table-cell fs-sm">
                  수업일수 1/4선, 연계진학자 학점이월신청 마감
                </td>
              </tr>

            </tbody>
          </table>
        </div>
      </div>
    </div>

</body>
</html>