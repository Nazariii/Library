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