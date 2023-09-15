package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/testServlet3")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		request.setCharacterEncoding("UTF-8");
		
		String check = request.getParameter("check");
		Date now = new Date();
		System.out.println(now);
		String str;
		if(check == "day") {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  System.out.println(sdf.format(now));
		  str = "<script>alert('요청 결과는 " + sdf.format(now) + "입니다.');location.href='/ex_servlet/ex03/ex03.html';</script>"; 
		} else {
		  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		  System.out.println(sdf.format(now));
      str = "<script>alert('요청 결과는 " + sdf.format(now) + "입니다.');location.href='/ex_servlet/ex03/ex03.html';</script>"; 
		}
		/*
		response.setContentType("text/html; cherset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
