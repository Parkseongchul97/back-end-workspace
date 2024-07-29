package controller.component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			MemberDAO dao = new MemberDAO();
			ArrayList<Member> list = null;
			list =  dao.memberAllInfo();
		
			request.setAttribute("memberList", list);
			return new ModelAndView("views/allMember.jsp") ;
			
		}
	}


