<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
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
				<a class="navbar-brand" href="#">Library</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value='/'/>">Books</a></li>
					<li><a href="/authors/list">Authors</a></li>
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
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">List of Books </span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Year</th>
							<th width="100"></th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${books}" var="book">
							<tr>
								<td>${book.name}</td>
								<td>${book.author.firstName} ${book.author.lastName}</td>
								<td>${book.year}</td>
								<td><a href="<c:url value='/edit-book-${book.isbn}' />"
									class="btn btn-success 
 
custom-width">edit</a></td>
								<td><a href="<c:url value='/delete-book-${book.isbn}' />"
									class="btn btn-danger 
 
custom-width">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="well">
			<a href="<c:url value='/books/addbook'/>" class="btn btn-info ">Add
				new book</a>
		</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>