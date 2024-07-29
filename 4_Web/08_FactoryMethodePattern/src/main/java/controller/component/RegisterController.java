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

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재 사용성이 강한 자바 클래스
 * 
 * */

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			return  new ModelAndView("views/sighUpResult.jsp");
		}else {
			return  new ModelAndView("views/sighUpResult.jsp",true);
		}
		
	
	}
	
		
		
		
	}


