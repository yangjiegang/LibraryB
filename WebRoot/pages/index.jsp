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
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link type="text/css" rel="stylesheet" href="../css/book.css"> -->
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</head>
<html>
<!-- <framset rows="10%,90%">
<noframs>no frames support</noframs>
	<frame src="pages/header.jsp" name="header">	
	<frameset cols="20%,80%">
		<frame src="pages/header.jsp" name="options">
		<frame src="pages/welcome.jsp" name="content">
	</frameset>
</framset> -->


<frameset rows="10%,90%">

	<frame src="pages/header.jsp" name="header">
	
	<frameset cols="15%,85%">
		<frame src="pages/options.jsp" name="options">
		<frame src="pages/welcome.jsp" name="content">
	</frameset>

</frameset>

</html>
</html>