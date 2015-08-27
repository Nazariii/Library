<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 8/27/2015
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
        <li class="active"><a href="<c:url value='/'/>">Books</a></li>
        <li><a href="<c:url value='/authors'/>">Authors</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Readers<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/readers/list_readers">List of Readers</a></li>
            <li><a href="#">List Readers and Books</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/readers/edit_reader">Add new Reader</a></li>

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
        <span class="lead">List of Readers </span>
      </div>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>First name</th>
          <th>Last name</th>
          <th>Title</th>
          <th>Author</th>
          <th>Publication</th>
          <th>Year</th>
          <th>Page count</th>
          <th width="100"></th>
          <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${readerListMap}" var="entry">
          <tr>
            <td>${entry.key.firstName}</td>
            <td>${entry.key.lastName}</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td><a
                      href="<c:url value='/edit-user-${entry.key.readerId}' />"
                      class="btn btn-success

custom-width">edit</a></td>
              <td><a
                      href="<c:url value='/delete-user-${entry.key.readerId}' />"
                      class="btn btn-danger

custom-width">delete</a></td>
          </tr>
              <c:forEach items="${entry.value}" var="entryValue">
                  <tr>
                      <td></td>
                      <td></td>
                  <td>${entryValue.name}</td>
                      <td>${entryValue.author.lastName} ${entryValue.author.firstName}</td>
                  <td>${entryValue.publication}</td>
                  <td>${entryValue.year}</td>
                  <td>${entryValue.pageCount}</td>
                      <td></td>
                      <td></td>
                      </tr>
              </c:forEach>

        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="well">
      <%--<a href="<c:url value='/reader/new_reader' />">Add New AQuthor</a>--%>
    </div>
  </div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>
