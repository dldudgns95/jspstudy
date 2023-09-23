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
  })
  function fnDetail(){
    $('#article_title').click(function(){
      location.href='${contextPath}/detail.do?article_no=' + $(this).find('.article_no').text();
    })
  }
  function fnDelete(){
    $('#btn_delete').click(function(){
      if(!confirm('현재 체크된 게시글을 삭제할까요?')){
        event.preventDefault();
        return;
      } else {
        location.href='${contextPath}/deleteCheck.do?article_no=' + $('#deleteCheck').val();
      }
    })
  }
  console.log('list.jsp 확인');
</script>
</head>
<body>

  <div>
    <a href="${contextPath}/write.do">작성하러가기</a>
    <button type="button" id="btn_delete">삭제하기</button>
  </div>
  
  <hr>
  
  <div>
    <c:forEach items="${articleList}" var="article">
      <div class="article">
        <span class="article_no">${article.article_no}</span>
        <span id="article_title">${article.title}</span>
        <span>${article.created}</span>
        <span><input type="checkbox" id="deleteCheck" name="deleteCheck" value="${article.article_no}"></span>
      </div>
    </c:forEach>
  </div>
  <div>
    ${paging}
  </div>

</body>
</html>