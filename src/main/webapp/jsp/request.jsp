<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	request.getRequestURI() : <%=request.getRequestURI() %> <br>
	request.getContentType() : <%=request.getContentType() %><br>
	request.getMethod() : <%=request.getMethod() %><br>
	request.getContextPath() : <%=request.getContextPath() %><br>
	request.getServerPort() : <%=request.getServerPort() %><br>
	
</body>
</html>