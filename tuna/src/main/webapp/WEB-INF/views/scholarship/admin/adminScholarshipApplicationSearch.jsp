<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>장학신청조회</title>

  <meta name="description"
    content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
  <meta name="author" content="pixelcave">
  <meta name="robots" content="noindex, nofollow">

  <!-- Open Graph Meta -->
  <meta property="og:title" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework">
  <meta property="og:site_name" content="OneUI">
  <meta property="og:description"
    content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
  <meta property="og:type" content="website">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <!-- Icons -->
  <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
  <link rel="shortcut icon" href="assets/media/favicons/favicon.png">
  <link rel="icon" type="image/png" sizes="192x192" href="assets/media/favicons/favicon-192x192.png">
  <link rel="apple-touch-icon" sizes="180x180" href="assets/media/favicons/apple-touch-icon-180x180.png">
  <!-- END Icons -->
  <link rel="stylesheet" href="assets/js/plugins/flatpickr/flatpickr.min.css">
  <!-- Stylesheets -->
  <!-- Fonts and OneUI framework -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
  <link rel="stylesheet" id="css-main" href="assets/css/oneui.min.css">

  <!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
  <!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/amethyst.min.css"> -->
  <!-- END Stylesheets -->
  <style>

    h5 {
      margin-top: 50px;
      margin-left: 20px;
    }

    .fomrtag {
      margin-left: 50px;
      margin-top: 10px;
    }
  </style>

</head>

<body>
  <div id="section">
    <div class="content content-boxed">
      <div id="page-container">
        <h3 class="h3 fw-bold mb-2">장학신청 조회</h3>
        <div class=" bg-body-extra-light" style="padding: 10px;">
        <form action="" method="post" class="row">
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <select class="form-select" id="example-select" name="example-select">
                <option selected>연도/학기</option>
                <option value="1">1학기</option>
                <option value="2">2학기</option>
              </select>
            </div>
          </div>
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <select class="form-select" id="example-select" name="example-select">
                <option selected>신청구분</option>
                <option value="1">성적우수</option>
                <option value="2">가족</option>
                <option value="3">교직원가족</option>
              </select>
            </div>
          </div>
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <input type="text" class="js-flatpickr form-control"
                id="example-flatpickr-range" name="example-flatpickr-range" placeholder="신청일자"
                data-mode="range" readonly="readonly">
                <input type="file" multiple="multiple" class="dz-hidden-input" tabindex="-1" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
            </div>
            
          </div>
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <select class="form-select" id="example-select" name="example-select">
                <option selected>학년</option>
                <option value="1">1학년</option>
                <option value="2">2학년</option>
                <option value="3">3학년</option>
                <option value="4">4학년</option>
              </select>
            </div>
          </div>
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <input type="number" placeholder="학번/교번" class="form-control" id="example-flatpickr-time-standalone-24"
                name="example-flatpickr-time-standalone-24">
            </div>
          </div>
          <div class="col-md-4 col-xl-3 fomrtag">
            <div class="mb-2">
              <select class="form-select" id="example-select" name="example-select">
                <option selected>심사현황</option>
                <option value="1">심사대기</option>
                <option value="2">심사중</option>
                <option value="3">심사보류</option>
                <option value="4">심사완료</option>
                <option value="4">지급완료</option>
              </select>
            </div>
          </div>
          <div class="col-md-2 col-xl-1 fomrtag">
            <div>
              <button type="submit" class="btn btn-secondary col-sm-12">조회</button>
            </div>
          </div>

        </form>
        <div class="mb-4">
          <h5>[장학내역]</h5>

          <div class="d-flex justify-content-end">
            <div class="m-2">
              <button type="button" class="btn btn-secondary" id = "allSelect">전체선택</button>
            </div>
          </div>
          <form action="" method="post" >
          <table class="table table-striped table-vcenter">
                        <thead>
              <tr>
                <th class="d-none d-sm-table-cell" style="width: 50px;"></th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">학번</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">성명</th>
                <th class="d-none d-sm-table-cell" style="width: 50px;">학년</th>
                <th class="d-none d-sm-table-cell" style="width: 80px;">재학</th>
                <th class="d-none d-sm-table-cell" style="width: 80px;">졸업예정</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">취득학점</th>
                <th class="d-none d-sm-table-cell" style="width: 50px;">평점</th>
                <th class="d-none d-sm-table-cell" style="width: 50px;">석차</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">신청구분</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">접수번호</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">심사현황</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">첨부파일</th>
                <th class="d-none d-sm-table-cell" style="width: 100px;">비고</th>
              </tr>
            </thead>
            <tbody>
              <tr scope="row">
                <th class="fw-semibold fs-sm"><input type = "checkbox"></th>
                <td class="fw-semibold fs-sm">014-124357</td>
                <td class="fw-semibold fs-sm">최규완</td>
                <td class="fw-semibold fs-sm">3학년</td>
                <td class="fw-semibold fs-sm">재학</td>
                <td class="fw-semibold fs-sm">X</td>
                <th class="fw-semibold fs-sm">17</th>
                <td class="fw-semibold fs-sm">4.5</td>
                <td class="fw-semibold fs-sm">1/45</td>
                <td class="fw-semibold fs-sm">성적우수</td>
                <td class="fw-semibold fs-sm">141-123141</td>
                <td class="fw-semibold fs-sm">심사대기</td>
                <td class="fw-semibold fs-sm"></td>
                <td class="fw-semibold fs-sm"></td>
              </tr>
              <tr scope="row">
                <th class="fw-semibold fs-sm"><input type = "checkbox"></th>
                <td class="fw-semibold fs-sm">014-124357</td>
                <td class="fw-semibold fs-sm">최규완</td>
                <td class="fw-semibold fs-sm">3학년</td>
                <td class="fw-semibold fs-sm">재학</td>
                <td class="fw-semibold fs-sm">X</td>
                <th class="fw-semibold fs-sm">17</th>
                <td class="fw-semibold fs-sm">4.5</td>
                <td class="fw-semibold fs-sm">1/45</td>
                <td class="fw-semibold fs-sm">성적우수</td>
                <td class="fw-semibold fs-sm">141-123141</td>
                <td class="fw-semibold fs-sm">심사대기</td>
                <td class="fw-semibold fs-sm"></td>
                <td class="fw-semibold fs-sm"></td>
              </tr>
            </tbody>
          
          </table>
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="javascript:void(0)" tabindex="-1" aria-label="Previous">
                <span aria-hidden="true">
                  <i class="fa fa-angle-double-left"></i>
                </span>
                <span class="visually-hidden">Previous</span>
              </a>
            </li>
            <li class="page-item active">
              <a class="page-link" href="javascript:void(0)">1</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="javascript:void(0)">2</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="javascript:void(0)">3</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="javascript:void(0)">4</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="javascript:void(0)" aria-label="Next">
                <span aria-hidden="true">
                  <i class="fa fa-angle-double-right"></i>
                </span>
                <span class="visually-hidden">Next</span>
              </a>
            </li>
          </ul>
          <div class="d-flex justify-content-center">
            <div class="m-2">
              <input type="submit" class="btn btn-secondary" value="심사확인">
            </div>
            <div class="m-2">
              <a href="#" class="btn btn-secondary">심사거절</a>
            </div>      
        </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
  <script src="assets/js/lib/jquery.min.js"></script>

  <!-- Page JS Plugins -->
  <script src="assets/js/plugins/flatpickr/flatpickr.min.js"></script>

  <!-- Page JS Helpers (Flatpickr + BS Datepicker + BS Maxlength + Select2 + Masked Inputs + Ion Range Slider + BS Colorpicker plugins) -->
  <script>One.helpersOnLoad(['js-flatpickr']);</script>
  


  <script>

      let btnCheckCnt = 0;

      document.querySelector("#allSelect").addEventListener('click', function(){
      document.querySelectorAll("[type = 'checkbox']").forEach(function(checkbox,idx){
        if(btnCheckCnt % 2 == 0){
          checkbox.checked= true
        }else{
          checkbox.checked = false
        }
        
      })
      btnCheckCnt++;
    })
    

    
    

  </script>
</body>

</html>