package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/register")//폼태그 이름
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Controller - 비지니스 로직 작성 공간
		
		// index.jsp에서 /register로 요청하여 
		// 요청받은 아이디, 비밀번호, 이름을 받는다
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 1. (있으면)폼태그 값을 받아온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		

		// 2. DAO 호출 - DB접근 필요시
		MemberDAO member = new MemberDAO();
		request.setAttribute("name", name);
		boolean check = true;
		try {
			member.registerMember(id, pwd, name);
		} catch (SQLException e) {
			check = false;
			e.getMessage();
		}	
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response); //출력페이지
		
		
		
		
		
		
		
		// 4. 네비게이션 : 결과 페이지 지정 - result.jsp
		//response.sendRedirect("result.jsp");
		
		// 만약 결과 페이지로 서버에서 받은 값 보여주려면 
		// -> RequestDispatcher forward 방식으로 보내야함
		
	}

}
