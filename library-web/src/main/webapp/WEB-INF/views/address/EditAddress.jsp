<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 8/27/2015
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Add Address Form</title>
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
        <li><a href="<c:url value='/'/>">Books</a></li>
        <li><a href="<c:url value='author/authorlist'/>">Authors</a></li>
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
<div class="generic-container">
  <div class="well lead">Add Address Form</div>
  <form:form method="POST" modelAttribute="address" class="form-horizontal">
    <form:input type="hidden" path="addressId" id="addressId"/>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="city">City</label>
        <div class="col-md-7">
          <form:input type="text" path="city" id="city"
                      class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="city" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="region">Region</label>
        <div class="col-md-7">
          <form:input type="text" path="region" id="region" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="region" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="street">Street</label>
        <div class="col-md-7">
          <form:input type="text" path="street" id="street" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="street" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="buildingNumber">Building</label>
        <div class="col-md-7">
          <form:input type="number" min="0" max="100" path="buildingNumber" id="buildingNumber" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="buildingNumber" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="apartmentNumber">Apartment</label>
        <div class="col-md-7">
          <form:input type="number" min="0" max="1000" path="apartmentNumber" id="apartmentNumber" class="form-control input-sm" />
          <div class="has-error">
            <form:errors path="apartmentNumber" class="help-inline"/>
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
