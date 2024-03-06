package unit05;

import java.awt.ItemSelectable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		
		String gender = request.getParameter("gender");
		String chk_mail = request.getParameter("chk_mail");
		String content = request.getParameter("content");
		String[] items = request.getParameterValues("item");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("당신이 입력한 정보입니다<hr>");
		out.println("성별 : <b>");
		out.println(gender);
		out.println("</b><br> 메일 정보 수신 여부 : <b>");
		out.println(chk_mail);
		out.println("</b><br> 취미 : <br><b>");
		
		for(String item : items) {
			out.println(item + " <br>");
		}
		
		out.println("</b>가입인사 : <b><pre>");
		out.println(content);
		
		out.println("</b></pre><a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
