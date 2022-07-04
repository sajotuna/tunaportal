<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<c:set var = "path" value = "${pageContext.request.contextPath }/resources"/>
<html>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Home</title>
    <!-- Icons -->
        <link rel="shortcut icon" href="assets/media/favicons/favicon.png">
        <link rel="icon" type="image/png" sizes="192x192" href="assets/media/favicons/favicon-192x192.png">
        <link rel="apple-touch-icon" sizes="180x180" href="assets/media/favicons/apple-touch-icon-180x180.png">
    <!-- END Icons -->

    <!-- Stylesheets -->
        <!-- Fonts and OneUI framework -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
        <link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
        <link rel="stylesheet" id="css-theme" href="${path}/assets/css/themes/modern.min.css">
        <!-- Page JS Plugins CSS -->
        <link rel="stylesheet" href="${path}/assets/js/plugins/slick-carousel/slick.css">
        <link rel="stylesheet" href="${path}/assets/js/plugins/slick-carousel/slick-theme.css">
    <!-- END Stylesheets -->
    <style>
        .box {
            height: 300px;
            padding:0;
        }
        .short-box {
            height: 136px;
            padding:0;
        }

        .banner {
            overflow:hidden;
            padding:0;   
        }
        .banner-img {
            height:100%;
            width:auto;
        }
        #shortcut-banner {
            position:relative;
        }
        #shortcut-btn {
            position:absolute;
            left:2rem!important;
            top:2rem!important;
        }
        #slogan-banner {
            padding:30px;
        }
        .img-fluid {
            object-fit:cover;
            height:350px;
        }
        .box-btn {
            height: 100%;
            width: 100%;
        }
        .btn-outline-light {
            border:none;
        }
    </style>
</head>
<body>
	<%-- <sec:authorize access="isAuthenticated()">
		<form method = "post" action = "${pageContext.request.contextPath }/logout">
			<sec:csrfInput/>
			<button>로그아웃</button>
		</form>
		
		<a href = "${pageContext.request.contextPath }/mypage">마이페이지</a>
		
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href = "custom/login">로그인</a>
	</sec:authorize>
	
	<a href = "coursesreg">수강신청</a>
	
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
	</ul> --%>
<div id="page-container">
<!-- Main Container -->
<main id="main-container">
    <!-- Hero -->
    <div class="bg-body-light">
        <div class="content content-full content-boxed">
        <div class="d-flex flex-column flex-md-row justify-content-md-between align-items-md-center py-2 text-center text-md-start">
            <div class="flex-grow-1 mb-1 mb-md-0">
            <h1 class="h1 fw-bold mb-2">
                TUNA Portal
            </h1>
            <h2 class="h6 fw-medium fw-medium text-muted mb-0">
                <a class="fw-semibold" href="#">지수빈</a> 님, 환영합니다. 
            </h2>
            </div>
            <div class="mt-3 mt-md-0 ms-md-3 space-x-1">
            <a class="btn btn-sm btn-dark space-x-1" href="#">
                <i class="far fa-user opacity-50"></i>
                <span>로그인</span>
            </a>
            <div class="dropdown d-inline-block">
                <button type="button" class="btn btn-sm btn-dark space-x-1" id="dropdown-analytics-overview" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="far fa-user opacity-50"></i>
                <span>지수빈 님</span>
                <i class="fa fa-fw fa-angle-down"></i>
                </button>
                <div class="dropdown-menu dropdown-menu-md dropdown-menu-end p-0 border-0" aria-labelledby="page-header-user-dropdown">
                    <div class="p-3 text-center bg-body-light border-bottom rounded-top">
                      <p class="mt-2 mb-0 fw-medium">지수빈</p>
                      <p class="mb-0 text-muted fs-sm fw-medium">시각디자인학과</p>
                    </div>
                    <div class="p-2">
                      <a class="dropdown-item d-flex align-items-center justify-content-between" href="#">
                        <span class="fs-sm fw-medium">내 정보 수정</span>
                      </a>
                    </div>
                    <div role="separator" class="dropdown-divider m-0"></div>
                    <div class="p-2">
                      <a class="dropdown-item d-flex align-items-center justify-content-between" href="#">
                        <span class="fs-sm fw-medium">로그아웃</span>
                      </a>
                    </div>
                  </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    <!-- END Hero -->
    
    <!-- Main Navigation -->
    <div class="bg-primary-darker">
	<div id="main-navigation" class="d-md-none mt-2 mt-lg-0">
		<ul class="nav-main nav-main-dark nav-main-horizontal nav-main-hover">
			<li class="nav-main-item"><a
				class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
				aria-haspopup="true" aria-expanded="false" href="#"><span
					class="nav-main-link-name">학사정보</span>
			</a>
				<ul class="nav-main-submenu">
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">공지사항</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">학사일정</span>
					</a></li>
				</ul></li>
				
			<li class="nav-main-item"><a
				class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
				aria-haspopup="true" aria-expanded="false" href="#"><span
					class="nav-main-link-name">조회</span>
			</a>
				<ul class="nav-main-submenu">
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">강의/성적 조회</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">장학 신청 및 조회</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">등록금납입확인서</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">당해학기 성적 조회</span>
					</a></li>
				</ul></li>
				
			<li class="nav-main-item"><a
				class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
				aria-haspopup="true" aria-expanded="false" href="#"><span
					class="nav-main-link-name">강의</span>
			</a>
				<ul class="nav-main-submenu">
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">e-class</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">수강신청</span>
					</a></li>
					<li class="nav-main-item"><a class="nav-main-link"
						href="javascript:void(0)"> <span class="nav-main-link-name">강의평가</span>
					</a></li>
				</ul></li>

		</ul>
	</div>
	</div>
	<!-- END Main Navigation -->

    <div class="mt-3">
    <!-- Page Content -->
    <div class="content content-boxed">
        <!-- First Row -->
        <div class="row">
        	<!-- Slide Banner -->
            <div class="col-xl-5">
                <div class="block block-rounded">
                    <div class="block-content box banner">
                        <div class="js-slider slick-dotted-inner slick-dotted-white box" data-dots="true" data-autoplay="true" data-autoplay-speed="1800">
                            <div>
                              <img class="img-fluid" src="" alt="">
                            </div>
                            <div>
                              <img class="img-fluid" src="" alt="">
                            </div>
                            <div>
                              <img class="img-fluid" src="" alt="">
                            </div>
                            <div>
                              <img class="img-fluid" src="" alt="">
                            </div>
                          </div>
                    </div>
                </div>
            </div>
            <!-- END Slide Banner -->
            <div class="col-xl-3 col-md-6 d-none d-md-block">
                <div class="block block-rounded">
                    <div class="block-content box">
                        <button class="box-btn btn btn-dark fw-bold" href="#">수강신청</button>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-md-6 d-none d-md-block">
                <div class="row">
                    <div class="col-md-6">
                        <div class="block block-rounded">
                            <div class="block-content short-box">
                                <button class="box-btn btn btn-info fw-bold" href="#">등록금납입확인서</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="block block-rounded">
                            <div class="block-content short-box">
                                <button class="box-btn btn btn-outline-light 
                                    text-primary-darker fw-bold" href="#">장학 신청 및 조회</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="block block-rounded">
                    <div class="block-content short-box">
                        <button class="box-btn btn bg-modern-light text-gray-lighter fw-bold" href="#">강의 / 성적 조회</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- END First Row -->
        <!-- Second Row -->
        <div class="row">
            <div class="col-xl-4 col-md-6 d-none d-md-block">
                <div class="row">
                    <div class="col-md-6">
                        <div class="block block-rounded">
                            <div class="block-content short-box">
                                <button class="box-btn btn btn-alt-info fw-bold text-dark" href="#">학사공지</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="block block-rounded">
                            <div class="block-content short-box">
                                <button class="box-btn btn btn-primary fw-bold" href="#">학사일정</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="block block-rounded">
                    <div id="slogan-banner" class="block-content short-box banner bg-muted">
                        <h4 class="text-gray-lighter">TUNA, <br>세계의 중심에서 세상을 바꾸라.</h4>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-xl-3 col-md-6 d-none d-md-block">
                <div class="block block-rounded">
                    <div class="block-content box">
                        <button class="box-btn btn btn-outline-light 
                                    text-primary-darker fw-bold" href="#">e-Class</button>
                    </div>
                </div>
            </div>
            <!-- Shortcut Banner -->
            <div class="col-xl-5">
                <div class="block block-rounded">
                    <div id="shortcut-banner" class="block-content box banner">
                        <button id="shortcut-btn" class="btn btn-alt-secondary" href="#">바로가기</button>
						<img class="banner-img" src="" alt="">
					</div>
                </div>
            </div>
            <!-- END Shortcut Banner -->
        </div>
        <!-- END Second Row -->
    </div>
    <!-- END Grid -->
    </div>
    <!-- Footer -->
</main>
</div>
 <footer id="page-footer" class="bg-sidebar-dark">
 <div class="content content-boxed py-4">
     <div class="row fs-sm text-gray-dark">
     <div class="col-sm-6 order-sm-2 py-1 text-center text-sm-end">
         Crafted by <i class="fa fa-fish text-gray-light"></i><a class="fw-semibold text-gray-light" href="#"> sajotuna</a>
     </div>
     <div class="col-sm-6 order-sm-1 py-1 text-center text-sm-start text-gray-dark">
         대구광역시 중구 남일동 중앙대로 403 <br><a class="fw-semibold text-gray-light" href="#">&copy;<span data-toggle="year-copy"></span> TUNA Univ. </a>
     </div>
     </div>
 </div>
 </footer>
 <!-- END Footer -->
<!-- Script -->
    <script src="${path}/assets/js/oneui.app.min.js"></script>
    <!-- jQuery (required for Slick Slider plugin) -->
    <script src="${path}/assets/js/lib/jquery.min.js"></script>
    <!-- Page JS Plugins -->
    <script src="${path}/assets/js/plugins/slick-carousel/slick.min.js"></script>
    <!-- Page JS Helpers (Slick Slider Plugin) -->
    <script>One.helpersOnLoad(['jq-slick']);</script>
<!-- END Script -->
</body>
</html>
