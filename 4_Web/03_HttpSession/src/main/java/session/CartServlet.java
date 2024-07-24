package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vo.Member;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("info");
		
		// request
		String notebook = (String)request.getAttribute("product");
		
		System.out.println(member);
		System.out.println(notebook);
		
		// 로그아웃! 즉 세션 정보 죽이기!
		
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}
