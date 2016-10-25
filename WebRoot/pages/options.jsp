<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<base target="content">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>options</title>
<link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="col-sm-8 col-sm-offset-1">
		<H3>options&nbsp<span class="label label-default">go</span></H3>
		<ul id="options" class="nav nav-stacked">
			<li><a href="pages/welcome.jsp">welcome</a></li>
			<li><a href="pages/register.jsp">register</a></li>
			<li><a href="pages/login.jsp">login</a></li>
			<li><a href="pages/findBook.jsp">findbook</a></li>
<!-- 			<li><a href="findBookByID.html">findbookbyid</a></li>
			<li><a href="findBooksByName.html">findBooksByName</a></li> -->
     		<li><a href="pages/addOneBook.jsp">addOneBook</a></li>
     		<%-- <li><a href="${requestScope.userName}?user/center.do?userName='${requestScope.userName}':'#'">user_center</a></li> --%>
     		<li><a href="user/center.do?userName='Alex'">user_center</a></li>
    		<li><a href="pages/borrowBook.jsp">borrowBook</a></li>
    		<li><a href="pages/returnBook.jsp">returnBook<span class="badge">2</span></a></li>
    		<li><a href="book/getOverTime.do">showOverTimeBooks</a></li>
		</ul>
	</div>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>