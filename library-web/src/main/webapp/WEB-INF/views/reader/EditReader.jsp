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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Add Reader Form</title>
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
        <li><a href="<c:url value='author/authorlist'/>">Authors</a></li>
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
  <div class="well lead">Add Reader Form</div>
  <form:form method="POST" modelAttribute="reader" class="form-horizontal">
    <form:input type="hidden" path="readerId" id="readerId"/>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="firstName">First Name</label>
        <div class="col-md-7">
          <form:input type="text" path="firstName" id="firstName"
                      class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="firstName" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="lastName">Last Name</label>
        <div class="col-md-7">
          <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="lastName" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="middleName">Middle Name</label>
        <div class="col-md-7">
          <form:input type="text" path="middleName" id="middleName" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="middleName" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="telephone">Phone number</label>
        <div class="col-md-7">
          <form:input type="text" path="telephone" id="telephone" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="telephone" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="birthDate">Birth Date</label>
        <div class="col-md-7">
            <div class='input-group date' id='datetimepicker1'>
              <form:input type="date" path="birthDate" id="birthDate" class="form-control input-sm" />
                <div class="has-error">
                <form:errors path="birthDate" class="help-inline"/>
              </div>
              <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
              </span>
            </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-actions floatRight">
        <c:choose>
          <c:when test="${edit}">
            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a

                  href="/list_readers/">Cancel</a>
          </c:when>
          <c:otherwise>
            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a

                  href="/list_readers/">Cancel</a>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </form:form>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
<script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>
