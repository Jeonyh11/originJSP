<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 전체 조회</title>


<%@include file="/common/common_lib.jsp"%>

<!-- Bootstrap core CSS -->

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

</head>

<body>

	<%@ include file="/common/header.jsp"%>


	<div class="container-fluid">
		<div class="row">

				<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="blog-header">
					<h1 class="blog-title">사용자 정보 조회</h1>
					<p class="lead blog-description">Let's go</p>
				</div>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
							
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
<%-- 								<% for(UserVo user : (List<UserVo>)request.getAttribute("userList")){ %> --%>
								
<!-- 								<tr> -->
<%-- 								<td><%=user.getUserid() %></td> --%>
<%-- 								<td><%=user.getUsernm() %></td> --%>
<%-- 								<td><%=user.getAlias() %></td> --%>
<%-- 								<td><%=user.getReg_dt() %></td> --%>
<!-- 								</tr> -->
								
<%-- 								<%} %> --%>
								
								<% List<UserVo> userList = (List<UserVo>)request.getAttribute("userList"); 
								
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.DD");
								for (int i = 0; i <userList.size(); i++) {
										UserVo vo = userList.get(i);
										
									out.write("<tr>");
									out.write("<td>" + vo.getUserid()+ "</td>");
								
									out.write("<td>"+vo.getUsernm()+ "</td>");
									
									out.write("<td>"+vo.getAlias()+ "</td>");
									
									out.write("<td>"+vo.getReg_dt_fmt()+ "</td>");
									
									
// 									if(vo.getReg_dt() != null){	
// 										out.write("<td>"+sdf.format(vo.getReg_dt())+ "</td>");
// 										}
// 										else{
// 											out.write("<td></td>");
// 										}
// 										out.write("</tr>");
								}%>
								
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

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