<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">

   <meta name="description" content="">
   <meta name="author" content="">

   <title>allUser</title>

   <%@ include file="/common/common_lib.jsp" %>
   
   <script src="/js/jquery/jquery-1.12.4.js"></script>
   <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
   <link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">
</head>

<body>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            
            $('#addr1').val(data.roadAddress);  //도로 주소
            $('#zipcode').val(data.zonecode);	//우편번호
        }
    }).open();
</script>

   <%@ include file="/common/header.jsp" %>

   <div class="container-fluid">
      <div class="row">
         <div class="col-sm-3 col-md-2 sidebar">
            <%@ include file="/common/left.jsp" %>
         </div>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

<!-- 					users 테이블에 있는 데이터를 불러오기 위해 UserVo 객체에 request값 불러오기 -->
               <% UserVo user = (UserVo)request.getAttribute("user"); %>
            <form class="form-horizontal" role="form" >
            <input type="hidden" name="userid" value="<%=user.getUserid() %>"/>
            
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getUserid() %></label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
                  <div class="col-sm-10">
                     
                     <input type="text" class="form-control" id="usernm" name="usernm"
								value="<%=user.getUsernm() %>">
                  </div>
               </div>
                  
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="alias" name="alias"
								value="<%=user.getAlias() %>">
                  </div>
               </div>
                     
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-10">
                     <label class="control-label">*******</label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">등록일자</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getReg_dt_fmt() %></label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">도로주소</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="addr1" name="addr1"
								value="<%=user.getAddr1() %>" readonly>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="addr2" name="addr2"
								value="<%=user.getAddr2() %>">
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" id="addr2" name="addr2"
								value="<%=user.getZipcode() %>" readonly>
                  </div>
               </div>

               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">사용자 수정</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>