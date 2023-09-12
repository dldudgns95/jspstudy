package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String[] birthday = request.getParameterValues("birthday");
		String gender = request.getParameter("gender");
		String checkEmail = request.getParameter("checkEmail");
		String[] tel = request.getParameterValues("tel");
		
		JSONObject responseJSON = new JSONObject();
		responseJSON.put("id", id);
		responseJSON.put("pw", pw);
		responseJSON.put("name", name);
		responseJSON.put("birthday", birthday);
		responseJSON.put("gender", gender);
		responseJSON.put("checkEmail", checkEmail);
		responseJSON.put("tel", tel);
		
		System.out.println(responseJSON);
		
		response.setContentType("aplication/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(responseJSON);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
