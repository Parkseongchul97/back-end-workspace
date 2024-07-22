package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		char gender = request.getParameter("gender").charAt(0);
		String[] menu = request.getParameterValues("menu");
		
		PrintWriter out =  response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<div>당신의 아이디는 "+ id +"</div><br>");
		out.println("<div>당신의 비밀번호는 "+ pwd +"</div><br>");
		
		String genderResult = null;
		if(gender == 'M') genderResult = "남자";
		else genderResult = "여자";
//		String genderResult = gender == 'M' ? "남자" : "여자" ; 이렇게 3항 연산자로 하면 위에 3줄을 1줄로 압축 가능 
		out.println("<div>당신의 성별은 " + genderResult+ " </div><br>");
		
		if(menu != null) {
		out.println("<ul>");
		for(String m : menu) {
			out.println("<li>"+ m +"</li>");	
		}out.println("</ul>");
		}else {
			out.println("당신은 좋아하는 음식이 없습니다...");
		}
		out.println("</html></body>");
	}

}
