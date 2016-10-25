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
<title>login</title>
</head>
<body>
	<div id="login" align="center">
		<fieldset>
			<legend>Login</legend>
			<form action="user/login.do" method="POST">
				<p>
					<label for="">username</label>
					<input type="text" name="userName" required="required"
						autocomplete="autocomplete" />
				</p>
				<p>
					<label for="">password</label>
					<input type="password" name="password" required="required" />
				</p>
				<p>
					<input type="submit" value="submit" />
					<input type="reset" value="reset" />
				</p>
			</form>
		</fieldset>
	</div>
</body>
</html>