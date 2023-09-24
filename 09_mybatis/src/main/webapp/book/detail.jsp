<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .link a {
  margin-right: 10px;
  }
</style>
<script>
  
  $(function(){
    fnDelete();
  })
  
  function fnDelete(){
    $('#delete_link').click(function(event){
      if(!confirm('게시글을 삭제할까요?')){
        event.preventDefault();
        return;
      }
    })
  }
  
</script>
</head>
<body>

  <div class="link">
    <a href="${contextPath}/write.do">책등록하러가기</a>
    <a href="${contextPath}/list.do">목록으로이동</a>
    <a href="${contextPath}/edit.do?bookNo=${book.bookNo}">수정하러가기</a>
    <a id="delete_link" href="${contextPath}/delete.do?bookNo=${book.bookNo}">삭제하기</a>
  </div>
  
  <hr>
  
  <div>
    <div>책번호: ${book.bookNo}</div>
    <div>책제목: ${book.title}</div>
    <div>저자: ${book.author}</div>
    <div>가격: ${book.price}</div>
    <div>등록일: ${book.pubdate}</div>
  </div>

</body>
</html>