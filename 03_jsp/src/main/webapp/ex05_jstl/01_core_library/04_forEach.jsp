<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="ex05_jstl.BlogPost"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%--
    <c:forEach>
    1. 반복문을 처리한다.
    2. 형식
      1) 일반 for문
        <c:forEach var="속성" begin="시작값" end="종료값" step="증가값(감소X)">
          ${속성}
        </c:forEach>
      2) 향상 for문
        <c:forEach var="요소" items="배열 or 리스트">
          ${요소}
        </c:forEach> 
  --%>
  <%-- 1~5 출력 --%>
  <c:forEach var="n" begin="1" end="5" step="1">
    <div>${n}</div>
  </c:forEach>
  
  <c:forEach var="n" begin="1" end="5" step="1">
    <div>${6 - n}</div>
  </c:forEach>
  
  <hr>
  
  <%-- <c:forEach> 태그와 배열 --%>
  <%
    String[] seasons = {"봄", "여름", "가을", "겨울"};
    pageContext.setAttribute("seasons", seasons);
  %>
  <c:forEach var="season" items="${seasons}" varStatus="vs">
    <div>인덱스 : ${vs.index}</div>
    <div>요소   : ${season}</div>
  </c:forEach>
  
  <hr>
  
  <%-- <c:forEach> 태그와 리스트 --%>
  <%
    List<String> jobs = Arrays.asList("PM", "기획자", "개발자", "퍼블리셔");
    pageContext.setAttribute("jobs", jobs);
  %>
  <c:forEach var="job" items="${jobs}" varStatus="vs">
    <div>인덱스 : ${vs.index}</div>
    <div>직업   : ${job}</div>
  </c:forEach>
  
  <hr>
  
  <%-- 임의의 BlogPost 3개를 List에 저장하고 화면에 출력하기 --%>
  
  <%
    BlogPost blogPost1 = new BlogPost(1, "게시글1", 35, LocalDate.of(2020, 9, 15));
    BlogPost blogPost2 = new BlogPost(2, "게시글2", 150, LocalDate.of(2022, 9, 15));
    BlogPost blogPost3 = new BlogPost(3, "게시글3", 89, LocalDate.of(2023, 9, 15));
    List<BlogPost> blogPosts = new ArrayList<BlogPost>();
    blogPosts.add(blogPost1);
    blogPosts.add(blogPost2);
    blogPosts.add(blogPost3);
    
    pageContext.setAttribute("blogPosts",blogPosts);
  %>
  <div>
    <c:forEach var="blogPost" items="${blogPosts}" varStatus="vs">
      <h3>${blogPost.blogPostNo}번째 게시글</h3>
      <ul>
        <li>제목 : <a href="#">${blogPost.title}</a></li>
        <li>조회수 : ${blogPost.hit}</li>
        <li>게시날짜 : ${blogPost.createdAt}</li>
      </ul>
    </c:forEach>
  </div>
  
  
  
  
  
  
  
  

</body>
</html>