
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.user.model.EmpVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>직원 전체 조회</title>

<%@include file="/common/common_lib.jsp"%>

<script src="/js/jquery/jquery-1.12.4.js"></script>
<script src="bootstrap.js"></script><!-- Custom styles for this template -->

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

</head>

<body>

<%@include file="/common/header.jsp" %>

<div class="container-fluid">
		<div class="row">
			
<%@include file="/common/left.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">직원</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사번</th>
					<th>직원 이름</th>
					<th>담당직무</th>
					<th>입사일시</th>
				</tr>
				
				<% List<EmpVo> empList = (List<EmpVo>)request.getAttribute("empList"); 
								
								
								
								for (int i = 0; i <empList.size(); i++) {
									EmpVo vo = empList.get(i);
										
									out.write("<tr>");
									out.write("<td>" + vo.getEmpno()+ "</td>");
								
									out.write("<td>"+vo.getEname()+ "</td>");
									
									out.write("<td>"+vo.getJob()+ "</td>");
									
									out.write("<td>"+vo.getHiredate()+ "</td>");
											
									out.write("</tr>");
								}%>
				
<%-- 				<%List<EmpVo> empList = (List<EmpVo>) request.getAttribute("empList"); %> --%>
<%-- 				<%for(int list : empList.size()){ --%>
<!--  							EmpVo emp = list.get(); -->
<%-- 					%> --%>
				
				
<%-- 				<%} %> --%>
				
				
				
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right"> 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
