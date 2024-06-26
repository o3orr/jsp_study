package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("TEST");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String [] major = request.getParameterValues("major");
		String agree = request.getParameter("agree");
		String memo = request.getParameter("memo");
		
		memo = memo.replaceAll("\n", "<br>");
		
		//해시코드 풀어주기
		String str = "";
		
		if(major != null) {
			for(String temp : major) {
				str += temp + " ";
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("이름: " + name + "<br>");
		out.println("아이디: " + id + "<br>");
		out.println("비밀번호: " + pwd + "<br>");
		out.println("성별: " + gender + "<br>");
		out.println("전화번호: " + tel1+"-"+tel2+"-"+tel3 + "<br>");
		out.println("전공: " + str + "<br>");
		out.println("동의여부: " + agree + "<br>");
		out.println("이름: " + name + "<br>");
	}

}
