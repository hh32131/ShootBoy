package net.Y5M2.user.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;

public class DoCheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DoCheckEmail() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = Param.getStringParam(request, "email");
				
		boolean isSuccess = userBiz.isExsist(email);
		
		PrintWriter out = response.getWriter();
		out.print(isSuccess + "");
		out.flush();
		out.close();
		
	}

}