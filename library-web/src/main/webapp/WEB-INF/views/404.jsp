
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>404</title>

    <!-- Bootstrap core CSS -->
	<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/bootstrap-theme.min.css'/>" rel="stylesheet"></link>

    <!-- Custom styles for this template -->
     <link href="<c:url value='/static/css/starter-template.css'/>" rel="stylesheet"></link>

  </head>
<body>
	<div class="container http-error-container">
		<h1>HTTP Status 404 - Page Not Found</h1>
		<p class="message-text">
			The page you requested is not available. You might try returning to
			the <a href="/">home page</a>.
		</p>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript'
		src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script type='text/javascript'
		src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
	</html>
