<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>portalNoticeList</title>
  <link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
</head>
<body>
     <!--title start-->
    <div class="bg-body-light">
      <div class="content content-full content-boxed">
        <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
          <div class="flex-grow-1">
            <h1 class="h1 fw-bold mb-2">
            학사공지
            </h1>
            <h2 class="fs-base lh-base fw-medium text-muted mb-0">
            notice
            </h2>
          </div>         
        </div>
      </div>
    </div>
    <!--title end-->
    <div class="content content-boxed">
      <div class="block block-rounded">
        <div class="block-content">
          <div class="row ">
            <!-- Search Form (visible on larger screens) -->
            <form class="row d-flex justify-content-end" action="" method="POST">
              <div class="col-2">
                <select class="form-select">
                  <option value="1">제목</option>
                  <option value="2">내용</option>
                </select>
              </div>
              <div class="col-3 p-0">
                <div class="input-group">
                    <input type="text" class="form-control form-control-alt" placeholder="Search">
                    <button class="btn btn-alt-secondary">
                      <i class="fa fa-search"></i>
                    </button>
                  </div>
            </div>
            </form>
          </div>
          <!-- END Search Form -->


          <!-- If you put a checkbox in thead section, it will automatically toggle all tbody section checkboxes -->
          <table class="js-table-checkable table table-hover table-vcenter">
            <!--thead 표 제목-->
            <thead>
              <tr>
                <th class="text-center" style="width: 10%;">#</th>
                <th style="text-align:center">제목</th>
                <th style=" text-align:center; width: 10%; height: 10%;">첨부파일</th>
                <th class="d-none d-sm-table-cell" style="text-align: center; width: 20%;">Date</th>
              </tr>
            </thead>
            <!--tbody 표 내용-->
            <tbody>
              <tr>
                <th class="text-center" scope="row">1</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html"> 2022-2 생활관 2차 입사 신청 안내</a>
                  </p>

                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align:center;">
                  <em class="fs-sm text-muted">November 16, 2018</em>
                </td>
              </tr>
              <tr>
                <th class="text-center" scope="row">2</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>

                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 19, 2018</em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">3</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>

                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 23, 2018</em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">4</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>

                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 5, 2018 </em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">5</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>

                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 4, 2018 </em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">6</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>
                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 26, 2018</em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">7</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>
                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 26, 2018</em>
                </td>
              </tr>
              <tr>
    
                <th class="text-center" scope="row">8</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>
                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 26, 2018</em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">9</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>
                </td>
                <td> </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 26, 2018</em>
                </td>
              </tr>
              <tr>

                <th class="text-center" scope="row">10</th>
                <td class="fs-sm">
                  <p class="fw-semibold mb-1">
                    <a href="be_pages_generic_profile.html">학사 공지</a>
                  </p>
                </td>
                <td>
                  <div>
                    <p style=" text-align: center; margin:0 0 0 0"><i class="far fa fa-file"></i></p>
                  </div>
                </td>
                <td class="d-none d-sm-table-cell" style="text-align: center;">
                  <em class="fs-sm text-muted">November 26, 2018</em>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="block-content d-flex justify-content-center ">
          <nav aria-label="Page navigation">
            <ul class="pagination pagination-sm">
              <li class="page-item">
                <a class="page-link" href="javascript:void(0)" aria-label="Previous">
                  <span aria-hidden="true">
                    <i class="fa fa-angle-left"></i>
                  </span>
                  <span class="visually-hidden">Previous</span>
                </a>
              </li>
              <li class="page-item">
                <a class="page-link" href="javascript:void(0)">1</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="javascript:void(0)">2</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="javascript:void(0)">3</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="javascript:void(0)" aria-label="Next">
                  <span aria-hidden="true">
                    <i class="fa fa-angle-right"></i>
                  </span>
                  <span class="visually-hidden">Next</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
<script src="${path}/assets/js/oneui.app.min.js"></script>
</body>
</html>