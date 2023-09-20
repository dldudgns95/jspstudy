<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%
    request.setCharacterEncoding("UTF-8");
    int age = Integer.parseInt(request.getParameter("age"));
  %>
  <%if(age >= 20) { %>
  <div>당신의 나이는 <%=age%>살 이므로 주류 구매가 가능합니다.</div>
  <%} else { %>
  <div>당신의 나이는 <%=age%>살 이므로 주류 구매가 불가능합니다.</div>
  <%} %>
  
  <div><a href="<%=request.getContextPath()%>/ex01/ex01.jsp">처음으로 이동</a></div>
  

</body>
</html>