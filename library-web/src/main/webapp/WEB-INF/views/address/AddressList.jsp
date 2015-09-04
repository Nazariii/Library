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
					<li><a href="<c:url value='/books//booklist'/>">Books</a></li>
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
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Addresses<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/addresses/list_addresses">List of Addresses</a></li>
							<li><a href="/addresses/list_readers_addresses">List Readers and Addresses</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/addresses/new_address">Add new Address</a></li>
						</ul>
					</li>
					 <li class="dropdown">
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user">  </span><c:out value="${pageContext.request.remoteUser}">Not Authorized</c:out><span class="caret"></span></a>
                    	<ul class="dropdown-menu">
                    		<li><a href=""><c:url var="logoutUrl" value="/logout"/>
							    <form class="form-inline" action="${logoutUrl}" method="post">
							      <input type="submit" value="Log out" />
							      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							    </form></a></li>
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
									href="<c:url value='/addresses/edit-address-${address.addressId}' />"
									class="btn btn-success

custom-width">edit</a></td>
								<td><a
									href="<c:url value='/addresses/delete-address-${address.addressId}' />"
									class="btn btn-danger

custom-width">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="well">
				<a href="<c:url value='/addresses/new_address'/>" class="btn btn-info ">Add
					New Address</a>
			</div>
		</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>
