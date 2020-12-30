<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%-- 개인정보를 전송 하므로 url에 노출되지 않도록 request body 영역에 파라미터를 전송 > method="POST" --%>

<form action="<%=request.getContextPath() %>/loginController" method="POST">
user id : <input type ="text" name ="userid" value="bro"><br>
user id : <input type ="text" name ="userid" value="pro"/><br>
password : <input type ="password" name ="password" value="5678"/><br>
<input type ="submit"  value="전송"/>

//input type =submit 은 자체가 전송이기 때문에 name="" 도 전송이 되는데 한글은 깨짐 
</form>
</body>
</html>