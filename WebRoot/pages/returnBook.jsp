<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>returnBook</title>
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
</head>
<body>
    <div class="container">
	    <div class="row">
	    	<div class="well">
	    		<h3>Return Book</h3>
    		</div>
	        <form action="book/return.do" class="form-horizonal col-sm-offset-1">
	            <div class="form-group">
	                <label for="borrowedID" class="contorl-label col-sm-1">borrowedID:</label>
	                <input id="borrowedID" name="ID" type="text" class="form-control col-sm-8" placeholder="borrowedID">
	            </div>
	<!--             <div class="form-group">
	                <label for="uID" class="contorl-label col-sm-1">userID:</label>
	                <input id="uID" name="uID" type="text" class="form-control col-sm-8" placeholder="userID">
	            </div> -->
	            <input type="submit" class="btn btn-info col-sm-offset-2" value="submit">
	            <label style="font:20px red YaHei">${requestScope.message}</label>
	        </form>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>