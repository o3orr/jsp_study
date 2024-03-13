package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//저장경로
		String savaPath = "upload";
		
		//최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5*1024*1024;
		String encType="utf-8";
		
		ServletContext context = getServletContext();
		System.out.println(context);
		String uploadFilePath = context.getRealPath(savaPath); // 서버상 실제 폴더(디렉터리)
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, 
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy() //이름이 같은파일 새로운 이름 부여
					);
			
			// 업로드된 파일의 이름 얻기
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {
				System.out.println("파일 업로드 되지 않았음");
			} else {
				out.println("<br>글쓴이 : " + multi.getParameter("name"));
				out.println("<br>제목 : " + multi.getParameter("title"));
				out.println("<br>파일명 : " + fileName);
			}
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
