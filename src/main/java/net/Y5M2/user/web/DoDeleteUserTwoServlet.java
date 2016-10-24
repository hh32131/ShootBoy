package net.Y5M2.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;

public class DoDeleteUserTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBiz userBiz;
    
    public DoDeleteUserTwoServlet() {
        super();
        userBiz = new UserBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = Param.getStringParam(request, "userId");
		
		boolean isSuccess = userBiz.deleteUserTwo(userId);
		
		if ( isSuccess ) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/ShootBoy/main");
		}
		else{
			response.sendRedirect("/ShootBoy/userInfo");
		}
		
	}

}
