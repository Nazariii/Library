<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>< Add Author Form</title>
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
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">Available Books</span>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookcopies}" var="bookcopy">
            <c:if test="${bookcopy.isPresent eq 'Y'.charAt(0)}">
            <tr>
                <td>${bookcopy.book.name}</td>
            </tr>
            </c:if>
            </c:forEach>
            <tbody>
        </table>
    </div>
</div>
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">
        <span class="lead">Not available Books</span>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th width="100"></th>
            <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookcopies}" var="bookcopy">
        <c:if test="${bookcopy.isPresent eq 'N'.charAt(0)}">
        <tr>
            <td>${bookcopy.book.name}</td>
        </tr>
        </c:if>
        </c:forEach>
        <tbody>
    </table>
</div>
</div>
    </div>


</body>
</html>