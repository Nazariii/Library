<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bookcopies List</title>
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
					<li class="active"><a href="<c:url value='/books/booklist'/>">Books</a></li>
					<li><a href="/authors/list">Authors</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Readers<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/readers/list_readers">List of Readers</a></li>
							<li><a href="/readers/list_readers_books">List Readers and Books</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/readers/new_reader">Add new Reader</a></li>
						</ul>
					</li>
					<li class="dropdown active">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Addresses<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/addresses/list_addresses">List of Addresses</a></li>
							<li><a href="/addresses/list_readers_addresses">List Readers and Addresses</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/addresses/new_address">Add new Address</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">List of BookCopies </span>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookcopies}" var="bookcopy">
                <tr>
                    <td>${bookcopy.isPresent}</td>
                    <td>${bookcopy.borrowingDate}</td>
                    <td>${bookcopy.book.name}</td>
                </tr>
            </c:forEach>
            <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.year}</td>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>
</div>
</body>
</html>