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
    fnStudentList();
    fnFormCheck();
  })
  
  function fnStudentList(){
    $('#btn_list').click(function(){
      location.href="${contextPath}/student/list.do";
    })
  }
  
  function fnFormCheck(){
    $('#frm_modify').submit(function(event){
      if($('#name').val() === '') {
        alert('이름은 필수입니다.');
        $('#name').focus();
        event.preventDefault();
        return;
      }
      if($('#kor').val() === '' || Number($('#kor').val()) === 'NaN' || Number($('#kor').val()) < 0 || Number($('#kor').val()) > 100) {
        alert('국어의 점수를 제대로 기입해주세요. (0~100점)');
        $('#kor').focus();
        event.preventDefault();
        return;
      }
      if($('#eng').val() === '' || Number($('#eng').val()) === 'NaN' || Number($('#eng').val()) < 0 || Number($('#eng').val()) > 100) {
        alert('영어의 점수를 제대로 기입해주세요. (0~100점)');
        $('#eng').focus();
        event.preventDefault();
        return;
      }
      if($('#math').val() === '' || Number($('#math').val()) === 'NaN' || Number($('#math').val()) < 0 || Number($('#math').val()) > 100) {
        alert('수학의 점수를 제대로 기입해주세요. (0~100점)');
        $('#math').focus();
        event.preventDefault();
        return;
      }
    })
  }
  
</script>
</head>
<body>
  
  <div>
    <h1>학생 관리</h1>
  </div>
  
  <div>
    <form id="frm_modify" method="post" action="${contextPath}/student/modify.do">
      <div>
        <label for="stuNo">학번</label>
        <input type="text" id="stuNo" name="stuNo" value="${student.stuNo}" readonly>     
      </div>
      <div>
        <label for="name">이름</label>
        <input type="text" id="name" name="name" value="${student.name}">     
      </div>
      <div>
        <label for="kor">국어</label>
        <input type="text" id="kor" name="kor" value="${student.kor}">     
      </div>
      <div>
        <label for="eng">영어</label>
        <input type="text" id="eng" name="eng" value="${student.eng}">     
      </div>
      <div>
        <label for="math">수학</label>
        <input type="text" id="math" name="math" value="${student.math}">     
      </div>
      <div>
        <label for="ave">평균</label>
        <input type="text" id="ave" name="ave" value="${student.ave}" disabled="disabled">     
      </div>
      <div>
        <label for="grade">학점</label>
        <input type="text" id="grade" name="grade" value="${student.grade}" disabled="disabled">     
      </div>
      
      <hr>
      
      <div>
        <button type="submit">수정하기</button>
        <button type="button" id="btn_list">목록보기</button>
      </div>
      
    </form>
  </div>

</body>
</html>