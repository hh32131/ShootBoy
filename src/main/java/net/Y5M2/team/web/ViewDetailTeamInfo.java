package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.user.vo.UserVO;

public class ViewDetailTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewDetailTeamInfo() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);
		String viewPath = "/ShootBoy/view/team/detailTeamInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userInfo);
		rd.forward(request, response);
	}

}