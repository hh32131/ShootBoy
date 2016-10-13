package net.Y5M2.user.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.UserVO;

public class ViewPasswordFindPageServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;

	public ViewPasswordFindPageServletTwo() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = Param.getStringParam(request, "email");
		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		UserVO userInfo = userBiz.findPassword(userVO);
		
		String viewPath = "/WEB-INF/view/passwordFindTwo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userInfo);
		rd.forward(request, response);
		
		
	}

}
