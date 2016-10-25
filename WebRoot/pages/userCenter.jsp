<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>userCenter</title>
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<div id="row">
	    	<div class="well">
	    		<h3>User Center</h3>
    		</div>
			<c:choose>
				<c:when test="${empty requestScope.borrowedBooks}">
					No borrowed books now...
				</c:when>
				<c:otherwise>
					<c:forEach var="books" items="${requestScope.borrowedBooks }">

						<div class="media">
							<div class="media-left media-middle">
								<a href="">
									<img class="media-object" src="<%=basePath%>images/example.png" alt="images" width="150" height="150"/>
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading"></h4>
								<p>book_name:&nbsp;${ books[4] }</p>
								<p>book_author:&nbsp;${ books[5] }</p>
								<p>book_state:&nbsp;${ books[3] }</p>
								<p>borrow_date:&nbsp;${ books[0] }</p>
								<p>back_date:&nbsp;${ books[1] }</p>
							</div>
						</div>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<!--     <script type="text/javascript" src="../js/book.js"></script> -->
<%-- 	<script type="text/javascript">
		var bookInfos = JSON.parse(<%=request.getAttribute("jsonStr")%>);
		console.log(bookInfos);
	</script> --%>
</body>
</html>
