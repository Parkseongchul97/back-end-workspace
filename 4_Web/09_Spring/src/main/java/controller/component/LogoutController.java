package controller.component;

import java.io.IOException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.kh.model.vo.Member;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			
			HttpSession session = request.getSession();
			
			Member member = (Member)session.getAttribute("longinMember");
			if(member != null) 
				session.invalidate();
			
			
		
			
			return new ModelAndView ("index.jsp",true);
		
	}

}
