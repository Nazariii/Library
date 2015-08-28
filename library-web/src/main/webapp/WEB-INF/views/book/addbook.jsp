<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add new book</title>
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
					<li class="active"><a href="<c:url value='/books/booklist'/>">Books</a></li>
					<li><a href="/authors/list">Authors</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Readers<span class="caret"></span></a>
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
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="generic-container">
			<div class="well lead" align="center">Add book by
				${book.author.firstName} ${book.author.lastName}</div>
			<form:form method="POST" modelAttribute="book"
				class="form-horizontal">
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="isbn">ISBN</label>
						<div class="col-md-7">
							<form:input type="number" path="isbn" id="isbn"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="isbn" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="name">Title</label>
						<div class="col-md-7">
							<form:input type="text" path="name" id="name"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="name" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="year">Year</label>
						<div class="col-md-7">
							<form:input type="number" path="year" id="year"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="year" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="publication">
							Publisher</label>
						<div class="col-md-7">
							<form:input type="text" path="publication" id="publication"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="publication" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="pageCount">Pages</label>
						<div class="col-md-7">
							<form:input type="number" path="pageCount" id="pageCount"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="pageCount" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<!--<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label" for="author">Author</label>
						<div class="col-md-7">
							<form:select path="author" name="author" id="author">
								<form:option value="">--Select one--</form:option>
								<c:forEach items="${authorList}" var="authorT">
									<form:option value="${authorT}">${authorT.firstName}
							${authorT.lastName}</form:option>
								</c:forEach>
							</form:select>
							<div class="has-error">
								<form:errors path="author" class="help-inline" />
							</div>
						</div>
					</div>
				</div> -->

				<div class="row">
					<div class="form-actions floatRight">
						<input type="submit" value="add" class="btn btn-primary btn-sm" />
						or <a href="<c:url value='/books/booklist' />">Cancel</a>
					</div>
				</div>
			</form:form>

		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript'
		src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
	<script type='text/javascript'
		src="<c:url value='/static/js/jquery.min.js'/>"></script>
</body>
</html>