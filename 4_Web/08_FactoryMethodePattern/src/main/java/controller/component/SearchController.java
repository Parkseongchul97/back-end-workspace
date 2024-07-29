package controller.component;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

			MemberDAO dao = new MemberDAO();
			String id = request.getParameter("id");
			Member member = null;
			member = dao.memberSearch(id);	
			if(member != null) {
				request.setAttribute("memberinfo", member);
				return new ModelAndView("views/search_ok.jsp") ;
			}else {
				return new ModelAndView("views/search_fail.jsp", true) ;
			}
		}

}
