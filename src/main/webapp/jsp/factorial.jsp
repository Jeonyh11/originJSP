<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--jsp 메소드, 변수 선언부 --%>
    <%!
    //메소드 선언
    private int calculate(int i) {
		int fac = 1;
		for(int j = 1; j <=i; j++) {
			fac = fac * j;
		}
		return fac;
	}   
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
for(int i =1; i <= 5; i++){
		
	%>
	<%=i+ "! :" + calculate(i) %><br>
	
	
<%	
}
 %>

</body>
</html>