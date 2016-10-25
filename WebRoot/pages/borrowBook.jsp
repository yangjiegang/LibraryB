<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>borrowBook</title>
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
</head>
<body>
    <div class="container">
	    <div class="row">
	    	<div class="well">
	    		<h3>Borrow Book</h3>
	    	</div>
	        <form action="book/borrow.do" class="form-horizontal" method="POST">
	            <div class="form-group">
	                <label for="bID" class="col-sm-2">bookID:</label>
	                <input id="bID" name="bID" type="text" class="form-control col-sm-6" placeholder="bookID">
	            </div>
	            <div class="form-group">
	                <label for="uID" class="col-sm-2">userID:</label>
	                <input id="uID" name="uID" type="text" class="form-control col-sm-6" placeholder="userID">
	            </div>
	            <input type="submit" class="btn btn-info col-sm-offset-2" value="submit">
	            <label style="font:20px red YaHei">${requestScope.message}</label>
	        </form>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>