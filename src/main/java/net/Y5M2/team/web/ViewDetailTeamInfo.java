package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public class ViewDetailTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	
	
	public ViewDetailTeamInfo() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);
		TeamVO teamInfo = teamBiz.getTeamAt(userInfo.getTeamId());
		String viewPath = "/WEB-INF/view/team/detailTeamInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("teamInfo", teamInfo);
		rd.forward(request, response);
	}

}
