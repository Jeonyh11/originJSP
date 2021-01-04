<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/scope" name ="test" method ="post">
	<div>
		<input type ="text" name = "scope"/>
		<input type = "submit" value="전송"/>
			
	</div>

</form>
</body>
</html>