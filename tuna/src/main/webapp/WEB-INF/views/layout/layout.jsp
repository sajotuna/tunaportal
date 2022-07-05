<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <!-- Icons -->
    <link rel="shortcut icon" href="${path}/assets/media/favicons/favicon.png">
    <link rel="icon" type="image/png" sizes="192x192" href="${path}/assets/media/favicons/favicon-192x192.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${path}/assets/media/favicons/apple-touch-icon-180x180.png">
    <!-- END Icons -->

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&amp;display=swap">
    <link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
    <link rel="stylesheet" id="css-theme" href="${path}/assets/css/themes/modern.min.css">
  </head>
  
<body>
	<div id="page-container" class="sidebar-o sidebar-dark enable-page-overlay side-scroll page-header-fixed main-content-narrow side-trans-enabled">
     	<div id="aside">
		<tiles:insertAttribute name="aside"/>
		</div>
     	<div id="header">
     	<tiles:insertAttribute name="header"/>
     	</div>
		<!-- Main Container -->
 		<main id="main-container">
 			<div id="body">
			<tiles:insertAttribute name="body"/>
			</div>
 		</main>
    </div>
    <script src="${path}/assets/js/oneui.app.min.js"></script>
</body>
</html>