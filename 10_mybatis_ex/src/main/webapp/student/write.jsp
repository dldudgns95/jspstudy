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
    fnStudenList();
    fnFormCheck();
  })
  
  function fnStudenList(){
    $('#btn_list').click(function(){
      location.href = '${contextPath}/student/list.do';
    })
  }
  function fnFormCheck(){
    $('#frm_write').submit(function(event){
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

  <form id="frm_write" method="post" action="${contextPath}/student/add.do">
    <div>
      <label for="name">이름</label>
      <input type="text" id="name" name="name">
    </div>
    <div>
      <label for="kor">국어</label>
      <input type="text" id="kor" name="kor">
    </div>
    <div>
      <label for="eng">영어</label>
      <input type="text" id="eng" name="eng">
    </div>
    <div>
      <label for="math">수학</label>
      <input type="text" id="math" name="math">
    </div>
    
    <hr>
    
    <div>
      <button type="submit">작성완료</button>
      <button type="reset">다시작성</button>
      <button type="button" id="btn_list">목록보기</button>
    </div>
  </form>

</body>
</html>