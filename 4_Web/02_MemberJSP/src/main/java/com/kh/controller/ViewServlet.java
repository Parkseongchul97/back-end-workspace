package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kh.model.vo.Member;
import com.kh.model.dao.MemberDAO;


@WebServlet("/view")// a태그 호출!
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO member = new MemberDAO();
		try {
			ArrayList<Member> list = member.listMember();
			// 바인딩
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		// 네비게이션  view.jsp
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
