package controller.component;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
			MemberDAO dao = new MemberDAO();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			Member member = null;
		    member = dao.memberLogin(id,pwd);
		
			HttpSession session = request.getSession();
			session.setAttribute("longinMember", member);
			Cookie c1 = new Cookie("id", "pwd");
			
			
			if(member != null) {
				return new ModelAndView("index.jsp", true) ;
			}else {
				return new ModelAndView("views/login_fail.jsp") ;
			}
		
	}

}
