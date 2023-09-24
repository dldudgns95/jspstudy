package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("*.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=UTF-8");
	  
	  ActionForward af = null;
	  StudentService studentService = new StudentServiceImpl();
	  
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(contextPath.length());
	  PrintWriter out = response.getWriter();
	  String str = null;
	  
	  switch(urlMapping) {
	  case "/student/list.do":
	    af = studentService.studentList(request);
	    break;
	  case "/stduent/write.do":
	    af = new ActionForward("/student/write.jsp", false);
	    break;
	  case "/student/add.do":
	    af = studentService.studentAdd(request);
	    str = "<script>alert('등록을 완료했습니다.'); location.href='" + af.getPath() + "';</script>";
	    out.println(str);
	    out.flush();
	    out.close();
	    break;
	  case "/student/query.do":
	    af = studentService.studentRangeList(request);
	    break;
	  case "/student/detail.do":
	    af = studentService.studentDetail(request);
	    break;
	  case "/student/modify.do":
	    af = studentService.studentModify(request); 
	    str = "<script>alert('수정을 완료했습니다.'); location.href='" + af.getPath() + "';</script>";
      out.println(str);
      out.flush();
      out.close();
	    break;
	  case "/student/delete.do":
	    af = studentService.studentDelete(request);
	    str = "<script>alert('삭제를 완료했습니다.'); location.href='" + af.getPath() + "';</script>";
      out.println(str);
      out.flush();
      out.close();
	    break;
	  }
	  
	  if(af != null) {
	    if(!af.isRedirect()) {
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
