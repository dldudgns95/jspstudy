<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--
  인코딩, 디코딩을 위해 필요한 request.setCharacterEncoding("UTF-8")
  Optional로 null값을 다른 값으로 처리해주면 메인 화면 타이틀을 바꿀 수 있다.
--%>
<%
  request.setCharacterEncoding("UTF-8");
  Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
  String title = opt.orElse("환영합니다.");
  String contextPath = request.getContextPath();
%>
<title><%=title%></title>
<script src="<%=contextPath%>/resource/js/lib/jquery-3.7.1.min.js"></script>
<%--
  href의 '/jsp/'는 '/jsp/src/main/webapp/'와 같다. (프로젝트 Properties - Deployment Assembly에서 확인 가능)
  css의 경로를 사용할 때 캐싱으로 인해 CSS를 변경해도 반영되지 않을 수 있다.
  이에 대한 해결책은 href의 마지막에 '?dt=<%=System.currentTimeMillis()%>'를 추가해서 실행할때마다 변경된 값이 계속 반영되게 할 수 있다.
  (CSS의 완성품은 지워줘야 한다.) 
--%>
<link rel="stylesheet" href="<%=contextPath%>/resource/css/header.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=contextPath%>/resource/css/footer.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=contextPath%>/resource/css/main.css?dt=<%=System.currentTimeMillis()%>">
<script src="<%=contextPath%>/resource/js/header.js?dt=<%=System.currentTimeMillis()%>"></script>
</head>
<body>
  <nav class="gnb">
    <div class="logo"></div>
    <ul>
      <li><a href="main1.jsp">정치</a></li>
      <li><a href="main2.jsp">경제</a></li>
      <li><a href="main3.jsp">사회</a></li>
    </ul>
  </nav>
