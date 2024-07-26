package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		Member member = new Member(id,pwd,name);
		
		MemberDAO dao = new MemberDAO();
		boolean ck = false;
		try {
			dao.memberSignUp(member);
			request.setAttribute("name", name);
			ck = true;
		} catch (SQLException e) {
			ck = false;
		}
		if(ck) {
			request.getRequestDispatcher("views/sighUpResult.jsp").forward(request, response);
		}else {
			response.sendRedirect("views/sighUpResult.jsp");
		}
	}

}
