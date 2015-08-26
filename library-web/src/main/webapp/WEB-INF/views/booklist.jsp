<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
							<td><a
								href="<c:url value='/edit-book-${book.isbn}' />"
								class="btn btn-success 
 
custom-width">edit</a></td>
							<td><a
								href="<c:url value='/delete-book-${book.isbn}' />"
								class="btn btn-danger 
 
custom-width">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/newbook' />">Add new book</a>
		</div>
	</div>
</body>
</html>