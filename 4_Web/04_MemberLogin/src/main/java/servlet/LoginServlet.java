package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDAO;
import model.vo.Member;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.memberLogin(id,pwd);
			
		} catch (SQLException e) {
		
		}
		HttpSession session = request.getSession();
		session.setAttribute("longinMember", member);
		Cookie c1 = new Cookie("id", "pwd");
		
		
		if(member != null) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("views/login_fail.jsp");
		}
		
	}

}
