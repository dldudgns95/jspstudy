<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ex04_el.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%--
    Jsp binding 영역 (어떤 값을 속성(Attribute)의 형태로 저장할 때 사용하는 영역)
    1. pageContext : this,               현재 페이지에서만 접근할 수 있다.
    2. request     : HttpServletRequest, 응답 전까지 접근할 수 있다. (CRUD에 많이 사용됨)
    3. session     : HttpSession,        브라우저를 닫기 전까지 접근할 수 있다.
    4. application : ServletContext,     애플리케이션 종료 전까지 접근할 수 있다.
    
    Jsp binding 영역의 우선 순위 (동일한 이름의 속성이 서로 다른 영역에 존재하는 경우 먼저 사용되는 속성이 있다.)
    높음                                     낮음
    pageContext > request > session > application 
    
    Jsp binding 영역에 저장된 속성(Attribute)은 모두 표현언어(EL)로 표현할 수 있다.
  --%>
  
  <%--
    표현언어(EL)
    1. Expression Language
    2. binding 영역에 저장된 값을 나타낼 때 사용하는 언어이다.
    3. Jsp 표현식<%=값%>을 대체할 수 있다.
    4. 형식
      ${값}
    5. binding 영역 내장 객체
      1) pageContext를 의미하는 pageScope 객체
      2) request를 의미하는 requestScope 객체
      3) session을 의미하는 sessionScope 객체
      4) application을 의미하는 applicationScope 객체
  --%>
  <%-- 각 영역의 속성 msg 저장하기 --%>
  <%
    pageContext.setAttribute("msg", "pageContext");
    request.setAttribute("msg", "request");
    session.setAttribute("msg", "session");
    application.setAttribute("msg", "aplication");
  %>
  
  <%-- 우선 순위 확인 --%>
  <div>${msg}</div>
  
  <%-- 각 영역의 속성 확인하기 --%>
  <div>${pageScope.msg}</div>
  <div>${requestScope.msg}</div>
  <div>${sessionScope.msg}</div>
  <div>${applicationScope.msg}</div>
  
  <%-- 객체 사용하기 --%>
  <%
    // 객체를 만든 뒤 EL 사용이 가능한 binding 영역에 넣는다.
    Person person = new Person();
    person.setName("홍길동");
    person.setAge(30);
    pageContext.setAttribute("person", person);
  %>
  
  <div>이름: ${person.name}</div>     <%-- EL은 person.name을 person.getName() 방식으로 호출해서 보여준다. (getter를 넣어줘야 함) --%>
  <div>나이: ${person.age}</div> <%-- EL은 person.age를 person.getAge()   방식으로 호출해서 보여준다. --%>
  
  <hr>
  
  <%-- Map 사용하기 --%>
  <%
    // Map을 만든 뒤 EL 사용이 가능한 binding 영역에 넣는다.
    Map<String, Object> book = new HashMap<>();
    book.put("title", "소나기");
    book.put("price", 10000);
    pageContext.setAttribute("book", book);
  %>
  <div>제목 : ${book.title}</div>
  <div>가격 : ${book.price}</div>
  
  <%--
    EL 연산자
    1. 산술
      1) +
      2) -
      3) *
      4) / 또는 div
      5) % 또는 mod
    2. 크기 비교
      1) >  gt
      2) <  lt
      3) >= ge
      4) <= le
      5) == eq
      6) != ne
    3. 논리 연산
      1) 논리 AND : && 또는 and
      2) 논리 OR  : || 또는 or
      3) 논리 NOT : !  또는 not
    4. 조건 연산
      (조건식)? true일 때 : false일 때
  --%>
  <%
    int a = 5;
    int b = 2;
    pageContext.setAttribute("a", a);
    pageContext.setAttribute("b", b);
  %>
  <%-- a,b는 object이기에 연산하면 실수로 계산된다. --%>
  <div>a + b = ${a+b}</div>
  <div>a - b = ${a-b}</div>
  <div>a * b = ${a*b}</div>
  <div>a / b = ${a/b}</div>
  <div>a / b = ${a div b}</div>
  <div>a % b = ${a%b}</div>
  <div>a % b = ${a mod b}</div>
  
  <div>${a gt b}</div>
  <div>${a lt b}</div>
  <div>${a ge b}</div>
  <div>${a le b}</div>
  <div>${a eq b}</div>
  <div>${a ne b}</div>
  
  <hr>
  
  <div>${a gt b && a lt b}</div>
  <div>${a gt b and a lt b}</div>
  <div>${a ge b || a le b}</div>
  <div>${a ge b or a le b}</div>
  <div>${!(a eq b)}</div>
  
  <div>${(a gt b)? a: b}</div>
  
  <%--
    request 사용 시 주의사항
    
    1. 속성(Attribute)을 저장한 경우 (servlet -> jsp로 값을 보낼 때 사용한다.(response에는 값이 저장되지 않기 때문))
      request.setAttribute("name", "홍길동") -> ${name}
    
    2. 파라미터(Parameter)를 저장한 경우 (잘 사용되지 않음)
      /ContextPath/URLMapping?name=홍길동    -> ${param.name}
  --%>
  

</body>
</html>