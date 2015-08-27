<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Author Form</title>
<link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/'/>">Library</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/books/'/>">Books</a></li>
					<li class="active"><a href="/authors/list">Authors</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Readers<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/readers/list_readers">List of Readers</a></li>
							<li><a href="#">List Readers and Books</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Add new Reader</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Addresses<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">List of Addresses</a></li>
							<li><a href="#">List Readers and Addresses</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Add new Address</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="generic-container">
			<div class="well lead">Add Author Form</div>
			<form:form method="POST" modelAttribute="author"
				class="form-horizontal">
				<form:input type="hidden" path="authorId" id="authorId" />

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="firstName">First
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="firstName" id="firstName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="firstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="lastName">Last
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="lastName" id="lastName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="lastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update"
									class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/list' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Add" class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/list' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>