package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoRemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserBiz userBiz;

	public DoRemoveUserServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = Param.getStringParam(request, "userId");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		
		boolean isSuccess = userBiz.deleteUser(userVO);
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/adminMember");
		}
		
	}
}
