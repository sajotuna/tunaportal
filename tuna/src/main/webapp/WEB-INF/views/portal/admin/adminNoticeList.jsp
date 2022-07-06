<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminNoticeList</title>
</head>
<body>
        <!--title start--> 
            <div class="content content-boxed">
                    <h3 class="fw-bold">학사공지 목록</h3>     
                    <!--title end--> 
                    <div class="block block-rounded">
                        <div class="block-content">
                            <div class="row">
                                <!-- Search Form (visible on larger screens) -->
                                <form class="row d-flex justify-content-end" action="" method="POST">
                                    <div class="col-2">
                                        <select class="form-select">
                                            <option value="1">작성자</option>
                                            <option value="2">제목</option>
                                            <option value="3">내용</option>
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
                                        <th class="text-center" style="width: 70px;">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="check-all"
                                                    name="check-all">
                                                <label class="form-check-label" for="check-all"></label>
                                            </div>
                                        </th>
                                        <th class="text-center" style="width: 10%;">#</th>
                                        <th style="text-align:center">제목</th>
                                        <th style=" text-align:center; width: 10%; height: 10%;">첨부파일</th>
                                        <th class="d-none d-sm-table-cell" style="text-align: center; width: 20%;">Date
                                        </th>
                                    </tr>
                                </thead>
                                <!--tbody 표 내용-->
                                <tbody>
                                    <tr>
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_1"
                                                    name="row_1">
                                                <label class="form-check-label" for="row_1"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_2"
                                                    name="row_2">
                                                <label class="form-check-label" for="row_2"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_3"
                                                    name="row_3">
                                                <label class="form-check-label" for="row_3"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_4"
                                                    name="row_4">
                                                <label class="form-check-label" for="row_4"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_5"
                                                    name="row_5">
                                                <label class="form-check-label" for="row_5"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_6"
                                                    name="row_6">
                                                <label class="form-check-label" for="row_6"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_6"
                                                    name="row_6">
                                                <label class="form-check-label" for="row_6"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_6"
                                                    name="row_6">
                                                <label class="form-check-label" for="row_6"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_6"
                                                    name="row_6">
                                                <label class="form-check-label" for="row_6"></label>
                                            </div>
                                        </td>
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
                                        <td class="text-center">
                                            <div class="form-check d-inline-block">
                                                <input class="form-check-input" type="checkbox" value="" id="row_6"
                                                    name="row_6">
                                                <label class="form-check-label" for="row_6"></label>
                                            </div>
                                        </td>
                                        <th class="text-center" scope="row">10</th>
                                        <td class="fs-sm">
                                            <p class="fw-semibold mb-1">
                                                <a href="be_pages_generic_profile.html">학사 공지</a>
                                            </p>
                                        </td>
                                        <td>
                                            <div>
                                                <p style=" text-align: center; margin:0 0 0 0"><i
                                                        class="far fa fa-file"></i></p>
                                            </div>
                                        </td>
                                        <td class="d-none d-sm-table-cell" style="text-align: center;">
                                            <em class="fs-sm text-muted">November 26, 2018</em>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="p-1 d-flex justify-content-center">
                                <button type="button" class="btn btn-outline-secondary m-1">등록</button>
                                <button type="button" class="btn btn-outline-secondary m-1 push" data-bs-toggle="modal" data-bs-target="#modal-block-popout">삭제</button>
                            </div>

                            <div class="modal fade" id="modal-block-popout" tabindex="-1" aria-labelledby="modal-block-popout" style="display: none;" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-popout" role="document">
                                  <div class="modal-content">
                                    <div class="block block-rounded block-transparent mb-0">
                                      <div class="block-header block-header-default">     
                                        <h3 class="block-title">해당 공지 삭제</h3>                                 
                                        <div class="block-options">
                                          <button type="button" class="btn-block-option" data-bs-dismiss="modal" aria-label="Close">
                                            <i style="color:black"class="fa fa-fw fa-times"></i>
                                          </button>
                                        </div>
                                      </div>
                                      <div class="block-content fs-sm">
                                        <p>해당 공지를 삭제하시겠습니까 ?</p>
                                      </div>
                                      <div class="block-content p-2 text-end bg-body">
                                        <button type="button" class="btn btn-sm btn-alt-secondary me-1" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-sm btn-primary" data-bs-dismiss="modal">delete</button>
                                      </div>
                                    </div>
                                  </div>
                                </div>
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
            </div>
</body>
<script src="${path}/assets/js/oneui.app.min.js"></script>
 <link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
</html>