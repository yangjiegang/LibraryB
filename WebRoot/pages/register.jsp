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
<title>register</title>
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<div id="registerDiv">
			<fieldset>
				<legend>
					<h4>Register</h4>
				</legend>
				<form class="form-group" action="register.do" method="post">
					<div class="form-group col-sm-8">
						<label for="userName">userName</label> <input type="text"
							id="userName" class="form-control" name="userName" />
					</div>
					<DIV class="form-group col-sm-8">
						<label for="#">password</label> <input type="password"
							class="form-control" name="password" />
					</DIV>
					<div class="checkbox-inline col-sm-8">
						<lable> <input type="radio" value="true" name="gender"
							checked="checked" />male</lable>
						<lable> <input type="radio" value="false" name="gender" />female</lable>
					</div>
					<BR />
					<DIV class="form-group col-sm-8">
						<input type="submit" class="btn btn-info" value="submit" /> <SPAN>&nbsp</SPAN>
						<input class="btn btn-warning" type="reset" value="reset" />
					</DIV>
					<lable style="font:30px red YaHei">${message }</lable>
				</form>
			</fieldset>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>