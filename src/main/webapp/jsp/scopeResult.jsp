<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var test = "<%=application.getAttribute("application") %>";
	var test1 = "sally_application";
	
<%-- 	<%String a %> = test; --%>
<%-- 	//<%String a %> = test;  이 주석을 서버에서 실행이 되서 이렇게 하면 안된다. --%>
	<%-- 클라이언트에서는 서버 사이드 변수 값을 활용 할 수 있으나
			서버 사이드 변수에 클라이언트 사이드 변수 값을 대입 할 수는 없다.--%>
</script>
</head>
<body>


	
<%=request.getAttribute("request") %>
<%=session.getAttribute("session") %>
<%=application.getAttribute("application") %>
</body>
</html>