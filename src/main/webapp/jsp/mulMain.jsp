<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/mulCalculation" method = "post">
	<input type = "text" name ="param1"/>
	<input type = "text" name ="param2"/>
	<input type = "submit" value ="전송"/>
	

</form>

</body>
</html>