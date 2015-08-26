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
  <title>Readers List</title>
  <link href="<c:url value='/static/css/bootstrap.css' />"
        rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
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
        <th>Middle name</th>
        <th>Telephone</th>
        <th>Birth Date</th>
        <th width="100"></th>
        <th width="100"></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${readers}" var="reader">
        <tr>
          <td>${reader.firstName}</td>
          <td>${reader.lastName}</td>
          <td>${reader.middleName}</td>
          <td>${reader.telephone}</td>
          <td>${reader.birthDate}</td>
          <td><a href="<c:url value='/edit-user-${reader.readerId}' />"
                 class="btn btn-success

custom-width">edit</a></td>
          <td><a href="<c:url value='/delete-user-${reader.readerId}' />"
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
</body>
</html>
