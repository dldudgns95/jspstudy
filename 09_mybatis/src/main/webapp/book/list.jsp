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
  .board span {
    margin-right: 20px;
  }
</style>
<script>
  $(function(){
    fnDetail();
    fnDelete();
  })
  function fnDetail(){
    $('.book_title').click(function(){
      location.href='${contextPath}/detail.do?bookNo=' + $(this).prev('span').text();
    })
  }
  function fnDelete(){
    $('#btn_checkDelete').click(function(event){
      if(!confirm('게시글을 삭제할까요?')){
        event.preventDefault();
        return;
      } else {
        var val = [];
        $('.deleteCheck:checked').each(function(){
          val.push($(this).val());
        });
        location.href='${contextPath}/checkDelete.do?bookNo=' + val;
      }
    })
  }
</script>
</head>
<body>

  <div>
    <a href="${contextPath}/write.do">등록하러가기</a>
    <button type="button" id="btn_checkDelete">삭제하기</button>
  </div>
  
  <hr>
  
  <div>
    <c:forEach items="${bookList}" var="book">
      <div class="book">
        <span class="bookNo">${book.bookNo}</span>
        <span class="book_title">${book.title}</span>
        <span>${book.author}</span>
        <span>${book.price}</span>
        <span>${book.pubdate}</span>
        <input type="checkbox" class="deleteCheck" name="deleteCheck" value="${book.bookNo}">
      </div>
    </c:forEach>
  </div>
  <div>
    ${paging}
  </div>

</body>
</html>