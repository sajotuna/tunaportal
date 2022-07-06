<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>강의평가</title>

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

  <!-- Stylesheets -->
  <!-- Fonts and OneUI framework -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
  <link rel="stylesheet" id="css-main" href="assets/css/oneui.min.css">

  <!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
  <!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/amethyst.min.css"> -->
  <!-- END Stylesheets -->
  <style>
    thead {
      text-align: center;
    }

    .form-check {
      text-align: center;
    }
  </style>
</head>

<body>
  <div class="bg-body-light">
    <div class="content content-full content-boxed">
      <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
        <div class="flex-grow-1">
          <h1 class="h1 fw-bold mb-2">
            강의평가
          </h1>
        </div>
      </div>
    </div>
  </div>
  <div id="section">
    <div id="page-container">
      <div class="content content-boxed">
        <div class="bg-body-extra-light">
          <div class="row">
            <div class="col-lg-12 col-xl-6">
              <form action="" method="post">
                <table class="table table-striped table-vcenter">
                  <thead>
                    <tr>
                      <th class="d-none d-sm-table-cell" style="width: 300px;">문항</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">매우 그렇다</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">그런 편이다</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">보통이다</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">그렇지 않다</th>
                      <th class="d-none d-sm-table-cell" style="width: 120px;">전혀<br>그렇지 않다</th>
                    </tr>
                  </thead>
                  <tbody>

                    <tr scope="row">
                      <td class="fw-semibold fs-sm">강의계획서는 수업에 관한 정보(교과목표, 주별 강의계획, 교수학습방법, 성적평가방법 등)를 명확하게 제시하고 있습니까?
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="5" id="evaluation1" name="evaluation1"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">5</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="4" id="evaluation1" name="evaluation1"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">4</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="3" id="evaluation1" name="evaluation1"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">3</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="2" id="evaluation1" name="evaluation1"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">2</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="1" id="evaluation1" name="evaluation1"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">1</label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="fw-semibold fs-sm">교수님은 매주 수업 시 학습목표(수행준거)를 명확하게 제시 하였습니까?</td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="5" id="evaluation2" name="evaluation2"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">5</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="4" id="evaluation2" name="evaluation2"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">4</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="3" id="evaluation2" name="evaluation2"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">3</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="2" id="evaluation2" name="evaluation2"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">2</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="1" id="evaluation2" name="evaluation2"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">1</label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="fw-semibold fs-sm">교수님은 규정된 수업시간(결강, 휴보강 관련)을 준수하였습니까?</td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="5" id="evaluation3" name="evaluation3"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">5</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="4" id="evaluation3" name="evaluation3"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">4</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="3" id="evaluation3" name="evaluation3"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">3</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="2" id="evaluation3" name="evaluation3"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">2</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="1" id="evaluation3" name="evaluation3"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">1</label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="fw-semibold fs-sm">교수님은 수업에 대한 출석을 철저히 관리하였습니까?</td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="5" id="evaluation4" name="evaluation4"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">5</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="4" id="evaluation4" name="evaluation4"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">4</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="3" id="evaluation4" name="evaluation4"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">3</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="2" id="evaluation4" name="evaluation4"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">2</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="1" id="evaluation4" name="evaluation4"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">1</label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="fw-semibold fs-sm">수업에 사용된 학습매체(교재, 유인물, 사진, 동영상 등)가 수업의 이해도를 높이는데 도움이 되었습니까?</td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="5" id="evaluation5" name="evaluation5"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">5</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="4" id="evaluation5" name="evaluation5"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">4</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="3" id="evaluation5" name="evaluation5"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">3</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="2" id="evaluation5" name="evaluation5"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">2</label>
                        </div>
                      </td>
                      <td class="fw-semibold fs-sm">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" value="1" id="evaluation5" name="evaluation5"
                            checked="">
                          <label class="form-check-label" for="example-checkbox-default1">1</label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="fw-semibold fs-sm"></td>
                      <td class="fw-semibold fs-sm" colspan="6">
                        <div class="col-lg-12 col-xl-12">
                          <div class="mb-4">
                            <label class="form-label" for="example-textarea-input-alt">본 수업의 장점 및 단점을 자유롭게
                              서술하시오.</label>
                            <textarea class="form-control form-control-alt" id="example-textarea-input-alt"
                              name="example-textarea-input-alt" rows="7" placeholder="content..."></textarea>
                          </div>
                        </div>
                    </tr>

                  </tbody>
                </table>
                <div class="d-flex justify-content-end">
                  <div class="mb-3">
                    <a href="#" class="btn btn-info" onclick="javascript:window.close()">닫기</a>
                    <button class="btn btn-info">강의평가 완료</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
</body>

</html>