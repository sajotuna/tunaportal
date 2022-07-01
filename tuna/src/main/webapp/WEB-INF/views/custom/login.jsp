<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">

<title>OneUI - Bootstrap 5 Admin Template &amp; UI Framework</title>

<meta name="description"
	content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
<meta name="author" content="pixelcave">
<meta name="robots" content="noindex, nofollow">

<!-- Open Graph Meta -->
<meta property="og:title"
	content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework">
<meta property="og:site_name" content="OneUI">
<meta property="og:description"
	content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
<meta property="og:type" content="website">
<meta property="og:url" content="">
<meta property="og:image" content="">

<c:set var = "path" value = "${pageContext.request.contextPath }/resources"/>
<!-- Icons -->
<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
<link rel="shortcut icon"
	href="${path}/assets/media/favicons/favicon.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="${path}/assets/media/favicons/favicon-192x192.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${path}/assets/media/favicons/apple-touch-icon-180x180.png">
<!-- END Icons -->

<!-- Stylesheets -->
<!-- Fonts and OneUI framework -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
<link rel="stylesheet" id="css-main"
	href="${pageContext.request.contextPath }/resources/assets/css/oneui.min.css">

<!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
<!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/amethyst.min.css"> -->
<!-- END Stylesheets -->
</head>
<body>
	<!-- Page Container -->
	<!--
        Available classes for #page-container:

    GENERIC

      'remember-theme'                            Remembers active color theme and dark mode between pages using localStorage when set through
                                                  - Theme helper buttons [data-toggle="theme"],
                                                  - Layout helper buttons [data-toggle="layout" data-action="dark_mode_[on/off/toggle]"]
                                                  - ..and/or One.layout('dark_mode_[on/off/toggle]')

    SIDEBAR & SIDE OVERLAY

      'sidebar-r'                                 Right Sidebar and left Side Overlay (default is left Sidebar and right Side Overlay)
      'sidebar-mini'                              Mini hoverable Sidebar (screen width > 991px)
      'sidebar-o'                                 Visible Sidebar by default (screen width > 991px)
      'sidebar-o-xs'                              Visible Sidebar by default (screen width < 992px)
      'sidebar-dark'                              Dark themed sidebar

      'side-overlay-hover'                        Hoverable Side Overlay (screen width > 991px)
      'side-overlay-o'                            Visible Side Overlay by default

      'enable-page-overlay'                       Enables a visible clickable Page Overlay (closes Side Overlay on click) when Side Overlay opens

      'side-scroll'                               Enables custom scrolling on Sidebar and Side Overlay instead of native scrolling (screen width > 991px)

    HEADER

      ''                                          Static Header if no class is added
      'page-header-fixed'                         Fixed Header

    HEADER STYLE

      ''                                          Light themed Header
      'page-header-dark'                          Dark themed Header

    MAIN CONTENT LAYOUT

      ''                                          Full width Main Content if no class is added
      'main-content-boxed'                        Full width Main Content with a specific maximum width (screen width > 1200px)
      'main-content-narrow'                       Full width Main Content with a percentage width (screen width > 1200px)

    DARK MODE

      'sidebar-dark page-header-dark dark-mode'   Enable dark mode (light sidebar/header is not supported with dark mode)
    -->
	<div id="page-container">

		<!-- Main Container -->
		<section id="main-container">
			<!-- Page Content -->
			<div class="bg-image"
				style="background-image: url('${path}/assets/media/photos/photo28@2x.jpg');">
				<div class="row g-0 bg-primary-dark-op">
					<!-- Meta Info Section -->
					<div
						class="hero-static col-lg-4 d-none d-lg-flex flex-column justify-content-center">
						<div class="p-4 p-xl-5 flex-grow-1 d-flex align-items-center">
							<div class="w-100">
								<a class="link-fx fw-semibold fs-2 text-white"
									href="${pageContext.request.contextPath }/home"> TUNA </a>
								<p class="text-white-75 me-xl-8 mt-2">Welcome to your
									portal.</p>
							</div>
						</div>
						<div
							class="p-4 p-xl-5 d-xl-flex justify-content-between align-items-center fs-sm">
							<p class="fw-medium text-white-50 mb-0">
								<strong>TUNA 0.1</strong> &copy; <span data-toggle="year-copy"></span>
							</p>
						</div>
					</div>
					<!-- END Meta Info Section -->

					<!-- Main Section -->
					<div
						class="hero-static col-lg-8 d-flex flex-column align-items-center bg-body-light">
						<div class="p-3 w-100 d-lg-none text-center">
							<a class="link-fx fw-semibold fs-3 text-dark" href="index.html">
								One<span class="fw-normal">UI</span>
							</a>
						</div>
						<div class="p-4 w-100 flex-grow-1 d-flex align-items-center">
							<div class="w-100">
								<!-- Header -->
								<div class="text-center mb-5">
									<h1 class="fw-bold mb-2">TUNA Portal</h1>
								</div>
								<!-- END Header -->

								<!-- Sign In Form -->
								<!-- jQuery Validation (.js-validation-signin class is initialized in js/pages/op_auth_signin.min.js which was auto compiled from _js/pages/op_auth_signin.js) -->
								<!-- For more info and examples you can check out https://github.com/jzaefferer/jquery-validation -->
								<div class="row g-0 justify-content-center">
									<div class="col-sm-8 col-xl-6">
										<form class="js-validation-signin"
											action="${pageContext.request.contextPath }/processLogin"
											method="POST">
											<sec:csrfInput />
											<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
											<div class="mb-4">
												<input type="text"
													class="form-control form-control-lg form-control-alt py-3"
													id="username" name="username" placeholder="Username">
											</div>
											<div class="mb-4">
												<input type="password"
													class="form-control form-control-lg form-control-alt py-3"
													id="password" name="password" placeholder="Password">
											</div>

											<div class="row push">
												<div class="col-lg-8"></div>
												<div class="col-mb-6">
													<div class="row items-push">
														<div class="col-md-6">
															<div class="form-check form-block">
																<input class="form-check-input" type="radio" value="1"
																	id="example-checkbox-block1"
																	name="example-checkbox-block1" checked=""> <label
																	class="form-check-label" for="example-checkbox-block1">
																	<span class="d-flex align-items-center"> <img
																		class="img-avatar img-avatar48"
																		src="${path}/assets/media/avatars/avatar1.jpg"
																		alt=""> <span class="ms-2"> <span
																			class="fw-medium text-muted">학생</span> <span
																			class="d-block fs-sm text-muted">로그인</span>
																	</span>
																</span>
																</label>
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-check form-block">
																<input class="form-check-input" type="radio" value="1"
																	id="example-checkbox-block2"
																	name="example-checkbox-block1"> <label
																	class="form-check-label" for="example-checkbox-block2">
																	<span class="d-flex align-items-center"> <img
																		class="img-avatar img-avatar48"
																		src="${path}/assets/media/avatars/avatar12.jpg"
																		alt=""> <span class="ms-2"> <span
																			class="fw-medium text-muted">교직원</span> <span
																			class="d-block fs-sm text-muted">로그인</span>
																	</span>
																</span>
																</label>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div
												class="d-flex justify-content-between align-items-center mb-4">
												<div>
													<a
														class="text-muted fs-sm fw-medium d-block d-lg-inline-block mb-1"
														href="pwdfind"> Forgot Password? </a>
												</div>
											</div>

											<div>
												<button type="submit" class="btn btn-lg btn-alt-primary">
													<i class="fa fa-fw fa-sign-in-alt me-1 opacity-50"></i>
													Sign In
												</button>
											</div>
										</form>
									</div>

								</div>
							</div>
						</div>

						<!-- END Sign In Form -->
					</div>
				</div>
				<div
					class="px-4 py-3 w-100 d-lg-none d-flex flex-column flex-sm-row justify-content-between fs-sm text-center text-sm-start">
					<p class="fw-medium text-black-50 py-2 mb-0">
						<strong>OneUI 5.2</strong> &copy; <span data-toggle="year-copy"></span>
					</p>
					<ul class="list list-inline py-2 mb-0">
						<li class="list-inline-item"><a class="text-muted fw-medium"
							href="javascript:void(0)">Legal</a></li>
						<li class="list-inline-item"><a class="text-muted fw-medium"
							href="javascript:void(0)">Contact</a></li>
						<li class="list-inline-item"><a class="text-muted fw-medium"
							href="javascript:void(0)">Terms</a></li>
					</ul>
				</div>
			</div>
		</section>
		<!-- END Main Section -->
	</div>


	<!--
        OneUI JS

        Core libraries and functionality
        webpack is putting everything together at assets/_js/main/app.js
    -->
	<script
		src="${path}/assets/js/oneui.app.min.js"></script>

	<!-- jQuery (required for jQuery Validation plugin) -->
	<script
		src="${path}/assets/js/lib/jquery.min.js"></script>

	<!-- Page JS Plugins -->
	<script
		src="${path}/assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>

	<!-- Page JS Code -->
	<script
		src="${path}/assets/js/pages/op_auth_signin.min.js"></script>
</body>
</html>

