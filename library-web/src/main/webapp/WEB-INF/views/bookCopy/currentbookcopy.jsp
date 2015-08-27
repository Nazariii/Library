<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Library</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap-theme.min.css'/>" rel="stylesheet"></link>

    <!-- Custom styles for this template -->
    <link href="<c:url value='/static/css/starter-template.css'/>" rel="stylesheet"></link>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="generic-container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <span class="lead">List of Book Copies </span>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookcopies}" var="bookcopy">
                    <tr>
                        <td>${bookcopies.book}</td>
                        <td>${bookcopies.}</td>
                        <td><a
                                href="<c:url value='/edit-user-${author.authorId}' />"
                                class="btn btn-success custom-width">edit</a></td>
                        <td><a
                                href="<c:url value='/delete-user-${author.authorId}' />"
                                class="btn btn-danger custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/authors/addauthor'/>" class="btn btn-info ">Add
                New Author</a>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>


</body>
</html>
