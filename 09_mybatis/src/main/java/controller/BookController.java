package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BookService;
import service.BookServiceImpl;

/**
 * Servlet implementation class BookController
 */
@WebServlet("*.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  response.setContentType("text/html; charset=UTF-8");
	  
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(contextPath.length());
	  
	  ActionForward af = null;
	  
	  BookService bookService = new BookServiceImpl();
	  
	  switch(urlMapping) {
	  case "/list.do":
	    af = bookService.getBookList(request);
	    break;
	  case "/write.do":
	    af = new ActionForward("/book/write.jsp", false);
	    break;
	  case "/register.do":
	    af = bookService.bookAdd(request);
	    break;
	  case "/detail.do" :
	    af = bookService.bookDetail(request);
	    break;
	  case "/edit.do" :
	    af = bookService.edit(request);
	    break;
	  case "/modify.do" :
	    af = bookService.modify(request);
	    break;
	  case "/delete.do" :
	    af = bookService.bookDelete(request);
	    break;
	  case "/checkDelete.do":
	    af = bookService.bookCheckDelete(request);
	    break;
	  }
	  
	  if(af != null) {
	    if(af.isRedirect()) {
	      response.sendRedirect(af.getPath());
	    } else {
	      request.getRequestDispatcher(af.getPath()).forward(request, response);
	    }
	  }
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
