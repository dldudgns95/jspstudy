<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  $(function(){
    
  })
  
  function fnStudentRegister(){
    $('#btn_register').click(function(){
      location.href="${contextPath}/stduent/register.do";
    })
  }
  
</script>
</head>
<body>

  <div>
    <h1>학생 관리</h1>
  </div>
  <div>
    <button type="button" id="btn_register">신규학생등록</button>
  </div>
  
  <hr>
  <div>
    <form id="frm_ave">
      <span>평균 </span>
      <input type="text" id="ave_begin" maxlangth="3" size="4">
      <span> ~ </span>
      <input type="text" id="ave_end" maxlangth="3" size="4">
      <button type="submit">조회</button>
    </form>
    <button type="button" id="btn_list">전체조회</button>
  </div>
  
  <hr>
  
  <hr>
  <table border="1">
    <caption>전체 회원수 <span id="student_total"></span>명</caption>
    <thead>
      <tr>
        <td>학번</td>
        <td>성명</td>
        <td>국어</td>
        <td>영어</td>
        <td>수학</td>
        <td>평균</td>
        <td>학점</td>
        <td>버튼</td>
      </tr>
    </thead>
    <tbody id="student_list">
    
    </tbody>
  </table>

</body>
</html>