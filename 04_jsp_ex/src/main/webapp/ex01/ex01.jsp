<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <form method="get" action="<%=request.getContextPath()%>/ex01/result.jsp">
    당신의 나이는? 
    <input type="text" name="age">
    <button type="submit">확인</button>
  </form>
 
</body>
</html>