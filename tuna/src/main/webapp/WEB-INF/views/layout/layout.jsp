<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <title>OneUI - Bootstrap 5 Admin Template &amp; UI Framework</title>

    <meta name="description" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
    <meta name="author" content="pixelcave">
    <meta name="robots" content="noindex, nofollow">

    <!-- Open Graph Meta -->
    <meta property="og:title" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework">
    <meta property="og:site_name" content="OneUI">
    <meta property="og:description" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
    <meta property="og:type" content="website">
    <meta property="og:url" content="">
    <meta property="og:image" content="">

    <!-- Icons -->
    <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/resources/assets/media/favicons/favicon.png">
    <link rel="icon" type="image/png" sizes="192x192" href="${pageContext.request.contextPath }/resources/assets/media/favicons/favicon-192x192.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath }/resources/assets/media/favicons/apple-touch-icon-180x180.png">
    <!-- END Icons -->

    <!-- Stylesheets -->
    <!-- Fonts and OneUI framework -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&amp;display=swap">
    <link rel="stylesheet" id="css-main" href="${pageContext.request.contextPath }/resources/assets/css/oneui.min.css">

    <!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
    <!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/amethyst.min.css"> -->
    <!-- END Stylesheets -->
  </head>
<body>
	<div id="page-container" class="sidebar-o sidebar-dark enable-page-overlay side-scroll page-header-fixed main-content-narrow side-trans-enabled"><div id="page-overlay"></div>
     	<div id="page-overlay"></div>
     	<div id = "header">
     	<tiles:insertAttribute name = "header"/><hr>
     	</div>
     	<div id = "aside">
		<tiles:insertAttribute name = "aside"/><hr>
		</div>
		<div id = "footer">
		<tiles:insertAttribute name = "footer"/><hr>
		</div>
    </div>
    <script src="${pageContext.request.contextPath }/resources/assets/js/oneui.app.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/js/plugins/chart.js/chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/js/pages/be_pages_dashboard.min.js"></script>
	

</body>
</html>