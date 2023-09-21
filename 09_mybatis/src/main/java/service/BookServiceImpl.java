package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BookDto;
import repository.BookDao;
import util.PageVo;

public class BookServiceImpl implements BookService {
  
  private BookDao dao = BookDao.getDao();
  private PageVo pageVo = new PageVo();

  @Override
  public ActionForward getBookList(HttpServletRequest request) {
    
    /* page, total, display 정보가 있어야 목록을 가져올 수 있다. */
    
    // 전달된 페이지 번호 (페이지 번호의 전달이 없으면 1 페이지를 연다.)
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    
    int total = dao.bookCount();  // dao 필요함
    
    int display = 5;  // 고정 값 사용 (원하면 파라미터로 받아 오는 것으로 변경도 가능함)
    
    // PageVo의 모든 정보 계산하기
    pageVo.setPaging(page, total, display);
    
    // 게시글 목록을 가져올 때 사용할 변수들을 Map으로 만듬
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", pageVo.getBegin());
    map.put("end", pageVo.getEnd());
    
    // DB로부터 게시글 목록 가져오기
    List<BookDto> bookList = dao.bookList(map);
    
    // 게시글 목록과 paging을 /board/list.jsp로 전달하기 위하여 request에 저장한 뒤 forward 한다.
    request.setAttribute("bookList", bookList);
    request.setAttribute("paging", pageVo.getPaging(request.getContextPath() + "/list.do"));
    
    return new ActionForward("/book/list.jsp", false);
  }
  
  @Override
  public ActionForward bookAdd(HttpServletRequest request) {
    
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    int price = Integer.parseInt(request.getParameter("price"));
    
    BookDto dto = BookDto.builder()
                    .title(title)
                    .author(author)
                    .price(price)
                    .build();
    int addResult = dao.bookAdd(dto);
    
    String path = null;
    
    if(addResult == 1) {
      path = request.getContextPath() + "/list.do";
    } else if(addResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    
    return new ActionForward(path, true);
  }

  @Override
  public ActionForward bookDetail(HttpServletRequest request) {
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    
    BookDto dto = dao.bookDetail(bookNo);
    
    request.setAttribute("book", dto);
    
    return new ActionForward("/book/detail.jsp", false);
  }
  
  @Override
  public ActionForward edit(HttpServletRequest request) {
    
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    BookDto dto = dao.bookDetail(bookNo);
    request.setAttribute("book", dto);
    
    return new ActionForward("/book/edit.jsp", false);
  }
  
  @Override
  public ActionForward modify(HttpServletRequest request) {
    
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    int price = Integer.parseInt(request.getParameter("price"));
    
    BookDto dto = BookDto.builder()
                    .bookNo(bookNo)
                    .title(title)
                    .author(author)
                    .price(price)
                    .build();
    
    int modifyResult = dao.bookModify(dto);
    String path = null;
    if(modifyResult == 1) {
      path = request.getContextPath() + "/detail.do?bookNo=" + bookNo;
    } else if(modifyResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward bookDelete(HttpServletRequest request) {
    
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    
    int deleteResult = dao.bookDelete(bookNo);
    String path = null;
    if(deleteResult == 1) {
      path = request.getContextPath() + "/list.do";
    } else if(deleteResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    
    return new ActionForward(path, true);
  }
  
}
