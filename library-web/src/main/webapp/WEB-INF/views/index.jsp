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
     <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"></link>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <a class="navbar-brand active" href="<c:url value='/'/>"><span class="glyphicon glyphicon-education icon"></span><div class="div-space-3"></div>Library</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/books/booklist'/>">Books</a></li>
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
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${pageContext.request.remoteUser}"/><span class="caret"></span></a>
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
        </div><!--/.nav-collapse -->
    </nav>

    <div class="container">

      <div class="starter-template">
          <span class="glyphicon glyphicon-education"></span>
        <h1>Library</h1>
        <p class="lead">Welcome</p>

      </div>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type='text/javascript' src="<c:url value='/static/js/jquery.min.js'/>"></script>
    <script type='text/javascript' src="<c:url value='/static/js/bootstrap.min.js'/>"></script>

 
  </body>
</html>
