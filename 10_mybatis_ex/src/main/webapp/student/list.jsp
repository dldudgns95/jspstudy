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
    fnStudentAdd();
    fnStudentList();
    fnStudentDetail();
    fnStudentDelete();
  })
  
  function fnStudentAdd(){
    $('#btn_write').click(function(){
      location.href="${contextPath}/stduent/write.do";
    })
  }
  
  function fnStudentList(){
    $('#btn_list').click(function(){
      location.href="${contextPath}/student/list.do";
    })
  }
  
  function fnStudentDetail(){
    $('.btn_detail').click(function(){
      location.href="${contextPath}/student/detail.do?stuNo=" + $(this).parent().parent().find('.stuNo').text();
    })
  }
  function fnStudentDelete(){
    $('.btn_delete').click(function(){
      if(!confirm('학생 정보를 삭제할까요?')){
        return;
      }
      location.href="${contextPath}/student/delete.do?stuNo=" + $(this).parent().parent().find('.stuNo').text();
    })
  }
  
</script>
</head>
<body>

  <div>
    <h1>학생 관리</h1>
  </div>
  <div>
    <button type="button" id="btn_write">신규학생등록</button>
  </div>
  
  <hr>
  <div>
    <form id="frm_ave" method="get" action="${contextPath}/student/query.do">
      <span>평균 </span>
      <input type="text" id="begin" name="begin" maxlangth="3" size="4">
      <span> ~ </span>
      <input type="text" id="end" name="end" maxlangth="3" size="4">
      <button type="submit">조회</button>
      <button type="button" id="btn_list">전체조회</button>
    </form>
  </div>
  
  <hr>
  
  <div>
    <c:forEach items="${studentTopList}" var="studentTop" varStatus="rownum">
      <div>
        <span>${rownum.count}위</span>
        <span>${studentTop.name}님</span>
        <span>${studentTop.ave}점</span>
      </div>
    </c:forEach>
  </div>
  
  <hr>
  <table border="1">
    <caption>전체 회원수 <span id="student_total">${studenCount}${rangeCount}</span>명</caption>
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
      <c:forEach items="${studentList}" var="student">
        <tr>
          <td class="stuNo">${student.stuNo}</td>
          <td>${student.name}</td>
          <td>${student.kor}</td>
          <td>${student.eng}</td>
          <td>${student.math}</td>
          <td>${student.ave}</td>
          <td>${student.grade}</td>
          <td>
            <button type="button" class="btn_detail">상세</button>
            <button type="button" class="btn_delete">삭제</button>
          </td>
        </tr>
      </c:forEach>
      <c:forEach items="${studentRangeList}" var="studentRange">
        <tr>
          <td class="stuNo">${studentRange.stuNo}</td>
          <td>${studentRange.name}</td>
          <td>${studentRange.kor}</td>
          <td>${studentRange.eng}</td>
          <td>${studentRange.math}</td>
          <td>${studentRange.ave}</td>
          <td>${studentRange.grade}</td>
          <td>
            <button type="button" class="btn_detail">상세</button>
            <button type="button" class="btn_delete">삭제</button>
          </td>
        </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
      <td colspan="5">전체평균</td>
      <td id="totalAve">${studentTotalAve}${studentRangeAve}</td>
      <td colspan="3"></td>
      </tr>
    </tfoot>
  </table>

</body>
</html>