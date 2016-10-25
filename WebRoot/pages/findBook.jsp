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
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
<title>findBook</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	    	<div class="well">
	    		<h3>Find Book</h3>
    		</div>
			<DIV id="findBook">
				<FORM id="queryForm" class="form-inline col-sm-offset-1"
					action="book/findByID.do" method="GET">
					<SELECT class="form-control" id="findMethod">
						<OPTION value="findByID" selected="selected">ID</OPTION>
						<OPTION value="findByName">Name</OPTION>
					</SELECT>
					<INPUT type="text" name="queryInput" class="form-control"
						required="required">
					<span class="glyphicon glyphicon-search" aria-hidden="false"></span>
					</input>
					<INPUT type="submit" class="btn btn-primary" value="submit" />
				</FORM>
			</DIV>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		document.getElementById("findMethod").onchange = function() {
			var method = this.value;
			document.getElementById("queryForm").setAttribute("action",
					"<%=basePath%>book/" + method + ".do");
		}
	</script>
</body>
</html>