package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vo.Member;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1. 폼 값 받는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		// DAO 생략... 로그인 성공 가정
		
		Member member = new Member(id, pwd, "테스트");
		
		// HttpSession
		// 1. 세션을 하나 받아온다
		HttpSession session = request.getSession();
		
		// 2. 세션에 바인딩
		session.setAttribute("info", member); // 세션은 객체가 들어감 키, 값 
		
		// 네비게이션
		
		response.sendRedirect("product"); // 세션에 정보 넘겨서 포워드 방식 대신 sendRedirect 방식으로 넘김		
//		request.getRequestDispatcher("/").forward(request, response);
	}

}














