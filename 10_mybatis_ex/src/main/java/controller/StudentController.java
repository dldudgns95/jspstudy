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
	  String msg = null;
	  
	  switch(urlMapping) {
	  case "/student/list.do":
	    af = studentService.studentList(request);
	    break;
	  case "/stduent/write.do":
	    af = new ActionForward("/student/write.jsp", false);
	    break;
	  case "/student/add.do":
	    af = studentService.studentAdd(request);
	    msg = "등록을 ";
	    break;
	  case "/student/query.do":
	    af = studentService.studentRangeList(request);
	    break;
	  case "/student/detail.do":
	    af = studentService.studentDetail(request);
	    break;
	  case "/student/modify.do":
	    af = studentService.studentModify(request); 
	    msg = "수정을 ";
	    break;
	  case "/student/delete.do":
	    af = studentService.studentDelete(request);
	    msg = "삭제를 ";
	    break;
	  }
	  
	  if(af != null) {
	    if(af.isRedirect()) {
	      str = "<script>alert('" + msg + "완료했습니다.'); location.href='" + af.getPath() + "';</script>";
	      out.println(str);
	      out.flush();
	      out.close();
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
