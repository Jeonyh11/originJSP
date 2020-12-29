<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	width : 80%;
	margin : 150px;
}
td{
text-align : center;
}

</style>
<script  type="text/javascript">
<%-- <%for(int i =1; i<=9; i++) { --%>
// 		out.println("<tr>");
// 	for(int j =2; j <=9; j++) {
// 		out.println("<td>" + j + "* "+i+"=" + j*i + "</td>");
// 	}
// 	out.println("</tr>");	
<%-- }%> --%>
</script>
</head>
<body>
		
	<table border='1'>

	<% for(int i =1; i<=9; i++) { %>
		<tr>
	<% 	for(int j =2; j <=9; j++) { %>
		<td> <%= j %> * <%= i%> = <%= j*i%></td>
		<% } %>
		</tr>	
	<% }%>

</table>
</body>
</html>