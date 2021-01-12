<%@page import="kr.or.ddit.common.model.PageVo"%>
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
<script>
//HTML문서 로딩이 완료되고 나서 실행되는 영역
$(function(){
	$('.user').on("click", function(){
		//this : 클릭 이벤트가 발생한 element
		//data-속성명() data-userid , 속성명은 대소문자 무시하고 소문자로 인식
		var userid = $(this).data("userid");
		$("#userid").val(userid);
		$("#frm").submit();
	});
	
});
</script>
</head>

<body>
<form id="frm" action="<%=request.getContextPath()%>/user">
	<input type="hidden" id="userid" name="userid" value="" />
</form>


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
								
								
								
								<% for(UserVo pages : (List<UserVo>)request.getAttribute("userList")){ %>
									
								<tr class="user" data-userid="<%=pages.getUserid() %>">
								<td><%=pages.getUserid() %></td>
								<td><%=pages.getUsernm() %></td>
								<td><%=pages.getAlias() %></td>
								<td><%=pages.getReg_dt_fmt() %></td>
								</tr>
								
								<%} %>
								</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						
						<div class="text-center">
							<% PageVo pageVo  = (PageVo)request.getAttribute("PageVo");
							   int pagination =	(int)request.getAttribute("pagination");%>
							<ul class="pagination">
								
								<%-- pagination 값이 4이므로 1부터 4까지 4번 반복된다
								     전체 사용자수 : 16명
								     페이지 사이즈 : 5
								     전체 페이지 수 : 4페이지
								 --%> 
								 <li class="prev">
									<a href="<%=request.getContextPath() %>/pagingUser?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
								</li>
								<%for(int i = 1; i <= pagination; i++){
									
									if(pageVo.getPage() == i){%>
										<li class="active"><span><%=i %></span></li>
									<%}
									else {%>
										<li><a href="<%=request.getContextPath() %>/pagingUser?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li>
									<%} %>
								<%} %>
								<li class="next">
									<a href="<%=request.getContextPath() %>/pagingUser?page=<%=pagination %>&pageSize=<%=pageVo.getPageSize()%>">»</a>
								</li>
							</ul>
						</div>
						
						

<%-- 							전체 사용자 수 16명 
<%-- 								 페이지 사이즈 5 --%>
<%-- 								 전체 페이지 수 : 4 --%>
<%-- 							 --%> 
<%-- 								<% for(int i =1; i <= pagination; i++){  --%>
								
<%-- 								if(pageVo.getPage() == i){%> --%>
<%-- 								<li class ="active"><span><%=i %></span></li> --%>
<%-- 								<%}  --%>
								
<%-- 								else{%> --%>
								
<%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=<%=i %>&pageSize=<%=PageVo.getPageSize() %>"><%=i %></a></li> --%>
<%-- 								<%} --%>
								
<%-- 								%> --%>
							
							
<%-- <%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=1&pageSize=5">1</a></li> --%> 
<%-- <%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=2&pageSize=5">2</a></li> --%>
<%-- <%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=3&pageSize=5">3</a></li> --%> 
<%-- <%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=4&pageSize=5">4</a></li> --%> 
<%-- <%-- 								<li><a href="<%=request.getContextPath() %>/pagingUser?page=5&pageSize=5">5</a></li> --%> 

					</div>
				</div>
			</div>



		</div>
	</div>




</body>
</html>