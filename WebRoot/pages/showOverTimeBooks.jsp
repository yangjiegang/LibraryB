<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>showOverTimeBooks</title>
<link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
	    <div class="row">
	    	<div class="well">
	    		<h3>Over Time Book</h3>
    		</div>
			<c:choose>
				<c:when test="${!empty requestScope.books}">
					<%-- 	<label>${requestScope.books }</label> --%>
					<c:forEach items="${requestScope.books}" var="book">
						<label>bookID: ${book.bID}</label>
						<p>bookDate: ${book.borrowDate }</p>
						<p>uID: ${book.uID }</p>
						<hr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>no overtime book</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>