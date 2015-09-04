<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Add Author Form</title>
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

                <li><a href="<c:url value='/books/booklist'/>">Books</a></li>
                <li class="active"><a href="/authors/list">Authors</a></li>
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
                    </ul></li>
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
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading" align="center">
            <span class="lead">List of Readers </span>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>First name</th>
                <th>Last NAmer</th>
                <th>Telephone</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${readers}" var="reader">
                <tr>
                    <td>${reader.firstName}</td>
                    <td>${reader.lastName}</td>
                    <td>${reader.telephone}</td>
                    <td><a
                            href="<c:url value='/bookcopies/submitreader-${isbn}-${id}-${reader.readerId}' />"
                            class="btn btn-success

custom-width">submit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%--
<div class="container">
    <div class="generic-container">
        <div class="well lead">Add Reader Form</div>
        <form:form method="POST" modelAttribute="reader"
				class="form-horizontal">
        <form:input type="hidden" path="readerId"  />

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First
                    Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName"
                                class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline" />
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last
                    Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName"
                                class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline" />
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-actions floatRight">
                        <input type="submit" value="Add" class="btn btn-primary btn-sm" /> or <a
                            href="<c:url value='/bookcopies/submitreader-${isbn}-${id}-${reader.readerId}'/>">Cancel</a>
            </div>
        </div>
        </form:form>
    </div>
</div>
--%>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type='text/javascript'
        src="<c:url value='/static/js/jquery.min.js'/>"></script>
<script type='text/javascript'
        src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>