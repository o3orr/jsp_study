package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		String job = request.getParameter("job");
		String[] interests = request.getParameterValues("interest");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("당신이 선택한 직업 : <b>");
		out.println(job);
		out.println("</b><hr>당신이 선택한 관심 분야 : <b>");
		
		for (String i : interests) {
			out.println(i + " ");
		}
		
		out.println("</b><br>");
		out.println("<a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
