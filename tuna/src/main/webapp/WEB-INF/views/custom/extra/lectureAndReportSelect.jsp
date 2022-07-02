<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lectureAndReportSelect</title>
<style>
    .space-x-2 {
      padding: 7px 15px;
    }

    .btn-full {
      width: 100%;
    }

    #section {
      margin-top: 20px;
    }

    p {
      display: inline;
    }
    .chart-margin {
      margin: 2rem 0 6rem 0;
    }

  </style>
</head>
<body>
	<!-- Title -->
      <div class="bg-primary-darker">
        <div class="content content-full content-boxed">
          <div
            class="d-flex flex-column flex-md-row justify-content-md-between align-items-md-center py-2 text-center text-md-start">
            <div class="flex-grow-1 mb-1 mb-md-0">
              <h2 class="h2 fw-bold mb-2 text-gray-light">
                강의 / 성적 조회
              </h2>
              <h2 class="h6 fw-medium fw-medium text-muted mb-0 text-gray-dark">
                강의 계획서, 수강 내역 및 성적 조회 페이지입니다.
              </h2>
            </div>

          </div>
        </div>
      </div>
      <!-- END Title -->

      <!-- Tab Block -->
      <div id="section">
        <div class="content content-boxed">
          <div class="block block-rounded">

            <!-- Tab -->
            <ul class="nav nav-tabs nav-tabs-block" role="tablist">
              <li class="nav-item">
                <button class="nav-link active" id="btabs-static-subject-tab" data-bs-toggle="tab"
                  data-bs-target="#btabs-static-subject" role="tab" aria-controls="btabs-static-subject"
                  aria-selected="true">강의 계획서 조회</button>
              </li>
              <li class="nav-item">
                <button class="nav-link" id="btabs-static-mysubject-tab" data-bs-toggle="tab"
                  data-bs-target="#btabs-static-mysubject" role="tab" aria-controls="btabs-static-mysubject"
                  aria-selected="false">수강 내역 조회</button>
              </li>
              <li class="nav-item">
                <button class="nav-link" id="btabs-static-grade-tab" data-bs-toggle="tab"
                  data-bs-target="#btabs-static-grade" role="tab" aria-controls="btabs-static-grade"
                  aria-selected="false">보관 성적 조회</button>
              </li>
            </ul>
            <!-- END Tab -->

            <!-- Block Content -->
            <div class="block-content tab-content">
              <!-- SUBJECT Tab -->
              <div class="tab-pane active" id="btabs-static-subject" role="tabpanel"
                aria-labelledby="btabs-static-subject-tab">
                <!-- Input -->
                <div class="row">
                  <div class="col-md-6 col-xl-2">
                    <div class="mb-2">
                      <select class="form-select" id="example-select" name="example-select">
                        <option selected>연도</option>
                        <option value="1">2022</option>
                        <option value="2">2021</option>
                        <option value="3">2020</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-2">
                    <div class="mb-2">
                      <select class="form-select" id="example-select" name="example-select">
                        <option selected>학기</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-4">
                    <div class="block block-rounded bg-primary-darker mb-2">
                      <div class="space-x-2 text-center text-gray-light">
                        <div class="form-check form-check-inline">
                          검색 대상
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" id="example-radios-inline1"
                            name="example-radios-inline" value="option1" checked>
                          <label class="form-check-label" for="example-radios-inline1">과목명</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" id="example-radios-inline2"
                            name="example-radios-inline" value="option2">
                          <label class="form-check-label" for="example-radios-inline2">교수명</label>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-3">
                    <div class="mb-3">
                      <input type="text" class="form-control" id="example-text-input" name="example-text-input"
                        placeholder="검색어">
                    </div>
                  </div>
                  <div class="col-md-12 col-xl-1">
                    <div class="mb-3">
                      <button type="button" class="btn btn-primary btn-full">조회</button>
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
                      </tr>
                    </thead>
                    <tbody>
                      <tr scope="row">
                        <th class="fw-semibold fs-sm">49171-01</th>
                        <td class="fw-semibold fs-sm"><a href="#">비주얼인포메이션디자인(2)</a></td>
                        <td class="fw-semibold fs-sm">예술대학
                          디자인학부</td>
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
              <div class="tab-pane" id="btabs-static-mysubject" role="tabpanel"
                aria-labelledby="btabs-static-mysubject-tab">
                <!-- Input -->
                <div class="row">
                  <div class="col-md-6 col-xl-4">
                    <div class="mb-2">
                      <select class="form-select" id="example-select" name="example-select">
                        <option selected>연도</option>
                        <option value="1">2022</option>
                        <option value="2">2021</option>
                        <option value="3">2020</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-4">
                    <div class="mb-2">
                      <select class="form-select" id="example-select" name="example-select">
                        <option selected>학기</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-2">
                    <div class="block block-rounded bg-primary-darker mb-2">
                      <div class="space-x-2 text-center text-gray-light">
                        신청 과목수 0
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xl-2">
                    <div class="block block-rounded bg-primary-darker mb-3">
                      <div class="space-x-2 text-center text-gray-light">
                        신청 학점 0
                      </div>
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
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">49171-01</th>
                        <td class="fw-semibold fs-sm">비주얼인포메이션디자인(2)</td>
                        <td class="fw-semibold fs-sm">예술대학
                          디자인학부</td>
                        <td class="fw-semibold fs-sm">전공</td>
                        <td class="fw-semibold fs-sm">이설민</td>
                        <td class="fw-semibold fs-sm">808관(조형관) 423호 시각디자인실 / 화5,6,7,8</td>
                        <td class="fw-semibold fs-sm">O</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!-- END Table -->
              </div>
              <!-- END MYSUBJECT Tab -->

              <!-- GRADE Tab -->
              <div class="tab-pane" id="btabs-static-grade" role="tabpanel" aria-labelledby="btabs-static-grade-tab">

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
                      <div class="js-pie-chart pie-chart" data-percent="85" data-line-width="20" data-size="180"
                        data-bar-color="#abe37d" data-track-color="#eeeeee">
                      <!-- <div class="text-center mb-4">총 취득 학점</div> -->
                      <span>
                        <p class="h2">112</p><br><small class="text-muted">/137</small>
                      </span>
                      </div>
                    </div>
                    <div class="col-3">
                      <div class="js-pie-chart pie-chart" data-percent="87" data-line-width="20" data-size="180"
                        data-bar-color="#fadb7d" data-track-color="#eeeeee">
                      <!-- <div class="text-center mb-4">총 평점 평균</div> -->
                      <span>
                        <p class="h2">3.76</p><br><small class="text-muted">/4.5</small>
                      </span>
                      </div>
                    </div>
                    <div class="col-3">
                      <div class="js-pie-chart pie-chart" data-percent="91.54" data-line-width="20" data-size="180"
                        data-bar-color="#faad7d" data-track-color="#eeeeee">
                      <!-- <div class="text-center mb-4">백분율 성적</div> -->
                      <span>
                        <p class="h2">91.54</p><br><small class="text-muted">/100</small>
                      </span>
                    </div>
                  </div>
                </div>
                <!-- END Ring Chart -->

                  <!-- subject grade list -->
                  <div class="block block-rounded block-themed mb-4">
                    <div class="block-header bg-primary-dark">
                      <h4 class="block-title">과목별 성적 내역</h4>
                      <button type="button" class="btn btn-sm btn-light">PDF</button>
                    </div>
                    <!-- Table -->
                    <div class="mb-4">
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
                          <tr scope="row">
                            <td class="fw-semibold fs-sm">2014</th>
                            <td class="fw-semibold fs-sm">1</th>
                            <td class="fw-semibold fs-sm">전공필수</th>
                            <td class="fw-semibold fs-sm">40753-01</th>
                            <td class="fw-semibold fs-sm">타이포그래피(1)</th>
                            <td class="fw-semibold fs-sm">2</th>
                            <td class="fw-semibold fs-sm">A+</th>
                            <td class="fw-semibold fs-sm">4.5</th>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                    <!-- END Table -->
                  </div>
                </div>
                <!-- END subject grade list -->

                <div class="row">
                  <!-- grade avg -->
                  <div class="col-7">
                    <div class="block block-rounded block-themed mb-4">
                      <div class="block-header bg-primary-dark">
                        <h4 class="block-title">평균 평점</h4>
                      </div>
                      <!-- Table -->
                      <div class="mb-4">
                        <table class="table table-striped table-vcenter">
                          <thead>
                            <tr>
                              <th class="d-none d-sm-table-cell" style="width: 100px;">년도</th>
                              <th class="d-none d-sm-table-cell" style="width: 100px;">학기</th>
                              <th class="d-none d-sm-table-cell" style="width: 100px;">취득학점</th>
                              <th class="d-none d-sm-table-cell" style="width: 150px;">평점평균</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr scope="row">
                              <td class="fw-semibold fs-sm">2014</th>
                              <td class="fw-semibold fs-sm">1</th>
                              <td class="fw-semibold fs-sm">18</th>
                              <td class="fw-semibold fs-sm">3.38</th>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <!-- END Table -->
                    </div>
                  </div>
                  <!-- END grade avg -->

                  <!-- total grade -->
                  <div class="col-5">
                    <div class="block block-rounded block-themed mb-4">
                      <div class="block-header bg-primary-dark">
                        <h4 class="block-title">이수구분별 취득 학점</h4>
                      </div>
                      <!-- Table -->
                      <div class="mb-4">
                        <table class="table table-striped table-vcenter">
                          <tr scope="row">
                            <th class="d-none d-sm-table-cell" style="width: 50%;">전공기초</th>
                            <td class="fw-semibold fs-sm">0</th>
                          </tr>
                          <tr scope="row">
                            <th class="d-none d-sm-table-cell" style="width: 50%;">전공필수</th>
                            <td class="fw-semibold fs-sm">0</th>
                          </tr>
                          <tr scope="row">
                            <th class="d-none d-sm-table-cell" style="width: 50%;">일반교양</th>
                            <td class="fw-semibold fs-sm">0</th>
                          </tr>
                          <tr scope="row">
                            <th class="d-none d-sm-table-cell" style="width: 50%;">필수교양</th>
                            <td class="fw-semibold fs-sm">0</th>
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
            <!-- END Block Content -->

          </div>
        </div>
      </div>
      <!-- END Tab Block -->
      
      <!-- Script -->
	  <script src="assets/js/oneui.app.min.js"></script>
	  <!-- jQuery (required for Easy Pie Chart + Sparklines plugin) -->
	  <script src="assets/js/lib/jquery.min.js"></script>
	  <!-- Page JS Plugins -->
	  <script src="assets/js/plugins/easy-pie-chart/jquery.easypiechart.min.js"></script>
	  <script src="assets/js/plugins/jquery-sparkline/jquery.sparkline.min.js"></script>
	  <script src="assets/js/plugins/chart.js/chart.min.js"></script>
	  <!-- Page JS Code -->
	  <script src="assets/js/pages/be_comp_charts.min.js"></script>
	  <script src="assets/js/pages/be_pages_dashboard.min.js"></script>
	  <!-- Page JS Helpers (Easy Pie Chart + jQuery Sparkline Plugins) -->
	  <script>
	    One.helpersOnLoad(['jq-easy-pie-chart', 'jq-sparkline']);
	  </script>
	  <!-- END Script -->
</body>
</html>