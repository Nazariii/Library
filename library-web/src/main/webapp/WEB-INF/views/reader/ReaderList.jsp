<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 8/26/2015
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Readers List</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
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
					<li><a href="<c:url value='/books/booklist'/>">Books</a></li>
					<li><a href="/authors/list">Authors</a></li>
					<li class="dropdown active"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Readers<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/readers/list_readers">List of Readers</a></li>
							<li><a href="/readers/list_readers_books">List Readers and Books</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/readers/new_reader">Add new Reader</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Addresses<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/addresses/list_addresses">List of Addresses</a></li>
							<li><a href="/addresses/list_readers_addresses">List Readers and Addresses</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/addresses/new_address">Add new Address</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="generic-container">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">List of Readers </span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>First name</th>
							<th>Last name</th>
							<th>Middle name</th>
							<th>Telephone</th>
							<th>Birth Date</th>
							<th width="100"></th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${readers}" var="reader">
							<tr>
								<td>${reader.firstName}</td>
								<td>${reader.lastName}</td>
								<td>${reader.middleName}</td>
								<td>${reader.telephone}</td>
								<td>${reader.birthDate}</td>
								<td><a
									href="/readers/edit-reader-${reader.readerId}"
									class="btn btn-success

custom-width">edit</a></td>
								<td><a
									href="/readers/delete-reader-${reader.readerId}"
									class="btn btn-danger

custom-width">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="well">
				<a href="<c:url value='/readers/new_reader'/>" class="btn btn-info ">Add
					New Reader</a>
			</div>
		</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript'
		src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script type='text/javascript'
		src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>
