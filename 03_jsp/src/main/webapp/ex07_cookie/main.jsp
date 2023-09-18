<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  // <body> 태그를 모두 읽은 뒤 function(){}을 실행한다.
  $(function(){
    $('#btn_logout').click(function(){
      location.href = '${contextPath}/logout';
    })
  })
</script>
</head>
<body>
    <div>
      <form method="post" action="${contextPath}/rememberMe">
        <div>
          <label for="id">아이디</label>
          <input type="text" name="id" id="id">
        </div>
        <div>
          <label for="pw">비밀번호</label>
          <input type="password" name="pw" id="pw">
        </div>
        <div>
        <button type="submit">로그인</button>
        </div>
        <div>
          <input type="checkbox" id="remember_me" name="remember_me">
          <label for="remember_me">아이디 기억</label>
        </div>
      </form>
    </div>
  
</body>
</html>