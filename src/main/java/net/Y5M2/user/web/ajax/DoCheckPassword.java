package net.Y5M2.user.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class DoCheckPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoCheckPassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = Param.getStringParam(request, "password");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		PrintWriter out = response.getWriter();
		
		if(password.equals(userVO.getPassword())){
			out.print(" true ");
			out.flush();
			out.close();
		}
		else{
			out.print(" false ");
			out.flush();
			out.close();
		}
		
	}

}
