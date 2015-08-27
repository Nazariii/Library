<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 8/26/2015
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addresses List</title>
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
					<li class="active"><a href="<c:url value='/'/>">Books</a></li>
					<li><a href="<c:url value='/authors/list'/>">Authors</a></li>
					<li><a href="<c:url value='/list_readers'/>">Readers</a></li>
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
					<span class="lead">List of Addresses</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>City</th>
							<th>Region</th>
							<th>Street</th>
							<th>Building</th>
							<th>Apartment</th>
							<th width="100"></th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${addresses}" var="address">
							<tr>
								<td>${address.city}</td>
								<td>${address.region}</td>
								<td>${address.street}</td>
								<td>${address.buildingNumber}</td>
								<td>${address.apartmentNumber}</td>
								<td><a
									href="<c:url value='/edit-user-${address.addressId}' />"
									class="btn btn-success

custom-width">edit</a></td>
								<td><a
									href="<c:url value='/delete-user-${address.addressId}' />"
									class="btn btn-danger

custom-width">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="well">
				<%--<a href="<c:url value='/reader/new_reader' />">Add New AQuthor</a>--%>
			</div>
		</div>
	</div>
</body>
</html>